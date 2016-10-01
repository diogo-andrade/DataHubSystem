package fr.gael.dhus.datastore.processing.products.sentinel1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.gael.dhus.datastore.processing.products.Sentinel;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by diogo on 19-07-2016.
 */
public class Sentinel1L1 implements Sentinel {
    private static final Logger LOGGER = Logger.getLogger (Sentinel1L1.class);
    private File _dir;

    public Sentinel1L1(File dir) {
        _dir = dir;
    }

    @Override
    public void generateRecipe() {
        LOGGER.info ("* Gerar receita...");
        List<String> imagesList = extractImagesLocationsFrom(_dir.getAbsolutePath());

        if (!imagesList.isEmpty()) {
            for (String imagePath : imagesList) {
                String coverageId = generateCoverageId(imagePath);
                LOGGER.info ("* FULL IMAGE PATH: " + coverageId);
                try {
                    JSONFileWrite(coverageId,imagePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void JSONFileWrite(String coverageId, String imagePath) throws IOException {
        Map<String, Object> obj = new LinkedHashMap<>();

        Map<String, Object> config = new LinkedHashMap<>();
        config.put("service_url", "http://104.196.28.216:8080/rasdaman/ows");
        config.put("tmp_directory", "/tmp/");
        config.put("crs_resolver", "http://kahlua.eecs.jacobs-university.de:8080/def");
        config.put("default_crs", "http://kahlua.eecs.jacobs-university.de:8080/def/crs/EPSG/0/4326");
        config.put("mock", false);
        config.put("automated", true);
        config.put("subset_correction",true);

        List<String> paths = new ArrayList<>();
        paths.add(imagePath);
        Map<String, Object> input = new LinkedHashMap<>();
        input.put("coverage_id", coverageId);
        input.put("paths", paths);

        List<String> band_names = new ArrayList<>();
        band_names.add("Gray");
        Map<String, Object> options = new LinkedHashMap<>();
        options.put("wms_import", true);
        options.put("band_names", band_names);

        Map<String, Object> recipe = new LinkedHashMap<>();
        recipe.put( "name", "map_mosaic");
        recipe.put("options", options);

        obj.put("config", config);
        obj.put("input", input);
        obj.put("recipe",recipe);

        try (FileWriter file = new FileWriter(_dir.getAbsolutePath()+ "/" + coverageId + ".json")) {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(obj);

            file.write(json);
        }
    }

    public String generateCoverageId(String url) {
        // extracts the file name from the url
        String fileName = (url.substring(url.lastIndexOf('/') + 1));
        // trims extension from the folder name
        String productName = _dir.getName();
        productName = productName.substring(0, productName.lastIndexOf('.'));

        String polarisation = extractPolarisationTypeFrom(fileName);

        return productName + "_" + polarisation;
    }

    public String extractPolarisationTypeFrom(String fileName){
        String polarisation = null;

        if(fileName.contains("-vv-")){
            polarisation = "VV";
        } else if (fileName.contains("-hh-")) {
            polarisation = "HH";
        } else if (fileName.contains("-hv-")) {
            polarisation = "HV";
        } else if (fileName.contains("-vh-")) {
            polarisation = "VH";
        }

        return polarisation;
    }

    public List<String> extractImagesLocationsFrom(String folderAbsPath) {

        List<String> imagesLocationsList = new ArrayList<>();

        try {
            File inputFile = new File(folderAbsPath + "/manifest.safe");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;

            dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            XPath xPath =  XPathFactory.newInstance().newXPath();

            String expression = "//dataObject[@repID='s1Level1MeasurementSchema']/byteStream/fileLocation";
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    // removes the dot from the string
                    String href = eElement.getAttribute("href").substring(1);

                    // builds the absolute path for each image and add to the list
                    String imagePath = folderAbsPath + href;
                    imagesLocationsList.add(imagePath);

                    //LOGGER.info ("* File location : " +  imagePath);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return imagesLocationsList;
    }
}

package fr.gael.dhus.datastore.processing;

import java.io.File;
import java.io.IOException;

import fr.gael.dhus.database.object.Product;
import org.apache.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import fr.gael.dhus.util.UnZip;

/**
 * Created by diogo on 05-07-2016.
 */

@Component
public class RasdamanFeeder {
    private static final Logger LOGGER = Logger.getLogger (RasdamanFeeder.class);
    private Dispatcher dispatcher;

    RasdamanFeeder() {
        dispatcher = new Dispatcher();
    }

    public void process(Product product) {
        String productPath = product.getPath().toString();
        productPath  = productPath.replaceAll ("file:/", "/");
        Boolean isZip = false;
        File zipFile = new File(productPath);
        File unzipFile = null;
        String unzipFileName = null;
        String unzipFilePath = productPath;

        String request = inferProductInfo(zipFile);

        if (request != null) {
            LOGGER.info ("* Sending to Rasdaman: "+ zipFile.getPath());

            // Products ingested by File Scanner
            // * Needs to be unziped
            if(zipFile.getPath().endsWith(".zip")) {
                try {
                    if (UnZip.supported(zipFile.getPath()))
                        UnZip.unCompress(zipFile.getPath(), zipFile.getParent());
                    unzipFileName = zipFile.getName().replaceAll(".zip", ".SAFE");
                    unzipFilePath = zipFile.getParent()+ "/" + unzipFileName;
                    isZip = true;
                } catch (Exception e) {
                    LOGGER.error("Failure during decompression.", e);
                }
            }

            // Products ingested by Ad-hoc upload don't need to be unziped because they already are a .SAFE file

            unzipFile = new File (unzipFilePath);

            // Dispatch the product accordingly to the type and level
            dispatcher.dispatch(request,unzipFile);


            // Products ingested by File Scanner
            // * after unzipped is necessary to delete the ".SAFE" file
           if(isZip && unzipFile.exists() && unzipFile.isDirectory()) {
                try {
                    LOGGER.info ("* Delete extracted files: " + unzipFilePath);
                    FileUtils.deleteDirectory(unzipFile);
                } catch (IOException e) {
                    LOGGER.info ("* Booooom!");
                    e.printStackTrace();
                }
            }
        }
    }

    private String inferProductInfo(File file){
        String productName = file.getName().toString();
        String productMission = productName.substring(0, 2);
        String productLevel = "L";
        String result = null;

        if(productMission.contains("1")) {
            String productType = productName.substring(7, 10);
            if(productType.contains("GRD")) { // Only matters GRD products
                productMission = "S1";
                productLevel += Character.toString(productName.charAt(12));
                result = productMission.concat(productLevel);
            }
        }/* else if (productMission.contains("2")) {
            productMission = "S2";
            productLevel += Character.toString(productName.charAt(17));
            result = productMission.concat(productLevel);
        }*/

        return result;
    }
}

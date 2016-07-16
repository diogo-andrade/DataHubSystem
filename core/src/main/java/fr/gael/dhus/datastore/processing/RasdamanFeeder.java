package fr.gael.dhus.datastore.processing;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    public void process(Product product) {
        String productPath = product.getPath().toString();
        productPath  = productPath.replaceAll ("file:/", "/");
        File zipFile = new File(productPath);
        File unzipFile = null;
        String unzipFileName = null;
        String unzipFilePath = productPath;

        LOGGER.info ("* Sending to Rasdaman: "+ zipFile.getPath());

        // if the file is ziped enters in this block to unzip
        if(zipFile.getPath().endsWith(".SAFE")) {
            try {
                if (UnZip.supported(zipFile.getPath()))
                    UnZip.unCompress(zipFile.getPath(), zipFile.getParent());
                    unzipFileName = zipFile.getName().replaceAll(".zip", ".SAFE");
                    unzipFilePath = zipFile.getParent()+ "/" + unzipFileName;
            } catch (Exception e) {
                LOGGER.error("Failure during decompression.", e);
            }
        }


        unzipFile = new File (unzipFilePath);
        if(unzipFile.exists() && unzipFile.isDirectory()) {
            try {
                LOGGER.info ("* Delete extracted files: " + unzipFilePath);
                FileUtils.deleteDirectory(unzipFile );
            } catch (IOException e) {
                LOGGER.info ("* Booooom!");
                e.printStackTrace();
            }
        }
    }
}

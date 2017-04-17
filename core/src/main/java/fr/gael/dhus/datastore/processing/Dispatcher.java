package fr.gael.dhus.datastore.processing;

import fr.gael.dhus.datastore.processing.products.Sentinel;
import fr.gael.dhus.datastore.processing.products.sentinel1.Sentinel1L1;
import fr.gael.dhus.datastore.processing.products.sentinel2.Sentinel2L1;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.io.FileUtils;

/**
 * Created by diogo on 19-07-2016.
 */
public class Dispatcher {
    private static final Logger LOGGER = Logger.getLogger (Dispatcher.class);
    private final ReentrantLock lock = new ReentrantLock();

    Sentinel sentinel;
    File directory;

    public Dispatcher() {
        sentinel = null;
    }

    public void dispatch(String request, File file){
        directory = file;
        LOGGER.info ("* Produto Type: " +  request);

        switch (request) {
            case "S1L1":
                sentinel = new Sentinel1L1(file);
                break;
            case "S2L1":
                sentinel = new Sentinel2L1(file);
                break;
            default:
        }
        sentinel.generateRecipe();

        // Locate all json files
        List<File> recipes = new ArrayList(FileUtils.listFiles(directory, new WildcardFileFilter("*.json"), null));
        // Do the ingestion in Rasdaman
        runWCSTImport(recipes);
    }

    private void runWCSTImport(List<File> recipes) {

        for(File recipe : recipes) {
            lock.lock();
            try {
                LOGGER.info ("* WCSIMPORT recipe: " +  recipe.getAbsolutePath());
                String fileToRemove = recipe.getAbsolutePath().substring(0, recipe.getAbsolutePath().lastIndexOf('.'));
                String[] commands = {
                        "wcst_import.sh " + recipe.getAbsolutePath(),
                        "rm " + fileToRemove + ".tif " + fileToRemove + ".json " + fileToRemove + ".resume.json"
                };
                Runnable worker = new WorkerThread(commands);
                worker.run();
            } finally {
                lock.unlock();
            }
        }
    }
}

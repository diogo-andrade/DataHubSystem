package fr.gael.dhus.datastore.processing.products.sentinel2;

import fr.gael.dhus.datastore.processing.products.Sentinel;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.List;

/**
 * Created by diogo on 19-07-2016.
 */
public class Sentinel2L1 implements Sentinel {
    private static final Logger LOGGER = Logger.getLogger (Sentinel2L1.class);

    private File dir;
    private List<String> imagesList;

    public Sentinel2L1(File dir) {
        this.dir = dir;
        this.imagesList = null;
    }

    @Override
    public void generateRecipe() {
        LOGGER.info ("* Gerar receita...");
    }

    @Override
    public List<String> getImagesList(){
        return this.imagesList;
    }
}

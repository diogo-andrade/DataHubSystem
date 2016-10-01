package fr.gael.dhus.datastore.processing.products.sentinel2;

import fr.gael.dhus.datastore.processing.products.Sentinel;
import org.apache.log4j.Logger;

import java.io.File;

/**
 * Created by diogo on 19-07-2016.
 */
public class Sentinel2L1 implements Sentinel {
    private static final Logger LOGGER = Logger.getLogger (Sentinel2L1.class);

    private File _dir;

    public Sentinel2L1(File dir) {
        _dir = dir;
    }

    @Override
    public void generateRecipe() {
        LOGGER.info ("* Gerar receita...");
    }
}

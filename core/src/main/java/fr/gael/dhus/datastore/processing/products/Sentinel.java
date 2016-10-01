package fr.gael.dhus.datastore.processing.products;

import java.util.List;

/**
 * Created by diogo on 19-07-2016.
 */
public interface Sentinel {

    void generateRecipe();

    List<String> getImagesList();
}

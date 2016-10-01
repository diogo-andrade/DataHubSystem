package fr.gael.dhus.datastore.processing;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by diogo on 01-10-2016.
 */

public class WorkerThread implements Runnable {

    private String file;

    public WorkerThread(File file){
        this.file = file.getAbsolutePath();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Command = "+ file);

        try {
            processRasters();
            executeWCSTImport();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    private String processRasters() throws IOException, InterruptedException {
        StringBuffer output = new StringBuffer();
        String tmpFile = file+".tmp";

        Process p;

        p = Runtime.getRuntime().exec("gdalwarp -t_srs EPSG:4326 "+ file + " " + tmpFile + " && rm " + file + " && gdal_translate -co COMPRESS=LZW -co TILED=YES -ot byte "+ tmpFile + " " + file);
        p.waitFor();
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line;
        while ((line = reader.readLine())!= null) {
            output.append(line + "\n");
        }

        return output.toString();
    }

    private String executeWCSTImport() throws IOException, InterruptedException {
        StringBuffer output = new StringBuffer();

        Process p;
        p = Runtime.getRuntime().exec("wcst_import "+ file);
        p.waitFor();
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line;
        while ((line = reader.readLine())!= null) {
            output.append(line + "\n");
        }

        return output.toString();
    }

    @Override
    public String toString() {
        return this.file;
    }
}

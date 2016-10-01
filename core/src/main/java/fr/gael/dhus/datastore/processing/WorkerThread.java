package fr.gael.dhus.datastore.processing;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by diogo on 01-10-2016.
 */

public class WorkerThread implements Runnable {

    private String command;

    public WorkerThread(String command){
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Command = "+ command);

        try {
            processCommand();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    private String processCommand() throws IOException, InterruptedException {
        StringBuffer output = new StringBuffer();

        Process p;

       // p = Runtime.getRuntime().exec("gdalwarp -t_srs EPSG:4326 "+ file + " " + tmpFile + " && rm " + file + " && gdal_translate -co COMPRESS=LZW -co TILED=YES -ot byte "+ tmpFile + " " + file);
        p = Runtime.getRuntime().exec(command);

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
        return this.command;
    }
}

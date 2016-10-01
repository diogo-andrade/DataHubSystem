package fr.gael.dhus.datastore.processing;

import org.apache.log4j.Logger;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by diogo on 01-10-2016.
 */

public class WorkerThread implements Runnable {
    private static final Logger LOGGER = Logger.getLogger (WorkerThread.class);

    private String[] commands;

    public WorkerThread(String[] commands){
        this.commands = commands;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. " +'\n');

        try {
            for (String command : commands) {
                LOGGER.info(processCommand(command));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    private String processCommand(String command) throws IOException, InterruptedException {
        StringBuffer output = new StringBuffer();
        StringBuffer erroroutput = new StringBuffer();

        Process p;

       // p = Runtime.getRuntime().exec("gdalwarp -t_srs EPSG:4326 "+ file + " " + tmpFile + " && rm " + file + " && gdal_translate -co COMPRESS=LZW -co TILED=YES -ot byte "+ tmpFile + " " + file);
        p = Runtime.getRuntime().exec(command);

        int exitValue = p.waitFor();

        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line;
        while ((line = reader.readLine())!= null) {
            output.append(line + "\n");
        }
        reader.close();

        BufferedReader errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));

        while ((line = errorReader.readLine()) != null) {
            System.out.println(line);
        }

        errorReader.close();

        if (exitValue != 0) {
            output = erroroutput;
            System.out.println("Abnormal process termination");
        }

        return output.toString();
    }

}

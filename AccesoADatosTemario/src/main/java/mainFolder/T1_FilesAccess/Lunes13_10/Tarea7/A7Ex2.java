package mainFolder.T1_FilesAccess.Lunes13_10.Tarea7;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class A7Ex2 {

    static File file = new File("application.properties");
    static Properties properties = new Properties();

    public static void main(String[] args) {


        if (!file.exists()){

            properties.setProperty("server.max-file-size","10000");
            properties.setProperty("server.max-requests","10");
            properties.setProperty("server.launcher","false");
            properties.setProperty("server.buffer.size","1024");

            try (FileOutputStream out = new FileOutputStream(file)){

                properties.store(out,"Test");


            }catch (IOException e){

                System.out.println("ERROR: " + e);

            }

            System.out.println("Fichero maximo: " + maxFile());

        }

    }

    public static String maxFile(){

        return  properties.getProperty("server.max-file-size");

    }

}

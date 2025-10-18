package mainFolder.A7;

import java.io.*;
import java.time.LocalDate;
import java.util.Properties;

public class A7Ex2 {

    private static final String CONF_FILE = "./application.properties";
    private static Properties properties = new Properties();
    private static boolean loaded = false;

    public static void main(String[] args) {

        loadProperties();

        System.out.println("Fichero maximo: " + maxFile());
        System.out.println("Hay que lanzar Launch?: " + statusLaunch());
        setProperties("server.launcher","true","Esto es un test , para cambiar parametro");
        showAllProperties();

    }

    public static void loadProperties(){

        if (loaded) return;//Si el archivo existe , no vamos a comprobar nada

        File file = new File(CONF_FILE);//Generamos archivo
        if (!file.exists()){//Si no existe se crea, con valores definidos.


            properties.setProperty("server.max-file-size","10000");
            properties.setProperty("server.max-requests","10");
            properties.setProperty("server.launcher","false");
            properties.setProperty("server.buffer.size","1024");

            try (FileOutputStream out = new FileOutputStream(CONF_FILE)){

                properties.store(out,"Archivo de configuracion creado en: " + CONF_FILE);


            }catch (IOException e){

                System.out.println("ERROR: " + e);

            }

            System.out.println("Fichero por defecto creado...");

        }else {

            try (FileInputStream fis = new FileInputStream(file)){//Cargamos el archivo, ponemos loaded en true, para que no vuelva a cargalo.

                properties.load(fis);
                loaded = true;
                System.out.println("Fichero " + CONF_FILE + " cargando en memoria...");

            }catch (IOException e){

                System.out.println("ERROR: " + e);

            }

        }

    }

    public static String maxFile(){

        return  properties.getProperty("server.max-file-size");//Filtramos por la propiedad de configuracion especifica.

    }

    public static String statusLaunch(){//Filtramos por el parametro de configuracion especifico

        return properties.getProperty("server.launcher");

    }

    public static void setProperties(String key, String value, String comment){

        try {

            try (FileInputStream fis = new FileInputStream(CONF_FILE)){

                properties.load(fis);//Cargamos el archivo.

            }

            properties.setProperty(key, value);//Cambiamos el valor del properties, con la key y el nuevo valor.

            try (FileOutputStream fs = new FileOutputStream(CONF_FILE)){//Cargamos el archivo en una ruta

                properties.store(fs,"Modificado: " + LocalDate.now() + ". Comment: " + comment);//Guardamos con el mensaje de comentario y la fecha actual/
                System.out.println("Propiedad " + key + " actualizada a: " + value);//Imprimimos el cambio.

            }

        } catch (IOException e){

            System.out.println("ERROR: " + e);

        }

    }

    public static void showAllProperties(){

        System.out.println("PROPIEDADES DEL ARCHIVO: " + CONF_FILE);
        System.out.println("__________________________________________");
        properties.forEach((key , value) -> System.out.println(key + "=" + value));//Recorremos el fichero por key y value. Se imprime.

    }

}

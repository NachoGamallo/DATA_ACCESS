package mainFolder.T2_AccesoABBDDRelacionales.Practica1ConexionYLogin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class generateConfigFile {

    static Properties prop = new Properties();
    private static final String CONF_FILE = "./bbddPractica1.properties";
    private static boolean loaded = false;

    public static void loadProperties(){

        if (loaded) return;

        File file = new File(CONF_FILE);
        if (!file.exists()){

            prop.put("db.url","jdbc:postgresql://localhost:5432/practica");
            prop.put("db.user","postgres");
            prop.put("db.password","postgres");
            prop.put("db.driver","org.postgresql.Driver");

            try (FileOutputStream out = new FileOutputStream(CONF_FILE)){

                prop.store(out,"Archivo de configuracion creado en: " + CONF_FILE);

            }catch (IOException e){

                System.out.println("ERROR: " + e);

            }

        }else {

            try (FileInputStream fis = new FileInputStream(CONF_FILE)){

                prop.load(fis);
                loaded = true;

            }catch (IOException e){

                System.out.println("ERROR: " + e);

            }

        }

    }

}

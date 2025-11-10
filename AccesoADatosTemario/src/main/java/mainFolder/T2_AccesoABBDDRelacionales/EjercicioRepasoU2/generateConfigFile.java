package mainFolder.T2_AccesoABBDDRelacionales.EjercicioRepasoU2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class generateConfigFile {

    static Properties pr = new Properties();
    static final String CONF_FILE = "./main/resources/bbddMovileApps.properties";
    private static boolean loaded = false;

    public static void loadProperties() {

        if (loaded) return;

        File file = new File(CONF_FILE);
        if (!file.exists()){

            pr.put("db.url","jdbc:postgresql://localhost:5432/AppsMoviles");
            pr.put("db.user","postgres");
            pr.put("db.password","postgres");

            try (FileOutputStream out = new FileOutputStream(CONF_FILE)){

                pr.store(out,"Archivo de configuracion creado en: " + CONF_FILE);

            }catch (IOException e){

                System.out.println("ERROR: " + e);

            }

        }else {

            try (FileInputStream fis = new FileInputStream(CONF_FILE)){

                pr.load(fis);
                loaded = true;

            }catch (IOException e){

                System.out.println("ERROR: " + e);

            }

        }

    }

}

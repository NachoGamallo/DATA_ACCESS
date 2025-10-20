package mainFolder.T1_FilesAccess.PreExam;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;

public class JSONTest {

    static File file = new File("./src/test/Files/test/TestJSON.json");

    public static void main(String[] args) {

        createJSON(file);
        readJSON(file);

    }

    public static void createJSON(File url){

        LinkedHashMap <String, Object> shop2 = new LinkedHashMap<>();
        LinkedHashMap <String, Object> moviles1 = new LinkedHashMap<>();
        LinkedHashMap <String, Object> moviles2 = new LinkedHashMap<>();

        shop2.put("country","ES");
        shop2.put("currency","EUR");
        shop2.put("total",2);
        shop2.put("source","catalogo");

        //-----------------------------------

        moviles1.put("id",1);
        moviles1.put("year",2023);
        moviles1.put("brand","apple");
        moviles1.put("category","Gama alta");

        //------------------------------------

        moviles2.put("id",2);
        moviles2.put("year",2024);
        moviles2.put("brand","Samsung");
        moviles2.put("category","Gama alta");

        JSONObject shop = new JSONObject(shop2);

        JSONArray moviles = new JSONArray()
                .put(new JSONObject(moviles1))
                .put(new JSONObject(moviles2));

        shop.put("moviles",moviles);

        try (FileWriter fw = new FileWriter(url)){

            fw.write(shop.toString(4));
            fw.flush();

        }catch (IOException e){

        }

    }

    public static void readJSON(File url){

        try (BufferedReader br = new BufferedReader(new FileReader(url))) {

            String line;

            while ((line = br.readLine()) != null){

                System.out.println(line);
            }


        }catch (IOException e){}

    }

    public static void modifyJSON(String url){}

}

package mainFolder.T1_FilesAccess.Lunes29_09;

import java.io.FileWriter;
import java.io.IOException;

public class TestEscrituraDeCaracteres {

    public static void main(String[] args) {

        String str = "Este es un ejemplo de una escritura usando el FileWriter";

        try {

            FileWriter fw = new FileWriter("./src/test/Files/test.txt");
            fw.write(str);
            fw.close();

        }catch (IOException e){
            System.out.println("Error: " +  e);

        }

    }

}

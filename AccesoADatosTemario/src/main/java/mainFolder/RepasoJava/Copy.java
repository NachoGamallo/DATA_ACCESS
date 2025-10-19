package mainFolder.RepasoJava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {

    public static void main(String[] args) throws IOException {

        copy("src/test/Files/Origen","src/test/Files/Destino");

    }

    public static void copy(String origin , String destiny) {

        try (FileInputStream in = new FileInputStream(origin);
        FileOutputStream out = new FileOutputStream(destiny, true)){

        byte[] buffer = new byte[1024]; //Esto indica el tamaño del bloque de lectura.

        int actualByte;

        while ((actualByte = in.read(buffer)) != -1){

            out.write(buffer,0, actualByte);

        }

        System.out.println("Copia completada: " + origin + " copiado en: " + destiny);

        } catch (IOException e){

            System.out.println("ERROR: " + e.getMessage());

        }

    }

}

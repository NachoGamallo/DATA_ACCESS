package mainFolder;

import java.io.File;
import java.io.IOException;

public class DontDeleteFile {

    public static void main(String[] args) {

        File archivo = new File("src/test/Files/DontDelete");

        if (archivo.exists()) {

            System.out.println("El archivo ya existe. No se sobrescribirá.");

        } else {

            try {

                if (archivo.createNewFile()) {

                    System.out.println("Archivo creado: " + archivo.getName());

                }

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

    }

}

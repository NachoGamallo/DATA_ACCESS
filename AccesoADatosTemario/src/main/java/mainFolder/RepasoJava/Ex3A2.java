package mainFolder.RepasoJava;

import java.io.*;

public class Ex3A2 {
    public static void main(String[] args) {

        limpiarArchivo("src/test/Files/ArchivoConEspacios","src/test/Files/ArchivoCorregido");

    }

    public static void limpiarArchivo(String origen, String destino) {

        try (BufferedReader br = new BufferedReader(new FileReader(origen));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destino))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                linea = linea.trim().replaceAll("\\s+", " "); // elimina espacios extra
                bw.write(linea);
                bw.newLine();

            }

            System.out.println("Archivo limpiado y guardado en " + destino);

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}

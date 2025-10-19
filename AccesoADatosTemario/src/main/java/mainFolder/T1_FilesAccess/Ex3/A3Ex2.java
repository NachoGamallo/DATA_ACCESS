package mainFolder.T1_FilesAccess.Ex3;

import java.io.*;
import java.util.Scanner;

public class A3Ex2 {

    static Scanner entry = new Scanner(System.in);
    static File file = new File("./text.txt");

    public static void main(String[] args) {

        if (!file.exists()) {
            try (PrintWriter pw = new PrintWriter(file)) {

                pw.println("Hola mundo, este es un fichero de texto.");
                pw.println("Hay veces que un hombre debe de hacer, lo que debe de hacer");
                pw.println("Adios , mis aliados...");

                System.out.println("Fichero de texto creado con contenido de ejemplo.");
                System.out.println("===========================================================");

            } catch (IOException e) {

                System.out.println("ERROR: " + e);

            }
        }

        System.out.print("Introduce la palabra a buscar: ");
        String word = entry.nextLine();

        File temp = new File("./temp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter(temp))){

            String line;
            while ((line = br.readLine()) != null){

                if (line.contains(word)){

                    line = line.replace(word,word.toUpperCase());

                }

                bw.write(line);
                bw.newLine();

            }

        } catch (IOException e){

            System.out.println("ERROR: " + e);

        }

        if (file.delete()){

            temp.renameTo(file);
            System.out.println("Contenido actualizado con exito.");

        }else {

            System.out.println("Hubo un problema al remplazar el contenido...");
        }

    }

}

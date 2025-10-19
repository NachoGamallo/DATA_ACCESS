package mainFolder.T1_FilesAccess.Lunes29_09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionarNombres {

    static Scanner entry = new Scanner(System.in);

    public static void main(String[] args) {

        String url = "./src/test/Files/Ex1Files.txt";

        try {

            writeNamesAtBeginning(url);


        }catch (IOException e){

            System.out.println("ERROR: " + e );

        }
    }

    private static void writeNamesAtEnd(String path) throws IOException{



    }
    private static void writeNamesAtBeginning(String path) throws IOException{

        List <String> line = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(path))) {

            String lineTemp;
            while ((lineTemp = reader.readLine()) != null){
                line.add(lineTemp);
            }

            reader.close();


        }catch (IOException e){

            System.out.println("ERROR: " + e);

        }

        try (BufferedWriter writes = new BufferedWriter(
                new FileWriter(path))){

            System.out.println("Introduce tu nombre: ");
            writes.write(entry.next());

            for (String temp : line){
                writes.newLine();
                writes.write(temp);
            }

            writes.close();


        }catch (IOException e){

            System.out.println("Error: " + e);

        }

    }
    private static void showContent(String path) throws IOException{



    }

}



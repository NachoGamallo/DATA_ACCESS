package mainFolder;

import java.io.*;
import java.util.Scanner;

public class Ex1A2 {

    static Scanner entry = new Scanner(System.in);

    public static void main(String[] args) {

        saveOperation("src/test/Files/Operaciones");
        System.out.println("Contenido del archivo: " + readOperation("src/test/Files/Operaciones"));
    }

    public static void saveOperation(String fileName) {

        System.out.print("Introduce el primer número: ");
        int num1 = entry.nextInt();
        System.out.print("Introduce el segundo número: ");
        int num2 = entry.nextInt();

        int resultado = num1 + num2;
        String operacion = num1 + " + " + num2 + " = " + resultado;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            bw.write(operacion);
            System.out.println("Operación guardada en " + fileName);

        } catch (IOException e) {

            System.out.println("Error al escribir: " + e.getMessage());

        }

    }

    public static String readOperation(String path){

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            return br.readLine();

        } catch (IOException e) {

            return "Error al leer: " + e.getMessage();

        }

    }

}

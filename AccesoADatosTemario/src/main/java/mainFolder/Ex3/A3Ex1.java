package mainFolder.Ex3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class A3Ex1 {

    static Scanner entry = new Scanner(System.in);
    static File file = new File("./enteros.dat");

    public static void main(String[] args) {

        if (!file.exists()){

            try (RandomAccessFile raf = new RandomAccessFile(file,"rw")){

                for (int i = 1; i <= 10; i ++ ){

                    raf.writeInt(i * 10);

                }

                System.out.println("FICHERO DE PRUEBA CREADO.");

            } catch (IOException e){

                System.out.println("ERROR: " + e);

            }

        }

        try (RandomAccessFile raf = new RandomAccessFile(file,"rw")){

            long nums = raf.length() / 4;
            System.out.println("El fichero contiene " + nums + " numeros enteros.");
            System.out.println("====================================================");
            System.out.println("Introduce la posicion del entero a modificar (" + nums + ")");

            int userPos = entry.nextInt();

            if (userPos < 1 || userPos >nums){

                System.out.println("Posicion fuera de rango");

            }else {

                long pos = (userPos - 1) * 4;
                raf.seek(pos);

                int actualValue = raf.readInt();
                System.out.println("Valor actual: " + actualValue);
                System.out.println("Introduce el nuevo valor: ");
                int newValue = entry.nextInt();

                raf.seek(pos);
                raf.writeInt(newValue);

                System.out.println("Valor modificado correctamente.");
            }

        } catch (IOException e){

            System.out.println("ERROR: " + e);
        }

    }

}

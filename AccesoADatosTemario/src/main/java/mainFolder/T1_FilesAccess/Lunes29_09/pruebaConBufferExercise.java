package mainFolder.T1_FilesAccess.Lunes29_09;

import java.io.*;

public class pruebaConBufferExercise {

    public static void main(String[] args) {
        int cantidadDatos = 1000000; // Un millón de enteros

        long inicioConBuffer = System.currentTimeMillis();

        try {
            DataOutputStream dosBuff = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("./src/test/Files/con_buffer.bin")
                    )
            );

            for (int i = 0; i < cantidadDatos; i++) {
                dosBuff.writeInt(i); // Escribir enteros en el archivo
            }

            dosBuff.close();

            DataInputStream dis = new DataInputStream(
                    new FileInputStream("./src/test/Files/con_buffer.bin"));

            int readInt = dis.readInt();
            System.out.println("Int leido: " + readInt);

            char readChar = dis.readChar();
            System.out.println("Char leido: " + readChar);

            int readByte;

            while ((readByte = dis.readByte()) != -1){

                System.out.print((char) readByte);

            }
            System.out.println("\n");

            dis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        long finConBuffer = System.currentTimeMillis();
        System.out.println("Tiempo con BufferedOutputStream: " +
                (finConBuffer - inicioConBuffer) + " ms");
    }
}

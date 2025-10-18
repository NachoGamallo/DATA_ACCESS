package org.example.Lunes29_09;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class pruebaSinBufferExercise {
    public static void main(String[] args) {
        int cantidadDatos = 1000000; // Un millón de enteros

        long inicioSinBuffer = System.currentTimeMillis();

        try {
            DataOutputStream dos = new DataOutputStream(
                    new FileOutputStream("./src/test/Files/sin_buffer.bin")
            );

            for (int i = 0; i < cantidadDatos; i++) {
                dos.writeInt(i); // Escribir enteros en el archivo
            }

            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long finSinBuffer = System.currentTimeMillis();
        System.out.println("Tiempo con DataOutputStream: " +
                (finSinBuffer - inicioSinBuffer) + " ms");
    }
}

package mainFolder.T1_FilesAccess.Martes30_09;

// RECURSO:
// cualquier objeto externo que ocupa recursos del sistema operativo
// (memoria, disco, red…) y que necesita cerrarse al terminar.

// try-with-resources
// try (declaración de recurso) { uso del recurso }
// → Java cierra el recurso al salir del bloque.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EjemploTryWithResources {

    // Método que lee la primera línea de un archivo de texto
    public static void leerArchivo() {
        // try-with-resources: abrimos el recurso "lectorArchivo"
        // Java lo cerrará automáticamente al salir del try
        try (BufferedReader lectorDeArchivoTxt = new BufferedReader(new FileReader("archivo.txt"))) {

            // Usamos el recurso: leemos una línea y la mostramos por pantalla
            String linea = lectorDeArchivoTxt.readLine();
            System.out.println("Primera línea del archivo: " + linea);

        } catch (IOException e) {
            // Si ocurre un error (por ejemplo, el archivo no existe), se captura aquí
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        // Al salir del bloque try, Java ejecuta automáticamente lectorDeArchivoTxt.close()
    }

    public static void main(String[] args) {
        leerArchivo();
    }
}

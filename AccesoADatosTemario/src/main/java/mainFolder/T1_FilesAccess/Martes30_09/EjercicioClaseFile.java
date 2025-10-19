// Ejercicio página 40

package mainFolder.T1_FilesAccess.Martes30_09;

import java.io.File;
import java.io.IOException;

public class EjercicioClaseFile {
    public static void main(String[] args) {
        try {
            // PARTE 1. Crear un nuevo archivo

            // File: No se crea todavía el fichero en disco
            // Se crea un objeto de tipo File que representa una ruta (en este caso, "ejemplo.txt")
            // Ese objeto es como un “puntero” -->
            // sabe dónde está el fichero (path), pero no es el archivo real.
            File archivo = new File("ejemplo.txt");

            System.out.println("\n - Ejercicio de la Clase FILE");


            // createNewFile() --> Si el fichero no existe, lo crea vacío en esa ruta y devuelve true
            if (archivo.createNewFile()) {
                System.out.println("- Archivo creado: " + archivo.getName());
            } else {
                System.out.println("- El archivo ya existe.");
            }

            // 2. Crear un nuevo directorio

            // File: Crea un objeto "directorio" que apunta a la ruta
            // ‘MiDirectorio’ que aún no existe en disco hasta llamar a mkdir()
            File directorio = new File("MiDirectorio");
            if (directorio.mkdir()) {
                System.out.println("- Directorio creado: " + directorio.getName());
            } else {
                System.out.println("- El directorio ya existe.");
            }

            // 3. Listar el contenido de un directorio

            // File: Crea un objeto File que representa la ruta del directorio actual ".",
            // (la carpeta donde se está ejecutando el programa).

            File carpetaActual = new File(".");

            // Devuelve un array con todos los ficheros y subdirectorios que hay dentro de esa carpeta.
            String[] lista = carpetaActual.list();
            System.out.println("- Contenido del directorio actual:");
            for (String nombre : lista) {
                System.out.println("- " + nombre);
            }

            // 4. Eliminar un archivo
            if (archivo.delete()) {
                System.out.println("- Archivo eliminado.");
            } else {
                System.out.println("- No se pudo eliminar el archivo.");
            }

            // 5. Renombrar un archivo
            File archivoViejo = new File("viejo.txt");
            archivoViejo.createNewFile();
            File archivoNuevo = new File("nuevo.txt");
            if (archivoViejo.renameTo(archivoNuevo)) {
                System.out.println("- Archivo renombrado a: " + archivoNuevo.getName());
            } else {
                System.out.println("- No se pudo renombrar.");
            }

            // 6. Verificar si un archivo existe
            if (archivoNuevo.exists()) {
                System.out.println("El archivo " + archivoNuevo.getName() + " existe.");
            } else {
                System.out.println("El archivo no existe.");
            }

            // 7. Inspeccionar propiedades de archivos y directorios
            inspeccionarPropiedades(archivoNuevo);
            inspeccionarPropiedades(directorio);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Método para inspeccionar propiedades de un File (archivo o directorio)
    public static void inspeccionarPropiedades(File f) {
        System.out.println("\n--- Propiedades de: " + f.getName() + " ---");
        System.out.println("- Ruta absoluta: " + f.getAbsolutePath());
        System.out.println("- ¿Es un archivo?: " + f.isFile());
        System.out.println("- ¿Es un directorio?: " + f.isDirectory());
        System.out.println("- Tamaño (bytes): " + f.length());
        System.out.println("- ¿Se puede leer?: " + f.canRead());
        System.out.println("- ¿Se puede escribir?: " + f.canWrite());
        System.out.println("- ¿Se puede ejecutar?: " + f.canExecute());
        System.out.println("- ¿Existe?: " + f.exists());
    }
}

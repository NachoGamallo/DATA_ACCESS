package mainFolder.T1_FilesAccess.Martes30_09;

import java.io.IOException;
import java.nio.file.*;

public class EjercicioClasePathYFiles {
    public static void main(String[] args) {
        try {

            System.out.println("\n - Ejercicio de la Clase Path y Files");

            // 1. Crear un nuevo archivo
            // Creamos un objeto Path que apunta al archivo
            Path archivo = Paths.get("archivoPathYFiles.txt");
            if (Files.notExists(archivo)) {
                // Creamos el archivo físico vacío
                Files.createFile(archivo);
                System.out.println("- Archivo creado: " + archivo.getFileName());
            } else {
                System.out.println("- El archivo ya existe.");
            }

            // 2. Crear un nuevo directorio

            // Creamos un objeto Path para el directorio
            Path directorio = Paths.get("MiDirectorio");
            if (Files.notExists(directorio)) {
                Files.createDirectory(directorio);
                System.out.println("- Directorio creado: " + directorio.getFileName());
            } else {
                System.out.println("- El directorio ya existe.");
            }

            // 3. Listar el contenido de un directorio
            Path carpetaActual = Paths.get(".");
            System.out.println("- Contenido del directorio actual:");
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(carpetaActual)) {
                // Recorremos cada elemento de la carpeta
                for (Path ruta : stream) {
                    System.out.println("- " + ruta.getFileName());
                }
            }

            // 4. Eliminar un archivo
            Files.deleteIfExists(archivo);
            System.out.println("- Archivo eliminado");

            // 5. Renombrar un archivo
            // Path apuntando a un archivo viejo
            Path viejo = Paths.get("viejo.txt");
            // Path apuntando al nuevo nombre
            Path nuevo = Paths.get("nuevo.txt");
            if (Files.notExists(viejo)) {
                // Creamos el archivo viejo de prueba
                Files.createFile(viejo);
            }
            Files.move(viejo, nuevo, StandardCopyOption.REPLACE_EXISTING); // Renombramos (o movemos)
            System.out.println("Archivo renombrado a: " + nuevo.getFileName());

            // 6. Verificar si un archivo existe
            if (Files.exists(nuevo)) {                       // Comprobamos si el archivo nuevo existe
                System.out.println("El archivo " + nuevo.getFileName() + " existe.");
            } else {
                System.out.println("El archivo no existe.");
            }

        } catch (IOException e) {
            System.out.println("Error al manejar archivos: " + e.getMessage());
        }
    }
}

package mainFolder;

import java.io.File;

public class CountFoldersAndFiles {

    private static int totalFicheros = 0;
    private static int totalDirectorios = 0;

    public static void main(String[] args) {

        //contarContenido("src/test/Files");
        contarTodo("src/test/Files");

    }

    public static void contarContenido(String pathStr) {

        File path = new File(pathStr);

        if (path.isDirectory()) {

            File[] contenido = path.listFiles();

            if (contenido != null) {

                for (File f : contenido) {

                    if (f.isFile()) totalFicheros++;

                    if (f.isDirectory()) totalDirectorios++;

                }

                System.out.println("En la ruta: " + pathStr);
                System.out.println("Ficheros directos: " + totalFicheros);
                System.out.println("Directorios directos: " + totalDirectorios);

            }

        } else {

            System.out.println("El path no es un directorio válido: " + pathStr);

        }

    }

    public static void contarTodo(String pathStr) {
        File path = new File(pathStr);

        if (path.isDirectory()) {

            recorrer(path);

            System.out.println("En la ruta: " + pathStr);
            System.out.println("Total de ficheros: " + totalFicheros);
            System.out.println("Total de directorios: " + totalDirectorios);

        } else {

            System.out.println("El path no es un directorio válido: " + pathStr);

        }

    }

    private static void recorrer(File path) {

        File[] contenido = path.listFiles();

        if (contenido != null) {

            for (File file : contenido) {

                if (file.isFile()) {

                    totalFicheros++;

                } else if (file.isDirectory()) {

                    totalDirectorios++;
                    recorrer(file);

                }
            }
        }
    }
}

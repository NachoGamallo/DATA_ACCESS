package mainFolder.T1_FilesAccess.Lunes13_10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class ejercicioPag108 {

    public static void main(String[] args) {

        try {

            // Indicamos el nombre del fichero de propiedades
            File archivo = new File("app.properties");

            // Creamos el objeto Properties (donde se guardan clave=valor)
            Properties props = new Properties();

            // Si el fichero NO existe, lo creamos con valores por defecto
            if (!archivo.exists()) {
                // Ponemos valores iniciales
                props.setProperty("app.name", "appMoney");
                props.setProperty("app.version", "1.0");
                props.setProperty("app.author", "Silvia");

                // Abrimos un flujo de salida al fichero
                try (FileOutputStream out = new FileOutputStream(archivo)) {
                    // Guardamos las propiedades dentro del archivo
                    props.store(out, "Configuracion de la aplicacion (creado por primera vez)");
                }

                // Mensaje de ayuda
                System.out.println(" -- Archivo app.properties con valores por defecto.\n");
            }

            // Volvemos a crear el Properties para cargar desde el disco
            props = new Properties();

            // Abrimos un flujo de entrada para LEER el fichero
            try (FileInputStream in = new FileInputStream(archivo)) {
                // Cargamos todas las lineas clave=valor en 'props'
                props.load(in);
            }

            // Leemos cada propiedad por su clave (si falta, damos un valor por defecto)
            String nombre = props.getProperty("app.name", "SinNombre");
            String versionStr = props.getProperty("app.version", "1.0");
            String autor = props.getProperty("app.author", "Desconocido");

            // Mostramos por consola lo que hay ahora mismo
            System.out.println("--> Valores actuales:");
            System.out.println("- Nombre  : " + nombre);
            System.out.println("- Versión : " + versionStr);
            System.out.println("- Autor   : " + autor);


            // Convertimos la versión de texto a número (double) para poder sumarle 0.1
            double version = Double.parseDouble(versionStr);

            // Sumamos una décima (0.1)
            double nuevaVersion = version + 0.1;

            // Redondeamos a UNA DECIMA para evitar 1.20000000002, etc.
            nuevaVersion = Math.round(nuevaVersion * 10.0) / 10.0;

            // Convertimos otra vez a texto con un decimal (por ejemplo "1.3")
            String nuevaVersionStr = String.format(java.util.Locale.US, "%.1f", nuevaVersion);

            // Guardamos la nueva versión en las propiedades
            props.setProperty("app.version", nuevaVersionStr);

            // Abrimos un flujo de salida para ESCRIBIR el fichero actualizado
            try (FileOutputStream out = new FileOutputStream(archivo)) {
                // Guardamos las propiedades de vuelta al archivo
                props.store(out, "Actualizado por la aplicación: version +0.1");
            }

            // Confirmamos por pantalla que se guardó el cambio
            System.out.println("\n --> Version actualizada:");
            System.out.println("- Nueva versión: " + nuevaVersionStr);
            System.out.println("\n- Ejecutar el programa para que la versión suba +0.1.");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}

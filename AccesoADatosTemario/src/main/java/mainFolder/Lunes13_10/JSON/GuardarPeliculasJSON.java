package org.example.Lunes13_10.JSON;

/**
 * Crea un programa que guarde en un fichero JSON la información
 * de una pelicula (título y año) y escribe esa información en un
 * archivo llamado peliculas.json
 *
 * * Cómo compilar y ejecutar
 * * Asegúrate de tener org.json en el classpath
 * (por ejemplo org.json-20240303.jar en lib/).
 */

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GuardarPeliculasJSON {
    public static void main(String[] args) {
        // Creamos un array JSON con 3 objetos,
        // cada objeto representa una película
        JSONArray peliculas = new JSONArray()
                // 1ª película: objeto con dos pares clave-valor: "titulo" y "anio"
                .put(new JSONObject().put("titulo", "Blade Runner").put("anio", 1982))
                .put(new JSONObject().put("titulo", "El viaje de Chihiro").put("anio", 2001))
                .put(new JSONObject().put("titulo", "La llegada").put("anio", 2016));

        // Objeto raíz que contiene el array bajo la clave "peliculas"
        JSONObject raiz = new JSONObject().put("peliculas", peliculas);

        // Guardar en fichero (UTF-8)
        // Ruta de salida del fichero JSON
        Path salida = Paths.get("./src/ELunes13octubre/peliculas.json");
        try {
            // Crea los directorios padre si no existen (evita errores de ruta)
            Files.createDirectories(salida.getParent());
            // Escribe el JSON con indentación de 4 espacios y codificación UTF-8
            // Para dejarlo "bonito"
            Files.writeString(salida, raiz.toString(4), StandardCharsets.UTF_8); // indent 4
            System.out.println("JSON guardado en: " + salida.toAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
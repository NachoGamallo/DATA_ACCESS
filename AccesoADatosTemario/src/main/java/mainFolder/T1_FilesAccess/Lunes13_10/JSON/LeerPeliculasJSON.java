package mainFolder.T1_FilesAccess.Lunes13_10.JSON;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LeerPeliculasJSON {
    public static void main(String[] args) {
        // Ruta del JSON generado en el ejercicio anterior
        Path ruta = Paths.get("./src/ELunes13octubre/peliculas.json");

        try {
            // Leer todo el archivo como String (UTF-8)
            // Lee todo el archivo indicado por ruta a memoria y devuelve su contenido como un String.
            // Usa la codificación UTF-8 para convertir los bytes del fichero a texto
            // (evita tildes/ñ mal interpretadas).
            String contenido = Files.readString(ruta, StandardCharsets.UTF_8);

            // Parsear el contenido a un JSONObject
            JSONObject raiz = new JSONObject(contenido);

            // Obtener el array "peliculas"
            JSONArray peliculas = raiz.getJSONArray("peliculas");

            // Recorrer e imprimir cada película
            System.out.println("Películas guardadas:");

            for (int i = 0; i < peliculas.length(); i++) {
                JSONObject peli = peliculas.getJSONObject(i);
                String titulo = peli.getString("titulo"); // esperamos que exista
                int anio = peli.getInt("anio");           // esperamos que exista
                System.out.println(" - " + titulo + " (" + anio + ")");
            }

        } catch (Exception e) {
            System.err.println("Error leyendo el JSON en " + ruta.toAbsolutePath());
            e.printStackTrace();
        }
    }
}
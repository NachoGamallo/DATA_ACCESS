package mainFolder.T1_FilesAccess.A8;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Actividad8 {

    static String url = "./ex1.json";
    static String urlTeacher = "./ex5.json";
    static String urlEx6 = "./ex6.json";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //He hecho metodos individuales, para que directamente no haga falta ir archivo por archivo revisando.

        //saveInfoJsonEx1();
        //seeInfoJsonEx2();
        //modifyJsonContentEx3();
        //addAsignaturaToJsonEx4();
        //teacherInfoJsonEx5();
        //convertToJsonEx6();

    }

    public static void saveInfoJsonEx1(){

        JSONObject student = new JSONObject();//Generamos el objeto padre, con sus atributos
        student.put("nombre","Nacho");
        student.put("edad","21");

        JSONArray asignaturas = new JSONArray();//Generamos un array , para ingresar mas de 1 parametro.
        asignaturas.put("Acceso a datos");
        asignaturas.put("Programacion movil");
        asignaturas.put("Ingles");

        student.put("asignaturas",asignaturas);//Ingresamos el array en el objeto padre

        try (FileWriter fw = new FileWriter(url)){//Generamos el archivo , con los datos generados.

            fw.write(student.toString(4));
            fw.flush();
            System.out.println("Archivo creado con exito.");

        }catch (IOException e){

            System.out.println("ERROR: " + e);

        }

    }
    public static void seeInfoJsonEx2(){

        try{

            String content = Files.readString(Paths.get(url), StandardCharsets.UTF_8);//Nos traemos el documento a una variable String con formato JSON
            JSONObject raiz = new JSONObject(content);

            System.out.println("Datos de Json: ");

            System.out.println(raiz.toString(4));//Imprimimos los datos , con formato JSON.


        }catch (Exception e){

            System.out.println("ERROR: " + e);

        }

    }
    public static void modifyJsonContentEx3(){

        JSONObject student = null;

        try {

            String content = new String(Files.readAllBytes(Paths.get(url)));//Nos traemos el contenido a una variable String
            student = new JSONObject(content);//Ingresamos datos a JSONObject

            student.put("curso","2DAM");//Agregamos este parametro

        }catch (IOException e){

            System.out.println("ERROR: " + e);

        }

        try (FileWriter fw = new FileWriter(url)){//Generamos fichero con modificaciones.

            fw.write(student.toString(4));
            fw.flush();
            System.out.println("Archivo modificado (QUIERES IMPRIMIRLO? YES/NO):");

            if (sc.next().equalsIgnoreCase("YES")){

                seeInfoJsonEx2();

            }

        }catch (IOException e){

            System.out.println("ERROR: " + e);

        }

    }
    public static void addAsignaturaToJsonEx4(){

        JSONObject student = null;
        JSONArray asignaturas;

        try {

            String content = new String(Files.readAllBytes(Path.of(url)));//Nos traemos el archivo a una variable string.
            student = new JSONObject(content);//Convertimos a objeto JSON
            asignaturas = student.getJSONArray("asignaturas");
            asignaturas.put("Programacion");//Agregamos una asignatura nueva

        }catch (IOException e){

            System.out.println("ERROR: " + e);

        }

        try (FileWriter fw = new FileWriter(url)){//Generamos el archivo con los nuevos datos.

            fw.write(student.toString(4));
            fw.flush();

            System.out.println("Archivo modificado (QUIERES IMPRIMIRLO? YES/NO):");

            if (sc.next().equalsIgnoreCase("YES")){

                seeInfoJsonEx2();

            }


        } catch (IOException e) {

            System.out.println("ERROR: " + e);

        }
    }
    public static void teacherInfoJsonEx5(){

        JSONObject teacher = new JSONObject();//Generamos el teacher con los parametros
        teacher.put("nombre","Jose");
        teacher.put("departamento","Informatica");
        JSONArray students = new JSONArray();

        JSONObject student = null;

        try {
            //Ingreso en un string , la cadena de bytes de el archivo JSON a leer.
            String content = new String(Files.readAllBytes(Path.of(url)));
            student = new JSONObject(content);//Generamos el objeto (tal cual el archivo original).


        }catch (IOException e){

            System.out.println("ERROR: " + e);

        }

        students.put(student);
        teacher.put("estudiantes",students);//Agregamos los estudiantes al JSON array.

        try (FileWriter fw = new FileWriter(urlTeacher)){//Generamos un archivo distinto, con el nuevo contenido.

            fw.write(teacher.toString(4));
            fw.flush();

        }catch (IOException e){

            System.out.println("ERROR:" + e);

        }

    }
    public static void convertToJsonEx6(){

        //Generamos el objeto con los atributos.
        JSONObject ies = new JSONObject()
                .put("equipoDocente","2DAM")
                .put("instituto","IES Mutxamel")
                .put("Anio",1999)
                .put("curso","2025/2026")
                .put("activo",true);

        //Generamos un JSON array , para meter profesores dentro.
        JSONArray teachers = new JSONArray()
                .put(new JSONObject()//Ingresamos todos los profesores de forma directa.
                        .put("nombre","Silvia")
                        .put("apellidos","Dianez")
                        .put("cursos",new int[]{1,2})//Generamos un array, para poder tener varios cursos.
                        .put("modulos",new JSONArray()
                                .put("Acceso a datos")
                                .put("Entornos de desarrollo")
                                .put("Proyecto Intermodular")))
                .put(new JSONObject()
                        .put("nombre","Juan")
                        .put("apellidos","Sanz")
                        .put("cursos",new int[]{2})
                        .put("modulos",new JSONArray()
                                .put("Desarrollo de interfaces")))
                .put(new JSONObject()
                        .put("nombre","Angel")
                        .put("apellidos","Sanchez")
                        .put("cursos",new int[]{1,2})
                        .put("modulos",new JSONArray()
                                .put("Dispositivos moviles")
                                .put("Bases de datos")));

        ies.put("profesores",teachers);//Agregamos el array JSON al objeto principal.

        try (FileWriter fw = new FileWriter(urlEx6)){//Generamos el archivo JSON con la url indicada.

            fw.write(ies.toString(4));//Ingresamos el contenido , con formato JSON
            fw.flush();//Comprobamos que no este vacio, (verificacion de creacion).

        }catch (IOException e){

            System.out.println("ERROR: " + e);

        }

    }

}

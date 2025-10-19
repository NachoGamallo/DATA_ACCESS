package mainFolder.T1_FilesAccess.PreExam;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class AllInteractionsWithFiles {

    static String tempFile = "./test2";

    //Clases OutputStream.

    // ByteArrayOutputStream -> Crea un buffer en memoria , todos los datos son trasmitidos en el flujo se colocan en este buffer.
    //FileOutputStream -> Para trasmitir informacion de Archivo.
    //PipeOutputStream -> Implementa el concepto de tuberia (pipe).
    //BufferedOutputStream -> Añade la funcion de almacenamiento en buffer a las operaciones de escritura.
    //DataOutputStram -> Proporciona funcionalidad para escribir en archivos de tipo primitivo de java.

    //Clases InputStream.

    //ByteArrayInputStream -> Permite utilizar los buffers de memoria como InputStream.
    //StringBufferInputStream -> Convierte un string en InputStream.
    //FileInputStream -> Para leer la informacion del Archivo.
    //PipeInputStream -> Implementa el concepto de tuberia (pipe).
    //SequenceInputStream -> Convierte dos o mas objetos InputStream en un unico InputStream.
    //BufferedInputStream -> Añade la funcion de almacenamiento en buffer a las operaciones de lectura.
    //DataInputStream -> Proporciona una funcionalidad para leer de un flujo de tipos primitivos Java.

    //Clases principales de Writer.

    //StringWriter -> Permite escribir stream manipulados como cadenas.
    //OutputStreamWriter -> Es una clase puente entre el stream de char y stream de bytes.
    //FileWriter -> Proporciona soporte para la escritura de caracteres en un archivo.
    //PipeWriter -> Permite la impresion de caracteres en un pipe.
    //PipeWriter -> Ofrece soporte para la impresion de caracteres especiales .
    //BufferedWriter -> Aniade la funcionalidad de almacenamieto en buffer al
    // flujo para que no haya necesidad de acceder al sistema de archivos para cada operacion de escritura.

    //Clases principales de Reader.

    //StringReader -> Representa un stream que opera con cadenas.
    //InputStreamReader -> Es una clase puente entre el stream de char y el stream de bytes.
    //FileReader -> Proporciona soporte para la lectura de caracteres desde un archivo.
    //PipedReader -> Permite leer los caracteres de una pipe.z
    //BufferedReader -> Añade la función de almacenamiento en buffer al stream para que no sea necesario acceder al
    //sistema de archivos para cada operación de lectura.
    //LineNumberReader -> Mantiene un registro del número de línea desde el que se leen los caracteres.

    public static void main(String[] args) throws IOException {

        String temp = "";

        try (BufferedReader br = new BufferedReader(new FileReader(tempFile))
        ){

            temp = br.readLine();
            System.out.println(temp);


        }catch (IOException e){

        }

        try (   BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
                //DataInputStream dis = new DataInputStream(new FileInputStream(tempFile))
                //FileInputStream fis = new FileInputStream(tempFile);
             //DataOutputStream dao2 = new DataOutputStream(new BufferedOutputStream( new FileOutputStream(tempFile)))
             //DataOutputStream dos = new DataOutputStream(new FileOutputStream(tempFile));
             //FileOutputStream fos = new FileOutputStream(tempFile)
        ){

            //fos.write("esto es una prueba".getBytes());
            //fos.flush();
            //dos.writeBoolean(true);
            //dos.writeBytes("Hola");
            //dao2.write("hola".getBytes(StandardCharsets.UTF_8));

            int byteRead;
//
//            while ((byteRead = fis.read()) != -1){
//
//                System.out.print((char) byteRead);
//
//            }


//            while ((byteRead = dis.read()) != -1){
//
//                System.out.print((char) byteRead);
//
//            }

            bw.write("hola " + temp );



        }catch (IOException e){

            System.out.println("ERROR: " + e);

        }

        //  File file = new File("./src/test/Files");
        //readFolders(file);
        testPath();


    }

    public static void readFolders(File file){
        File []temp2 = file.listFiles();


        for (File name : temp2){
            if (name.isFile()){
                System.out.println("{FILE} " + name.getName());
            }else {
                System.out.println("{FOLDER} " + name.getName());
                System.out.println("OPENING FOLDER (" + name.getName() + ")");
                readFolders(name);
             }
        }
    }

    public static void testPath (){

        List <String> list = new ArrayList<>();
        list.add("Ejemplo de escritura usando path");
        list.add("se utilizan metodos estaticos");
        Path path = Paths.get("./testPath.txt");
        Path folder = Paths.get("./testPath2");
        Path readContent = Paths.get("./src/test/Files");

        try {

            Files.write(path,list);
            Files.createDirectories(folder);
            DirectoryStream <Path> temp = Files.newDirectoryStream(readContent);

            for (Path name : temp)
                if (Files.isDirectory(name)) {
                    System.out.println("{FOLDER} " + name);
                }else {
                    System.out.println("{FILE} " + name);
                }

            Files.delete(Path.of("./test2"));
            System.out.println(Files.exists(Path.of("./test2")));

        }catch (IOException e){

        }

    }
}

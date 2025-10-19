package mainFolder.T1_FilesAccess.PreExam.ObjectInBinaryFiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ObjectsInBinaryFile {

    //Serializacion : Convertir objeto en una secuencia de bytes para almacenarlo en un fichero.
    //Deserializacion: Proceso inverso a la serializacion.

    static File file = new File("./src/test/Files/testEmployee");

    public static void main(String[] args) {

        TestEmployee testEmployee = new TestEmployee("nacho",true,21);

        try (ObjectOutputStream os = new ObjectOutputStream(
                Files.newOutputStream(Path.of("./src/test/Files/testEmployee")))){

            os.writeObject(testEmployee);

        }catch (IOException e){

        }

        try (ObjectInputStream oi = new ObjectInputStream(
                Files.newInputStream(Path.of("./src/test/Files/testEmployee")))){

            System.out.println((TestEmployee) oi.readObject());

        }catch (IOException | ClassNotFoundException e){}

    }

}

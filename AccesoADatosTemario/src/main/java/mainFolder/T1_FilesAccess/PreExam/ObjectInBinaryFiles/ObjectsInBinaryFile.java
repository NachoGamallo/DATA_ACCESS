package mainFolder.T1_FilesAccess.PreExam.ObjectInBinaryFiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ObjectsInBinaryFile {

    //Serializacion : Convertir objeto en una secuencia de bytes para almacenarlo en un fichero.
    //Deserializacion: Proceso inverso a la serializacion.

    static File file = new File("./src/test/Files/testEmployee");
    static List <TestEmployee> listEmployee = new ArrayList<>();

    public static void main(String[] args) {

        TestEmployee testEmployee = new TestEmployee("nacho",true,21);

        try (ObjectOutputStream os = new ObjectOutputStream(
                Files.newOutputStream(Path.of("./src/test/Files/testEmployee")))){

            listEmployee.add(testEmployee);
            listEmployee.add(new TestEmployee("Jose",false,12));

            for (TestEmployee e : listEmployee) os.writeObject(e);


        }catch (IOException e){

        }

        try (ObjectInputStream oi = new ObjectInputStream(
                Files.newInputStream(Path.of("./src/test/Files/testEmployee")))){

            int temp = listEmployee.size();

            for ( int i = 0 ; i < temp ; i++ ){

                System.out.println(oi.readObject());

            }

        }catch (IOException | ClassNotFoundException e){}

    }

}

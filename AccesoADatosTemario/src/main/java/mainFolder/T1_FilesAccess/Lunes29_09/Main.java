package mainFolder.T1_FilesAccess.Lunes29_09;


import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String text = "Hello ";

        try {

            FileOutputStream fos = new FileOutputStream("./src/test/Files/archivo.txt");
            fos.write(text.getBytes());
            fos.write(1);
            fos.close();

            System.out.println("Datos escritos en el archivo Binario");

        }catch (IOException e){

            e.printStackTrace();

        }
    }
}
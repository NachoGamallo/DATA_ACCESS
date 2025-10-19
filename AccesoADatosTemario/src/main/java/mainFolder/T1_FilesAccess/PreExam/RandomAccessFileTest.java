package mainFolder.T1_FilesAccess.PreExam;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

    //Tipos de RandomAccessFile:

    //boolean -> 1 byte
    //byte / read() -> 1byte
    //char -> 2 bytes
    //short -> 2 bytes
    //int -> 4 bytes
    //long -> 8 bytes
    // float -> 4 bytes
    //double -> 8 bytes
    //writeUTF (String) -> 2 bytes + 2 bytes por caracter
    //writeBytes -> 1 byte por caracter (trunca a 8 bits)

    public static void main(String[] args) {

        try {
            RandomAccessFile ra = new RandomAccessFile("./randomAccessTest","rw");

            ra.writeUTF("java"); //10 bytes
            ra.writeInt(2); // 4 bytes
            ra.seek(0);
            System.out.println(ra.readUTF());
            ra.seek(ra.length());
            ra.writeUTF("Acceso aleatorio");
            ra.seek(6);
            System.out.println(ra.readInt());
            ra.seek(10);
            System.out.println(ra.readUTF());
            ra.seek(ra.length());
            ra.writeBoolean(true);
            ra.seek(28);
            System.out.println(ra.readBoolean());
            ra.close();

        }catch (IOException e){}

    }

}

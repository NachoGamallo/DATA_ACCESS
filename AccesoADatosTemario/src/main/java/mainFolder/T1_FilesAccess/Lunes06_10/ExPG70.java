package mainFolder.T1_FilesAccess.Lunes06_10;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ExPG70 {

    public static void main(String[] args) {

        try (RandomAccessFile raf = new RandomAccessFile("ejercicioPag70.dat","rw")){

            //a
            raf.setLength(0);
            raf.writeChar('S');
            raf.writeInt(250);
            raf.writeDouble(3.1416);
            //b
            raf.seek(0);
            //c
            System.out.println(raf.readChar());
            System.out.println(raf.readInt());
            System.out.println(raf.readDouble());
            //d
            raf.seek(2);
            System.out.println(raf.readInt());
            //e
            raf.seek(raf.length());
            raf.writeChar('I');
            raf.writeBoolean(true);
            //f
                
            //g

            //h
            raf.close();


        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }


}

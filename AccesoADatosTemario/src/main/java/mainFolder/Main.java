package mainFolder;

import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        try {
            DataOutputStream fos = new DataOutputStream(new
                    FileOutputStream("datos.dat"));
            fos.writeInt(0);
            fos.writeInt(4);
            fos.writeInt(255);
            fos.writeInt(-7);
            fos.close();
        } catch (FileNotFoundException e) { //todas pueden derivar de
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Leer Datos:

        int total = 0;

        try (DataInputStream in = new DataInputStream(new FileInputStream("datos.dat"))) {
            while (true) {

                int actualNum = in.readInt();
                System.out.println("Numero actual: " + actualNum);
                total += actualNum;
            }
        } catch (EOFException e) {
            System.out.println("Suma total: " + total);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
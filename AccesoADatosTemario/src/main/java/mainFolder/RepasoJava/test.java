package mainFolder.RepasoJava;

import java.io.*;

public class test {

    public static void main(String[] args) throws IOException {

        test("Test",-3);

    }

    public static void test(String file, int number) throws IOException {
        try (OutputStream out = new FileOutputStream(file)) {
            out.write(number);
        }
        System.out.println(Integer.toBinaryString(number));
        try (InputStream input = new FileInputStream(file)) {
            System.out.println(input.read());
        }
    }


}

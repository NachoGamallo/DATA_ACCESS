package mainFolder.Ex4;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Ejercicio2 {
    public static void main(String[] args) {
        try {

            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();

            // Este método parse es el que va a invocar a los elementos del xml pasado
            // como parámetro y que nosotros hemos sobreescrito

            saxParser.parse("./src/main/java/mainFolder/Ex3/contactos.xml",

                    new A4Ex2());

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}

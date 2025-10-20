package mainFolder.T1_FilesAccess.PreExam;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExRepaso {

    public static void main(String[] args) {

        ex1Sax();

    }

    public static void ex1Sax(){

        String movilesXML = "movilesSAX.xml";

        try {
            // Configurar el TransformerHandler
            SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
            TransformerHandler handler = factory.newTransformerHandler();
            Transformer transformer = handler.getTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // Configurar el StreamResult
            StreamResult result = new StreamResult(new File(movilesXML));
            handler.setResult(result);

            // Comenzar el documento
            handler.startDocument();
            AttributesImpl atts = new AttributesImpl();


            /*
                SAX no construye un árbol en memoria, va emitiendo eventos
                mientras pasa por el XML

                --> startElement(...) ---> empieza un <tag ...>
                --> characters(char[] ch, int start, int length) ---> llega texto dentro de la etiqueta
                --> endElement(...) ---> cierra </tag>
            */


            // Elemento raíz <moviles>
            //
            handler.startElement("", "", "moviles", atts);

            // Primer móvil
            // Los 5 parámetros de addAttribute(uri, localName, nombreEtiqueta, type, value)
            atts.addAttribute("", "", "id", "CDATA", "1");
            handler.startElement("", "", "movil", atts);
            atts.clear();

            /*
             * void startElement(String uri, String localName, String nombreEtiqueta, Attributes atts)
                throws SAXException
             */
            handler.startElement("", "", "name", null);

            // El método de SAX que escribe texto es:
            // handler.characters(char[] ch, int start, int length)
            // de ahí el .toCharArray() porque es lo que SAX espera
            // start: desde qué posición del array empezar (normalmente 0)
            // length: cuántos caracteres escribir (normalmente texto.length())
            // SAX trabaja a bajo nivel con arrays de chars

            handler.characters("iPhone 15 Pro".toCharArray(), 0, "iPhone 15 Pro".length());
            handler.endElement("", "", "name");

            handler.startElement("", "", "year", null);
            handler.characters("2023".toCharArray(), 0, "2023".length());
            handler.endElement("", "", "year");

            handler.startElement("", "", "brand", null);
            handler.characters("Apple".toCharArray(), 0, "Apple".length());
            handler.endElement("", "", "brand");

            handler.startElement("", "", "category", null);
            handler.characters("Gama alta".toCharArray(), 0, "Gama alta".length());
            handler.endElement("", "", "category");

            handler.endElement("", "", "movil");

            // Segundo móvil
            atts.addAttribute("", "", "id", "CDATA", "2");
            handler.startElement("", "", "movil", atts);
            atts.clear();

            handler.startElement("", "", "name", null);
            handler.characters("Galaxy S24 Ultra".toCharArray(), 0, "Galaxy S24 Ultra".length());
            handler.endElement("", "", "name");

            handler.startElement("", "", "year", null);
            handler.characters("2024".toCharArray(), 0, "2024".length());
            handler.endElement("", "", "year");

            handler.startElement("", "", "brand", null);
            handler.characters("Samsung".toCharArray(), 0, "Samsung".length());
            handler.endElement("", "", "brand");

            handler.startElement("", "", "category", null);
            handler.characters("Gama alta".toCharArray(), 0, "Gama alta".length());
            handler.endElement("", "", "category");

            // Cerrar el elemento raíz
            handler.endElement("", "", "movil");

            // Finalizar el documento
            handler.endDocument();

            System.out.println("--> Archivo XML " + movilesXML + " creado con SAX.");

        } catch (TransformerConfigurationException | SAXException e) {
            e.printStackTrace();
        }

    }
    public static void ex2(){}

    public static void ex3(){

        try (RandomAccessFile raf = new RandomAccessFile("./src/test/Files/test/Ex3Repaso","rw");){

            String line;
            long pos;

            while (true){

                pos = raf.getFilePointer();
                line = raf.readLine();

                if (line == null) return;

                int index = line.indexOf(": warn");

                if (index != -1){

                    long warnPos = pos + index + 2;
                    raf.seek(warnPos);
                    raf.writeBytes("WARN");

                }

            }

        }catch (Exception e){
            System.out.println("ERROR: " + e);
        }
    }

}

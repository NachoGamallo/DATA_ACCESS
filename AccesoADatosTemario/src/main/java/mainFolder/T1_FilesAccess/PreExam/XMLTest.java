package mainFolder.T1_FilesAccess.PreExam;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class XMLTest {

    static File fileDom = new File("./src/test/Files/test/writeDom.xml");
    static File fileSax = new File("./src/test/Files/test/writeSax.xml");

    public static void main(String[] args) {
        //WriteDomXML();
        //writeSaxXML();
        //readDomXML();
    }
    //DOM
    public static void WriteDomXML(){

        File file = new File("./src/test/Files/test/writeDom.xml");

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder document = factory.newDocumentBuilder();
            Document doc = document.newDocument();

            Element root = doc.createElement("Alumns");
            doc.appendChild(root);

            //generacion de lineas XML
            generateStructureXML(root,doc,1,"Nacho","2DAM",21,true);
            generateStructureXML(root,doc,2,"Sergio","2DAM",19,true);
            generateStructureXML(root,doc,3,"Kiko","1DAW",20,false);
            generateStructureXML(root,doc,4,"Nour","2UNI",19,true);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();

            //Formato
            t.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
            t.setOutputProperty(OutputKeys.INDENT,"yes");

            // Crear archivo
            DOMSource fuente = new DOMSource(doc);
            StreamResult destiny = new StreamResult(fileDom);

            t.transform(fuente,destiny);

        }catch (Exception e){

        }

    }

    public static void generateStructureXML(Element element ,Document doc, int id, String name, String studies, int age, boolean isMaried){

        Element rootElement = doc.createElement("Student");
        rootElement.setAttribute("id", String.valueOf(id));
        element.appendChild(rootElement);

        Element nameElement = doc.createElement("name");
        nameElement.appendChild(doc.createTextNode(name));
        rootElement.appendChild(nameElement);

        Element studiesElement = doc.createElement("studies");
        studiesElement.appendChild(doc.createTextNode(studies));
        rootElement.appendChild(studiesElement);

        Element ageElement = doc.createElement("age");
        ageElement.appendChild(doc.createTextNode(String.valueOf(age)));
        rootElement.appendChild(ageElement);

        Element isMariedElement = doc.createElement("isMaried");
        isMariedElement.appendChild(doc.createTextNode(String.valueOf(isMaried)));
        rootElement.appendChild(isMariedElement);

    }

    public static void readDomXML(){

        System.out.println("Lectura de XML: ");

        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(fileDom))){

            while ((line = br.readLine()) != null){

                System.out.println(line);

            }

        }catch (IOException e){

        }
    }

    public static void writeSaxXML(){

        try {

            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = factory.createXMLStreamWriter(
                    new FileOutputStream("./src/test/Files/test/writeSax.xml"),"UTF-8");

            writer.writeStartDocument("UTF-8","1.0");
            writer.writeStartElement("Alumns");

            writer.writeStartElement("Student");
            writer.writeAttribute("id","1");
            writer.writeStartElement("name");
            writer.writeCharacters("Nacho");
            writer.writeEndElement();

            writer.writeStartElement("studies");
            writer.writeCharacters("2DAM");
            writer.writeEndElement();

            writer.writeStartElement("age");
            writer.writeCharacters("21");
            writer.writeEndElement();

            writer.writeStartElement("isMaried");
            writer.writeCharacters("true");
            writer.writeEndElement();

            writer.writeEndElement();
            writer.writeEndDocument();

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();

            //Formato
            t.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
            t.setOutputProperty(OutputKeys.INDENT,"yes");
            t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","4");

            writer.flush();
            writer.close();

        }catch (Exception e){}
    }

    public static void readSaxXML(String nameFile){



    }

}

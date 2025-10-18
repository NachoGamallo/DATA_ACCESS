package mainFolder.Ex4;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class A4Ex1 {

    public static void main(String[] args) {

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("inventions");
            doc.appendChild(root);

            crearInvention(doc, root, "1", "Falcon 9", "2010", "Aeroespacial");
            crearInvention(doc, root, "2", "Tesla Model S", "2012", "Automoción eléctrica");
            crearInvention(doc, root, "3", "Starlink", "2019", "Telecomunicaciones");
            crearInvention(doc, root, "4", "NeuraLink", "2016", "Neurotecnología");

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); // cabecera con UTF-8
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // Crear archivo
            DOMSource fuente = new DOMSource(doc);
            File file = new File("./src/main/java/mainFolder/Ex3/inventions.xml");
            StreamResult destiny = new StreamResult(file);

            transformer.transform(fuente, destiny);

            System.out.println("Archivo 'inventions.xml' creado correctamente.");

        } catch (ParserConfigurationException | TransformerException e) {

            throw new RuntimeException(e);

        }

    }

    private static void crearInvention(Document doc, Element element, String id, String name, String year, String area) {

        Element invention = doc.createElement("invention");
        invention.setAttribute("id", id);
        element.appendChild(invention);

        Element nameElem = doc.createElement("name");
        nameElem.appendChild(doc.createTextNode(name));
        invention.appendChild(nameElem);

        Element yearElem = doc.createElement("year");
        yearElem.appendChild(doc.createTextNode(year));
        invention.appendChild(yearElem);

        Element areaElem = doc.createElement("area");
        areaElem.appendChild(doc.createTextNode(area));
        invention.appendChild(areaElem);
    }

}

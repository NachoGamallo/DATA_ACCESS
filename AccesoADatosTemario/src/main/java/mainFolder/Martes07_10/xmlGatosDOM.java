package org.example.Martes07_10;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

// DOM: carga todo el XML en memoria como un árbol.
public class xmlGatosDOM {

    public static void main(String[] args) {
        try {

            // 1. Crear el Documento DOM vacío en Java
            // Sintaxis:
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument(); // <--- documento DOM sin nodos


            // 2. Crear el elemento raíz <cats> y colgarlo del documento
            // <cats>
            Element cats = doc.createElement("cats");
            // doc -> <cats> ... </cats>
            doc.appendChild(cats);

            // 3. Añadir al primer gato: <cat id="1"> ... </cat>
            // <cat>
            Element cat1 = doc.createElement("cat");
            // <cat id="1">
            cat1.setAttribute("id", "1");
            // colgarlo de <cats>
            cats.appendChild(cat1);

            // <name>
            Element name1 = doc.createElement("name");
            // <name>Gato 1</name>
            name1.appendChild(doc.createTextNode("Gato 1"));
            // meter <name> dentro de <cat>
            cat1.appendChild(name1);

            Element age1 = doc.createElement("age");
            age1.appendChild(doc.createTextNode("3"));
            cat1.appendChild(age1);

            Element kids1 = doc.createElement("kids");
            kids1.appendChild(doc.createTextNode("4"));
            cat1.appendChild(kids1);

            // Segundo gato
            Element cat2 = doc.createElement("cat");
            cat2.setAttribute("id", "2");
            cats.appendChild(cat2);

            Element name2 = doc.createElement("name");
            name2.appendChild(doc.createTextNode("Gato 2"));
            cat2.appendChild(name2);

            Element age2 = doc.createElement("age");
            age2.appendChild(doc.createTextNode("7"));
            cat2.appendChild(age2);

            Element kids2 = doc.createElement("kids");
            kids2.appendChild(doc.createTextNode("7"));
            cat2.appendChild(kids2);

            // Tercer gato
            Element cat3 = doc.createElement("cat");
            cat3.setAttribute("id", "3");
            cats.appendChild(cat3);

            Element name3 = doc.createElement("name");
            name3.appendChild(doc.createTextNode("Gato 3"));
            cat3.appendChild(name3);

            Element age3 = doc.createElement("age");
            age3.appendChild(doc.createTextNode("10"));
            cat3.appendChild(age3);

            Element kids3 = doc.createElement("kids");
            kids3.appendChild(doc.createTextNode("0"));
            cat3.appendChild(kids3);

            // Esccribir el contendido del DOM en un archivo XML
            TransformerFactory transformeFactory = TransformerFactory.newInstance();
            Transformer transformer = transformeFactory.newTransformer();

            // (Opcional) Propiedades básicas para que salga bonito
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); // cabecera con UTF-8
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");     // intenta indentar

            // Pasamos nuestro documento a un objeto de DestinoDOM con la clase DOMSource
            DOMSource fuente = new DOMSource(doc);

            // Preparamos el fichero en el que vamos a volcar el XML
            File archivo = new File("cats.xml");
            StreamResult destino = new StreamResult(archivo);

            transformer.transform(fuente, destino);

            System.out.println("******** Archivo XML creado exitosamente");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

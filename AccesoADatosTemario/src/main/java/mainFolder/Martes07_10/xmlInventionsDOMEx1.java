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

public class xmlInventionsDOMEx1 {

    public static void main(String[] args) {

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            String url = "./src/main/java/org/example/Martes07_10";

            //Creo el elemento raiz.
            Element inventions = doc.createElement("inventions");
            doc.appendChild(inventions);

            //Creamos el elemento gato1, con su atributo id.
            //Invent 1:
            Element invent1 = doc.createElement("invent1");
            invent1.setAttribute("id","1");
            inventions.appendChild(invent1); //Agregamos invent1 a invents.

            Element name1 = doc.createElement("name1");
            name1.appendChild(doc.createTextNode("Falcon 9"));
            invent1.appendChild(name1);

            Element year1 = doc.createElement("year1");
            year1.appendChild(doc.createTextNode("2010"));
            invent1.appendChild(year1);

            Element area1 = doc.createElement("area1");
            area1.appendChild(doc.createTextNode("Aeroespacial"));
            invent1.appendChild(area1);

            //Invent 2:
            Element invent2 = doc.createElement("invent2");
            invent2.setAttribute("id","2");
            inventions.appendChild(invent2); //Agregamos invent1 a invents.

            Element name2 = doc.createElement("name2");
            name2.appendChild(doc.createTextNode("Tesla Model S"));
            invent2.appendChild(name2);

            Element year2 = doc.createElement("year2");
            year2.appendChild(doc.createTextNode("2012"));
            invent2.appendChild(year2);

            Element area2 = doc.createElement("area2");
            area2.appendChild(doc.createTextNode("Automaticación eléctrica"));
            invent2.appendChild(area2);

            //Invent 3:
            Element invent3 = doc.createElement("invent3");
            invent3.setAttribute("id","3");
            inventions.appendChild(invent3); //Agregamos invent1 a invents.

            Element name3 = doc.createElement("name3");
            name3.appendChild(doc.createTextNode("Starlink"));
            invent3.appendChild(name3);

            Element year3 = doc.createElement("year3");
            year3.appendChild(doc.createTextNode("2019"));
            invent3.appendChild(year3);

            Element area3 = doc.createElement("area3");
            area3.appendChild(doc.createTextNode("Telecomunicaciones"));
            invent3.appendChild(area3);

            //Invent 4:
            Element invent4 = doc.createElement("invent4");
            invent4.setAttribute("id","4");
            inventions.appendChild(invent4); //Agregamos invent1 a invents.

            Element name4 = doc.createElement("name4");
            name4.appendChild(doc.createTextNode("NeuraLink"));
            invent4.appendChild(name4);

            Element year4 = doc.createElement("year4");
            year4.appendChild(doc.createTextNode("2016"));
            invent4.appendChild(year4);

            Element area4 = doc.createElement("area4");
            area4.appendChild(doc.createTextNode("Neurotecnologia"));
            invent4.appendChild(area4);

            //Escribir contenido del DOM en XML

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            //propiedades para darle formato.
            transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");

            //Pasamos documento a objeto DOM.
            DOMSource source = new DOMSource(doc);

            //Preparamos el fichero.
            File file = new File(url + "/inventionsDOM.xml");
            StreamResult destiny = new StreamResult(file);

            transformer.transform(source,destiny);

            System.out.println("******** Archivo XML creado exitosamente");

        }catch (Exception e){

            System.out.println("ERROR: " + e);

        }

    }

}

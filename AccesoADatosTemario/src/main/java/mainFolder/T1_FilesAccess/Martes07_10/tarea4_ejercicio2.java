package mainFolder.T1_FilesAccess.Martes07_10;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

class MiGestorDeContactosXML extends DefaultHandler {
    protected String contenido; // atributo para almacenar el contenido de una etiqueta

    // Etiqueta de apertura encontrada. El valor de la etiqueta está en "valor"
    public void startElement(String uri, String nombreLocal,
                             String valor, Attributes atributos) throws SAXException {
        if (valor.equals("contacto")) {
            System.out.println("ID: " + atributos.getValue("id"));
        }
    }

    // Contenido de la etiqueta, normalmente CDATA
    public void characters(char ch[], int inicio, int longitud) throws SAXException {
        contenido = new String(ch, inicio, longitud);
    }

    // Etiqueta de cierre
    public void endElement(String uri, String nombreLocal, String valor) throws SAXException {
        if (!valor.isBlank())
            if (!valor.equals("contacto"))
                System.out.println(" " + valor + ": " + contenido);
    }

    public static void main(String[] args) {
        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            // Este método parse es el que va a invocar a los elementos del xml pasado
            // como parámetro y que nosotros hemos sobreescrito
            saxParser.parse("./contactos.xml",
                    new MiGestorDeContactosXML());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

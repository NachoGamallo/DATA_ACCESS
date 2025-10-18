package mainFolder.Ex4;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class A4Ex2 extends  DefaultHandler{

    private String contenido;
    private String name;
    private String surname;
    private String movil;
    private String trabajo;
    private String casa;

    @Override
    public void startElement(String uri, String localName, String valor, Attributes attributes) throws SAXException {

        contenido = "";

        if (valor.equalsIgnoreCase("contacto")) {

            name = "";
            surname = "";
            movil = null;
            trabajo = null;
            casa = null;

        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        contenido += new String(ch, start, length);

    }

    @Override
    public void endElement(String uri, String localName, String valor) throws SAXException {

        String texto = contenido.trim();

        switch (valor.toLowerCase()) {
            case "nombre":
                name = texto;
                break;

            case "apellido":
                surname = texto;
                break;

            case "movil":
                movil = texto;
                break;

            case "trabajo":
                trabajo = texto;
                break;

            case "casa":
                casa = texto;
                break;

            case "contacto":

                // Elegir teléfono con prioridad móvil -> trabajo -> casa
                String telefonoElegido;
                if (movil != null && !movil.isEmpty()) telefonoElegido = movil;
                else if (trabajo != null && !trabajo.isEmpty()) telefonoElegido = trabajo;
                else if (casa != null && !casa.isEmpty()) telefonoElegido = casa;
                else telefonoElegido = "(sin teléfono)";

                System.out.println(name + " " + surname + " → " + telefonoElegido);
                break;

        }

    }

}
package mainFolder.T1_FilesAccess.Martes07_10;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

// SAX: no carga el árbol; va leyendo y disparando eventos.
public class xmlGatosSAX {

    public static void main(String[] args) {
        try {
            // creamos la fábrica de parsers SAX
            SAXParserFactory fabrica = SAXParserFactory.newInstance();
            // obtenemos el parser SAX
            SAXParser parser = fabrica.newSAXParser();
            // parseamos el archivo cats.xml con un handler sencillo y legible
            parser.parse("cats.xml", new GatosHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Handler mínimo y legible: imprime cada gato como "#id Nombre | age=X | kids=Y" */
    static class GatosHandler extends DefaultHandler {

        // buffer para el texto entre etiquetas
        private StringBuilder bufferTexto = new StringBuilder();

        // datos del gato actual
        private String idGato;
        private String nombreGato;
        private String edadGato;
        private String hijosGato;

        @Override
        public void startElement(String uri, String ln, String nombreEtiqueta, Attributes atributos) {
            // limpiamos el buffer cada vez que empieza una etiqueta
            bufferTexto.setLength(0);

            // si empieza <cat>, tomamos su atributo id y reseteamos campos
            if ("cat".equals(nombreEtiqueta)) {
                // leemos el atributo id del gato
                idGato = atributos.getValue("id");
                // reiniciamos valores del gato actual
                nombreGato = null;
                edadGato = null;
                hijosGato = null;
            }
        }

        @Override
        public void characters(char[] ch, int inicio, int longitud) {
            // acumulamos el texto (puede llegar en trozos)
            bufferTexto.append(ch, inicio, longitud);
        }

        @Override
        public void endElement(String uri, String ln, String nombreEtiqueta) {
            // recogemos el texto acumulado para esta etiqueta
            String contenido = bufferTexto.toString().trim();

            // si cerramos </name>, guardamos el nombre del gato
            if ("name".equals(nombreEtiqueta)) {
                nombreGato = contenido;
            }
            // si cerramos </age>, guardamos la edad (como String para simplificar)
            else if ("age".equals(nombreEtiqueta)) {
                edadGato = contenido;
            }
            // si cerramos </kids>, guardamos el número de hijos
            else if ("kids".equals(nombreEtiqueta)) {
                hijosGato = contenido;
            }
            // si cerramos </cat>, imprimimos los datos del gato y reiniciamos buffer
            else if ("cat".equals(nombreEtiqueta)) {
                // imprimimos: #id Nombre | age=X | kids=Y
                if (hijosGato.equalsIgnoreCase("0")){

                    System.out.println("#" + idGato + " " + nombreGato + " | age=" + edadGato + "| NO TIENE HIJOS");

                }else {

                    System.out.println("#" + idGato + " " + nombreGato + " | age=" + edadGato + " | kids=" + hijosGato);

                }
            }

            // limpiamos el buffer para la siguiente etiqueta
            bufferTexto.setLength(0);
        }
    }
}

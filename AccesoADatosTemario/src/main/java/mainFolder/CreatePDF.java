package mainFolder;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class CreatePDF {
    public static void main(String[] args) {
        try (PDDocument doc = new PDDocument()) {
            PDPage page = new PDPage();
            doc.addPage(page);

            // Insertar imagen
            PDImageXObject imagen = PDImageXObject.createFromFileByContent(new File("imagen.jpg"), doc);

            try (PDPageContentStream contenido = new PDPageContentStream(doc, page)) {
                contenido.drawImage(imagen, 100, 400, 200, 200);
            }

            doc.save("archivoPDF.pdf");
            System.out.println("PDF creado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package mainFolder.T1_FilesAccess.Martes14_10;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable {
    static String file = "./BookFile.dat";
    private String name;
    private String author;

    private String editorial;
    private String date;

    public Book(String name, String author, String date, String editorial) {
        this.name = name;
        this.author = author;
        this.date = date;
        this.editorial = editorial;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    //Leer datos en archivo.
    public static void readBook(){

        try (ObjectInputStream os = new ObjectInputStream(new FileInputStream(file))){

            List<Book> books = (List<Book>) os.readObject();//Leemos los datos como si fuera una lista de objetos.
            books.forEach(System.out::println);//ForEach para recorrer imprimiendo cada objeto.

        } catch (IOException | ClassNotFoundException e) {

            System.out.println("ERROR: " + e);

        }

    }

    //Escribir datos en archivo.
    public static void writeBook(List<Book> book){

        try (ObjectOutputStream os = new ObjectOutputStream(
                Files.newOutputStream(Path.of(file)))){

            os.writeObject(book);//Escribimos todos los obejtos de la lista pasada.

        } catch (IOException e) {

            System.out.println("ERROR: " + e);

        }

    }

    public static void main(String[] args) {

        Book book = new Book("Test","Test","2025/10/12","test");
        Book book2 = new Book("Test2","Test2","2025/10/12","test2");

        List<Book> temp = new ArrayList<>();

        temp.add(book);
        temp.add(book2);
        writeBook(temp);
        readBook();

    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", editorial='" + editorial + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

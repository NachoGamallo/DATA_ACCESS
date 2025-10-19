package mainFolder.T1_FilesAccess.Martes14_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookApp {
    static List<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //Pruebas realizadas en una lista estatica de este programa.
        System.out.println("Ingresando 3 libros");

        Book book1 = new Book("test1","test1","2025/10/10","test1");
        Book book2 = new Book("test2","test2","2025/10/10","test2");
        Book book3 = new Book("test3","test3","2025/10/10","test3");

        addBook(book1);
        addBook(book2);
        addBook(book3);

        sawBooks();

        System.out.println("===========================================");
        System.out.println("Borramos libro 2:");
        System.out.println("===========================================");

        removeBook(book2);

        sawBooks();
    }

    //Llamamos a la funcion de Book que es para agregar libros en el fichero , despues de agregar un objeto.
    public static void addBook(Book book){

        books.add(book);
        Book.writeBook(books);

    }

    //Llamamos a la funcion para agregar libros en el fichero , despues de borrar un objeto.
    public static void removeBook (Book book){

        books.remove(book);
        Book.writeBook(books);

    }

    //Lamamos a la funcion de Book que lee el contenido del archivo.
    public static void sawBooks(){

        Book.readBook();

    }

}

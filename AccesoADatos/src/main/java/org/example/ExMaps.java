package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class ExMaps {

    static Scanner entry = new Scanner(System.in);

    static HashMap <Integer , String> booksMap = new HashMap<>();
    public static void principalApp(){

        int option;

        do {


            switch (option = menu()){

                case 1:
                    addBook();
                    break;

                case 2:
                    System.out.println("Introduce el ISBN a eliminar: ");
                    deleteBook(entry.nextInt());
                    break;

                case 3:

                    System.out.println("Introduce el ISBN a buscar: ");

                    Integer temp = entry.nextInt();

                    if (checkBook(temp)){

                        System.out.println("El libro con isbn "+ temp + " y nombre : " + booksMap.get(temp));

                    }else {

                        System.out.println("El isbn " + temp + " no esta registrado en el sistema.");

                    }
                    break;

                case 4:
                    seeBooks();
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Has introducido una opcion no contemplada...");
                    break;
            }

        }while (option != 5);

    }

    private static int menu(){

        System.out.println("Introduce la opción a elegir:");
        System.out.println("--------------------------------------");
        System.out.println("1. Añadir nuevo libro:");
        System.out.println("2. Eliminar un libro existente:");
        System.out.println("3. Consultar segun ISBN:");
        System.out.println("4. Mostrar lista de libros:");
        System.out.println("5. Salir:");
        System.out.println("--------------------------------------");

        return entry.nextInt();

    }

    private static void addBook(){

        System.out.println("Introduce el ISBN para el libro: ");
        Integer isbn = entry.nextInt();

        if (booksMap.containsKey(isbn)){

            System.out.println("No puedes ingresar un isbn que ya existe en el sistema...");
            addBook();

        }else {

            System.out.println("Ingresa el nombre del libro: ");

            booksMap.put(isbn, entry.next());
            System.out.println("Se ha ingresado correctamente.");

        }

    }

    private static void seeBooks (){

        System.out.println(booksMap.toString());

    }

    private static boolean checkBook(Integer isbn){

        return booksMap.containsKey(isbn);

    }

    private static void deleteBook (Integer isbn){

        if (checkBook(isbn)){

            booksMap.remove(isbn);

        }else {

            System.out.println("El ISBN no existe...");

        }
    }
}

package org.example;

import java.util.*;
import java.util.List;

public class Exercices {
    static Scanner entry = new Scanner(System.in);
    static Random random = new Random();
    public static void ex2(){

        byte status = 0;
        int userNum;
        List<Integer> ex2 = new ArrayList<>();

        do {
            System.out.println("Introduce un número del 2 al 7: ");
            userNum = entry.nextInt();

            if (userNum >= 2 && userNum <= 7){
                status = 1;
            }

        }while (status == 0);

        for (int i = 1; i <= 100; i++){

            if ( i % userNum == 0 ){
                ex2.add(i);
            }
        }

        System.out.printf(ex2.toString());

    }
    public static void ex3(){


        ArrayList<Integer> listaNumeros = new ArrayList<>();

        for ( int i = 0; i < 10; i++ ){

            listaNumeros.add(random.nextInt(0,100));

        }

        System.out.println(listaNumeros.toString());

        Collections.sort(listaNumeros);

        System.out.println("Introduce el número más bajo:");
        int lower = entry.nextInt();

        System.out.println("Introduce el número más alto:");
        int upper = entry.nextInt();

        listaNumeros.removeIf(digit -> digit < lower || digit > upper);

        System.out.println(listaNumeros.toString());

    }

    public static void ex4(){

        List<String> list = new LinkedList<>();
        byte status = 0;
        for ( int i = 0 ; i < 3 ; i++ ){

            System.out.println("Introduce un nombre: ");
            list.add(entry.next());

        }

        do {

            System.out.println("Introduce un indice para modificar, hay " + list.size() + " posiciones: ");
            int pos = entry.nextInt();

            if ( pos >= 0 && pos < list.size()){
                System.out.println("Introduce el nuevo nombre:");
                list.set(pos,entry.next());
                status = 1;

            }

        }while (status == 0);

        list.removeFirst();

        list.remove("Jose");

        System.out.println("Posiciones de la lista: " + list.size());
        System.out.println("Introduce el nombre que quieres saber si esta en la lista:");

        String temp = entry.next();

        if ( !list.remove(temp)){

            System.out.println("El usuario con nombre " + temp + " si que existe...");

        }else {

            System.out.println("El usuario con nombre " + temp + " no existe...");

        }

        list.clear();

        System.out.println("Tamaño de la lista despues de borrar todo : " + list.size());
    }

}

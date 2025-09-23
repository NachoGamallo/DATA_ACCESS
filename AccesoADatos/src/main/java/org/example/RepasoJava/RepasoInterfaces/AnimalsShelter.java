package org.example.RepasoJava.RepasoInterfaces;

import java.util.ArrayList;
import java.util.Scanner;

public class AnimalsShelter {

    static Scanner entry = new Scanner(System.in);

    public static void main(String[] args) {

        Dog dog = new Dog(true);
        Cat cat = new Cat(false);
        Bird bird = new Bird(10);

        System.out.println(dog.makeNoise());
        System.out.println(cat.makeNoise());
        System.out.println(bird.makeNoise());

        System.out.println("Introduce la velocidad de un Pajaro:");
        Bird userBird = new Bird(entry.nextInt());

        System.out.println("El pajaro va a " + userBird.flySpeed + " KM/h");

        ArrayList <Animal> animalsList = new ArrayList<>();
        animalsList.add(dog);
        animalsList.add(cat);
        animalsList.add(bird);

        for (Animal a : animalsList){

            a.sleep();

        }

        dog.play();
        cat.play();
    }

}

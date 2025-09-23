package org.example.RepasoJava.Ex1Abstract;

public abstract class Ex1Abstract {

    public Ex1Abstract() {

        System.out.println("Este es un constructor de una clase abstracta.");

    }

    public abstract void abstract_method();

    public void normal_method(){
        System.out.println("Este es un método normal de la clase abstracta.");
    }
}

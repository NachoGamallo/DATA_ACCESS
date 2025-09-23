package org.example.RepasoJava.Ex1Abstract;

import org.example.RepasoJava.Ex1Abstract.Ex1Abstract;

public class SubClassAbstractEx1 extends Ex1Abstract {
    @Override
    public void abstract_method() {
        System.out.println("Este es un método abstracto implementado en una clase no abstracta");
    }
}

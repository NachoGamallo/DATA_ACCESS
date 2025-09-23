package org.example.RepasoJava.RepasoInterfaces;

public class Cat implements Animal, Mascota{

    boolean isAngry;

    public Cat(boolean isAngry) {
        this.isAngry = isAngry;
    }

    public boolean isAngry() {
        return isAngry;
    }

    public void setAngry(boolean angry) {
        isAngry = angry;
    }

    @Override
    public void eat() {
        System.out.println("Gato comiendo");
    }

    @Override
    public void sleep() {
        System.out.println("Gato durmiendo");
    }

    @Override
    public void move() {
        System.out.println("Gato moviendose");
    }

    @Override
    public String makeNoise() {
        return "MIAU MIAU";
    }

    @Override
    public void play() {
        System.out.println("El gato esta jugando");
    }
}

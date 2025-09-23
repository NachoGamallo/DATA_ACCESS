package org.example.RepasoJava.RepasoInterfaces;

public class Dog implements Animal, Mascota{

    boolean isTrained;

    public Dog(boolean isTrained) {
        this.isTrained = isTrained;
    }

    public boolean isTrained() {
        return isTrained;
    }

    public void setTrained(boolean trained) {
        isTrained = trained;
    }

    @Override
    public void eat() {
        System.out.println("Perro comiendo");
    }

    @Override
    public void sleep() {
        System.out.println("Perro durmiendo");
    }

    @Override
    public void move() {
        System.out.println("Perro moviendose");
    }

    @Override
    public String makeNoise() {
        return "GUAU GUAU";
    }

    @Override
    public void play() {
        System.out.println("El perro esta jugando. ");
    }
}

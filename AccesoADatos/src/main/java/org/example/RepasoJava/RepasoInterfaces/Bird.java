package org.example.RepasoJava.RepasoInterfaces;

public class Bird implements Animal{

    int flySpeed;

    public Bird(int flySpeed) {
        this.flySpeed = flySpeed;
    }

    public int getFlySpeed() {
        return flySpeed;
    }

    public void setFlySpeed(int flySpeed) {
        this.flySpeed = flySpeed;
    }

    @Override
    public void eat() {
        System.out.println("Pajaro comiendo");
    }

    @Override
    public void sleep() {
        System.out.println("Pajaro durmiendo");
    }

    @Override
    public void move() {
        System.out.println("Pajaro moviendose");
    }

    @Override
    public String makeNoise() {
        return "Sonidos de pajaro (No se representarlo)";
    }
}

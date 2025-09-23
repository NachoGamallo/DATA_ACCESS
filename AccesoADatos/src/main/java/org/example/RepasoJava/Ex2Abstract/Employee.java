package org.example.RepasoJava.Ex2Abstract;

public abstract class Employee {

    private String name;
    private String charge;

    public Employee(String name, String charge) {
        this.name = name;
        this.charge = charge;
    }

    abstract void calculateWeeklyPay();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }
}

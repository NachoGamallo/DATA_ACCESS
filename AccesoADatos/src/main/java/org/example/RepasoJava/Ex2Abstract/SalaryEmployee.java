package org.example.RepasoJava.Ex2Abstract;

public class SalaryEmployee extends Employee{

    private String weeklyPay;
    public SalaryEmployee(String name, String charge, String weeklyPay) {

        super(name, charge);
        this.weeklyPay = weeklyPay;

    }

    public String getWeeklyPay() {
        return weeklyPay;
    }

    public void setWeeklyPay(String weeklyPay) {
        this.weeklyPay = weeklyPay;
    }

    @Override
    void calculateWeeklyPay() {
        System.out.println("Total de pago a la semana: " + getWeeklyPay() + " €");
    }
}

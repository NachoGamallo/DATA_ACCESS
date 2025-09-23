package org.example.RepasoJava.Ex2Abstract;

public class HourlyEmployee extends Employee{

    double rate;
    int totalHours;
    public HourlyEmployee(String name, String charge, double rate, int totalHours) {

        super(name, charge);
        this.rate = rate;
        this.totalHours = totalHours;

    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    @Override
    void calculateWeeklyPay() {
        System.out.println("Total ha pagar por semana: " + (getRate()*getTotalHours()) + " €");
    }
}

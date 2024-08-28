package org.tejas.expenditure;

public class Expenditure {
    private String description;
    private double amount;

    public Expenditure(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }
}

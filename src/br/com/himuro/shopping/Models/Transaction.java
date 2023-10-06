package br.com.himuro.shopping.Models;

public class Transaction {
    private final String name;
    private  final double value;

    public Transaction(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.name + " - " + String.format("%.1f", this.value);
    }
}

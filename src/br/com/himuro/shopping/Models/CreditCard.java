package br.com.himuro.shopping.Models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CreditCard {
    private double limit;
    private double moneyExpended;
    private List<Transaction> transactions;

    public CreditCard(double limit) {
        this.limit = limit;
        this.transactions = new ArrayList<>();
    }

    public double getLimit() {
        return limit;
    }

    public double getMoneyExpended() {
        return moneyExpended;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getBalance() {
        return this.limit - this.moneyExpended;
    }

    public boolean addTransaction(Transaction transaction) {
        if (transaction.getValue() > getBalance())
        {
            return false;
        }
        transactions.add(transaction);
        this.moneyExpended += transaction.getValue();
        return true;
    }

    public void showPurchases(){
        StringBuilder message = new StringBuilder("Purchases made: \n\n");
        transactions.sort(Comparator.comparing(Transaction::getValue));
        for ( Transaction transaction : transactions) {
            message.append(transaction.toString()).append("\n\n");
        }
        message.append("Card balance: ").append(String.format("%.1f", getBalance()));
        System.out.println(message);
    }


}

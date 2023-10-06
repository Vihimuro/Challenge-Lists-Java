package br.com.himuro.shopping.Models;

import java.util.List;

public class CreditCard {
    private double limit;
    private double moneyExpended;
    private List<Transaction> transactions;

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
        this.moneyExpended -= transaction.getValue();
        return true;
    }



}

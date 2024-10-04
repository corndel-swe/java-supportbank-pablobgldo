// Currency.java
package com.corndel.supportbank.models;

public class Currency {

    private double amount;
    private String currency;

    public Currency(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}

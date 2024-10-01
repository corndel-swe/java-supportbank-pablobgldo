package com.corndel.supportbank.models;

public class Transaction {
    private String date;
    private String from;
    private String to;
    private String narrative;
    private double amount;

    public Transaction(String date, String from, String to, String narrative, double amount) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.narrative = narrative;
        this.amount = amount;
    }
}

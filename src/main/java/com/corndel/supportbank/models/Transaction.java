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

    public String getDate() {
        return this.date;
    }

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }

    public String getNarrative() {
        return this.narrative;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getAll() {
        return "Date: " + date + ". From: " + from + ". To: " + to + ". Narrative: " + narrative + ". Amount: " + amount + ".";
    }


}

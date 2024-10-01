package com.corndel.supportbank.services;

import com.corndel.supportbank.models.Bill;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "split")
public class BillService implements Runnable {

    @Parameters(index = "0")
    private double price;

    @Parameters(index = "1")
    private double people;


    @Override
    public void run() {
        Bill bill = new Bill(price);
        System.out.println("Each person owes "+ bill.split(people));
    }
}

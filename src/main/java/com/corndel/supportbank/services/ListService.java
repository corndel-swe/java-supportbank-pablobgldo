package com.corndel.supportbank.services;

import com.corndel.supportbank.models.Transaction;
import com.google.gson.internal.bind.util.ISO8601Utils;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.sql.SQLOutput;
import java.util.List;

@Command(name = "list")
public class ListService implements Runnable {

    @Parameters(index= "0")
    private String filename;

    @Parameters(index= "1")
    private String person;

    @Override
    public void run() {

        TransactionReader transactionReader = new TransactionReader();
        List<Transaction> transactions = transactionReader.readTransactions(filename);

        transactions.stream().filter(x -> x.getFrom().equalsIgnoreCase(person)|| x.getTo().equalsIgnoreCase(person)).forEach(x ->
                System.out.println(x.getAll()));
    }
}

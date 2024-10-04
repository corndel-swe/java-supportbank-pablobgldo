package com.corndel.supportbank.services;

import com.corndel.supportbank.models.Transaction;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TransactionReader {

    public List<Transaction> readTransactions(String filename) {
        try {
            Path path = Paths.get("src", "data", "transactions", filename);
            List<String> lines = Files.readAllLines(path).subList(1, Files.readAllLines(path).size());

            List<Transaction> transactions = new ArrayList<>();

            for (String line : lines) {
                String[] data = line.split(",");

                String date = data[0];
                String from = data[1];
                String to = data[2];
                String narrative = data[3];
                double amount = Double.parseDouble(data[4]);

                Transaction transaction = new Transaction(date, from, to, narrative, amount);
                transactions.add(transaction);
            }

            return transactions;
    } catch (IOException e) {
            System.err.println("Something went wrong");
        }
        return List.of();
    }}

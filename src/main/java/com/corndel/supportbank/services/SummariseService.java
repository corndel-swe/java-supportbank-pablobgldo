package com.corndel.supportbank.services;

import com.corndel.supportbank.models.Transaction;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Command(name = "summarise")
public class SummariseService implements Runnable {

    @Parameters(index= "0")
    private String filename;

    @Override
    public void run() {

        TransactionReader transactionReader = new TransactionReader();
        List<Transaction> transactions = transactionReader.readTransactions(filename);

        Map<String, Double> accounts = new HashMap<>();

        for (Transaction transaction : transactions) {
            double oldFrom = accounts.containsKey(transaction.getFrom()) ? accounts.get(transaction.getFrom()) : 0;
            double oldTo = accounts.containsKey(transaction.getTo()) ? accounts.get(transaction.getTo()) : 0;

            double newFrom = oldFrom - transaction.getAmount();
            double newTo = oldTo + transaction.getAmount();

            accounts.put(transaction.getFrom(), newFrom);
            accounts.put(transaction.getTo(), newTo);
            }

        accounts.forEach((key, value) ->
                System.out.println(key + ": " + String.format("%.2f", value)));

    }
}

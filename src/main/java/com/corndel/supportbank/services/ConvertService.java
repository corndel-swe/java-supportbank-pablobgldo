// ConvertService.java
package com.corndel.supportbank.services;

import com.corndel.supportbank.models.Currency;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.HashMap;
import java.util.Map;

@Command(name = "convert")
public class ConvertService implements Runnable {

    @Parameters(index = "0")
    private double amount;

    @Parameters(index = "1")
    private String from;

    @Parameters(index = "2")
    private String to;

    private static final Map<String, Double> rates = new HashMap<>();

    static {
        rates.put("USD", 1.0);
        rates.put("GBP", 0.75);
        rates.put("EUR", 0.85);
    }

    @Override
    public void run() {

        Currency fromCurrency = new Currency(amount, from);
        Currency convertedCurrency = convertCurrency(fromCurrency, to);

        System.out.printf("%.2f %s is equal to %.2f %s%n",
                fromCurrency.getAmount(),
                fromCurrency.getCurrency(),
                convertedCurrency.getAmount(),
                convertedCurrency.getCurrency());
    }

    private Currency convertCurrency(Currency fromCurrency, String to) {
        double fromRate = rates.get(fromCurrency.getCurrency());
        double toRate = rates.get(to);
        double convertedAmount = fromCurrency.getAmount() * (toRate / fromRate);
        return new Currency(convertedAmount, to);
    }
}

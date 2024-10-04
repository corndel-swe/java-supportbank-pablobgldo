package com.corndel.supportbank.services;

import picocli.CommandLine.Command;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

@Command(name = "list")
public class CurrencyListService implements Runnable {

    public void run(){
        RatesAPI ratesAPI = new RatesAPI();
        var rates = ratesAPI.getRates();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Double> ratesMap = mapper.convertValue(rates, Map.class);
        for (Map.Entry<String, Double> entry : ratesMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        };
    }


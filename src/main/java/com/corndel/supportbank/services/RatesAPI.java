package com.corndel.supportbank.services;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.cdimascio.dotenv.Dotenv;
import kong.unirest.Unirest;
import com.fasterxml.jackson.databind.ObjectMapper;


public class RatesAPI {

    public JsonNode getRates() {

        try {
            Dotenv dotenv = Dotenv.load();
            String appId = dotenv.get("OPEN_EXCHANGE_RATES_APP_ID");
            String url = "https://openexchangerates.org/api/latest.json?app_id=" + appId;

            var response = Unirest
                    .get(url)
                    .header("Content-Type", "application/json")
                    .asString();

            String json = response.getBody();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(json);
                return rootNode.path("rates");

        } catch (Exception e) {
            System.out.println("Oh no, an error occurred:" + e);;
        }
        return null;
    }

    public double getRate(String currency) {

        try {
            JsonNode rates = getRates();
            JsonNode rate = rates.get(currency);
                return rate.asDouble();

        } catch (Exception e) {
            System.out.println("Oh no, an error occurred:" + e);;
        }

        return 0;
    }
}

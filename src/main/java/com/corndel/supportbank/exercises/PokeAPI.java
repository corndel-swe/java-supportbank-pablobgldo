package com.corndel.supportbank.exercises;

import com.fasterxml.jackson.core.type.TypeReference;
import kong.unirest.Unirest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class represents a Pokemon. It uses Java's record syntax to
 * automatically generate a class with getters and utility methods.
 * See this url for more info:
 * https://www.baeldung.com/java-record-keyword
 */
@JsonIgnoreProperties(ignoreUnknown = true)
record Pokemon(Integer id, String name, Integer height, Integer weight) {
}

public class PokeAPI {
  /**
   * Get a Pokemon by its name.
   *
   * Makes a GET request to the PokeAPI, and uses Jackson to parse the JSON
   * response into a Pokemon object.
   *
   * @param name The name of the Pokemon to retrieve.
   * @return The Pokemon object.
   */
  public static Pokemon getPokemonByName(String name) throws Exception {
    // TODO: Create the url by appending the name to the base url
    String url = "https://pokeapi.co/api/v2/pokemon/" + name;

    // TODO: Make a GET request to the url
    var response = Unirest
            .get(url)
            .header("Accept", "application/json")
            .asString();

    // TODO: Parse the response body into a Pokemon object
    String json = response.getBody();
    ObjectMapper mapper = new ObjectMapper();
    Pokemon pokemon = mapper.readValue(json, Pokemon.class);

    // TODO: Return the Pokemon
    return pokemon;
  }

  public static List<Pokemon> getPokemonList() throws Exception {
      String url = "https://pokeapi.co/api/v2/pokemon/";
      var response = Unirest
            .get(url)
            .header("Content-Type", "application/json")
            .asString();
    String json = response.getBody();
    ObjectMapper mapper = new ObjectMapper();
    var rootNode = mapper.readTree(json);
    var results = rootNode.get("results");
    List<Map<String, String>> list = mapper.convertValue(results, new TypeReference<>() {});

    List<String> names = list.stream().map(x -> x.get("name")).toList();

    List<Pokemon> pokemonList = new ArrayList<>();

    for (String name : names) {
      String url2 = "https://pokeapi.co/api/v2/pokemon/" + name;
      var response2 = Unirest
              .get(url2)
              .header("Content-Type", "application/json")
              .asString();
      String json2 = response2.getBody();
      ObjectMapper mapper2 = new ObjectMapper();
      var rootNode2 = mapper2.readTree(json2);
      int id = rootNode2.get("id").asInt();
      int height = rootNode2.get("height").asInt();
      int weight = rootNode2.get("weight").asInt();

      Pokemon pokemon = new Pokemon(id, name, height, weight);
      pokemonList.add(pokemon);
    }
    System.out.println(pokemonList);
      return pokemonList;
  }

  /**
   * For debugging purposes..
   */
  public static void main(String[] args) {
    try {
      Pokemon pokemon = getPokemonByName("pikachu");
      System.out.println(pokemon);
      getPokemonList();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

package com.corndel.supportbank.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Element {
  /**
   * Given a filename, returns an Element with the corresponding properties.
   * The filename should be the name of a JSON file in the "src/data/elements"
   * directory with the same name as the element.
   *
   * @param fileName The name of the file containing the element's properties.
   * @return An Element object with properties from the given file.
   * @throws IOException
   */
  public static Element fromJSONFile(String fileName) throws IOException {

    try {
      Path path = Paths.get("src", "data", "elements", fileName);
      List<String> result = Files.readAllLines(path);
      String stringResult = String.join(" ", result);
      ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(stringResult, Element.class);
    } catch (IOException e) {
        System.err.println("Something went wrong");
    }
    return null;
  }

  /**
   * Main method for debugging purposes. Prints the Element.
   */
  public static void main(String[] args) {
    Element element;
    try {
      element = fromJSONFile("helium.json");
      System.out.println(element);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private int atomicNumber;
  private String symbol;
  private String name;
  private double atomicMass;
  private int period;
  private int group;

  public Element() {
  }

  public Element(int atomicNumber, String symbol, String name, double atomicMass, int period, int group) {
    this.atomicNumber = atomicNumber;
    this.symbol = symbol;
    this.name = name;
    this.atomicMass = atomicMass;
    this.period = period;
    this.group = group;
  }

  public int getAtomicNumber() {
    return atomicNumber;
  }

  public void setAtomicNumber(int atomicNumber) {
    this.atomicNumber = atomicNumber;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getAtomicMass() {
    return atomicMass;
  }

  public void setAtomicMass(double atomicMass) {
    this.atomicMass = atomicMass;
  }

  public int getPeriod() {
    return period;
  }

  public void setPeriod(int period) {
    this.period = period;
  }

  public int getGroup() {
    return group;
  }

  public void setGroup(int group) {
    this.group = group;
  }

  @Override
  public String toString() {
    return "Element [atomicNumber=" + atomicNumber + ", symbol=" + symbol + ", name=" + name + ", atomicMass="
        + atomicMass + ", period=" + period + ", group=" + group + "]";
  }
}

package com.corndel.supportbank.exercises;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class Adder {


  public int add(String fileName) {

      try {
        Path path = Paths.get("src", "data", fileName);
        List<String> result = Files.readAllLines(path);
        return result.stream().map(Integer::parseInt).reduce(0, Integer::sum);
      } catch (IOException e) {
          System.err.println("Something went wrong");
      }
      return 0;
  }

  public static void main(String[] args) {
    Adder adder = new Adder();
    System.out.println(adder.add("nums.txt"));
  }
}

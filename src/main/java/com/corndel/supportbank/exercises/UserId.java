package com.corndel.supportbank.exercises;

@SuppressWarnings("unused")
public class UserId {
  private String id;

  public UserId(String id) {
    this.id = id;
  }

  public boolean validate() {

    if (this.id.length() % 2 == 0) {
      throw new IllegalArgumentException("The id must be an odd number of characters long");
    }

    if (!this.id.contains("a")) {
      throw new IllegalArgumentException("The id must contain the letter 'a'");
    }

    if (!this.id.toLowerCase().equals(this.id)) {
      throw new IllegalArgumentException("The id must be all lowercase");
    }

    return true;
  }
}

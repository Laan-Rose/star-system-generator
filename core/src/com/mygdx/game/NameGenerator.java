package com.mygdx.game;

import java.util.Random;

/**
 * File: NameGenerator.java
 * Author: Laan Rose
 * Purpose: Generates star/planet names that (hopefully) sound somewhat legitimate.
 */
public class NameGenerator {
  private Random random = new Random();

  public String generateName() {
    return random.nextInt(99999) + "";
  }
}

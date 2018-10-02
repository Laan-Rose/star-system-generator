package com.mygdx.game;

import java.util.Random;

/**
 * File: PlanetarySystem.java
 * Author: Laan Rose
 * Purpose: Represents a 3D planetary system (https://en.wikipedia.org/wiki/Planetary_system).
 * Contains multiple AstronomicalObject objects, which represent the stars and planets in this
 * system.
 */
public class PlanetarySystem {
  private String name;
  private AstronomicalObject[] objects; // Stars and planets contained within this system.
  private Random random = new Random();

  public void generate() {
    int planets = random.nextInt(8) + 3;
    objects = new AstronomicalObject[planets + 1]; // +1 to make an index for the star.

    // Generate planets and central star.
    for (int x = 1; x < planets; x++) {

    }
  }

  /**
   * Returns the ModelInstance of a given star/planet, which is used to render the star/planet.
   */
  public void getObjectInstance() {
  }

  /**
   * Returns the Vector3 object of a given star/planet, which holds the star/planet's position.
   */
  public void getObjectVector3() {
  }


  public AstronomicalObject[] getObjects() {
    return objects;
  }
}

package com.mygdx.game;

import com.badlogic.gdx.graphics.g3d.ModelInstance;

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
  private Star star;
  private AstronomicalObject objects[];
  private Random random = new Random();

  public void generate() {
    int systemSize = random.nextInt(6) + 5;

    objects = null;
    objects = new AstronomicalObject[systemSize];

    // Generate central star.
    objects[0] = new Star();
    objects[0].generate();

    // Generate surrounding planets.
  }

  /**
   * Returns the ModelInstance of a given star/planet, which is used to render the star/planet.
   */
  public ModelInstance getObjectInstance(int object) {
    return objects[object].getInstance();
  }

  /**
   * Returns the Vector3 object of a given star/planet, which holds the star/planet's position.
   */
  public void getObjectVector3() {
  }
}

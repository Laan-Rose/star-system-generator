package com.mygdx.game;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Sphere;

import java.util.Random;

/**
 * File: AstronomicalObject.java
 * Author: Laan Rose
 * Purpose: Represents an astronomical object (https://en.wikipedia.org/wiki/Astronomical_object),
 * though limited to only stars or planets for this program.
 */
public class AstronomicalObject {
  private String name;
  private ModelInstance instance;
  private Model model;
  private Vector3 position;
  private Random random = new Random();

  /**
   * Generate values for this astronomical object so that it becomes a star.
   */
  public void generateAsStar() {

  }

  /**
   * Generate values for this astronomical object so that it becomes a rocky planet.
   */
  public void generateAsRockyPlanet() {

  }

  /**
   * Generate values for this astronomical object so that it becomes a gas giant.
   */
  public void generateAsGasGiant() {

  }

  /**
   * Generate values for this astronomical object so that it becomes an ice giant.
   */
  public void generateAsIceGiant() {

  }
}

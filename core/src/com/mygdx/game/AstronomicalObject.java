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
  private int perihelion;
  private int orbitalSpeed;
  private int radius;
  private
  private Random random = new Random();
  private NameGenerator nameGen = new NameGenerator();

  public void AstronomicalObject() {
    name = nameGen.generateName();


  }

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

  /**
   * Updates the position of this star/planet over time- a call to update() will make this planet
   * orbit about its star by a small distance.
   */
  public void update() {

  }

  public ModelInstance getInstance() {
    return instance;
  }

  public Vector3 getPosition() {
    return position;
  }

  public String getName() {
    return name;
  }
}

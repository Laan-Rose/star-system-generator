package com.mygdx.game;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

/**
 * File: AstronomicalObject.java
 * Author: Laan Rose
 * Purpose: Represents an astronomical object (https://en.wikipedia.org/wiki/Astronomical_object),
 * though limited to only stars or planets for this program.
 */
public abstract class AstronomicalObject {
  protected String name;
  protected ModelInstance instance;
  protected Model model;
  protected Vector3 position;
  protected ModelBuilder builder = new ModelBuilder();
  protected Random random = new Random();
  protected NameGenerator nameGen = new NameGenerator();

  public void AstronomicalObject() {
    name = nameGen.generateName();
  }

  public abstract void generate();

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

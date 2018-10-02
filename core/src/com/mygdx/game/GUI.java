package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;


/**
 * File: GUI.java
 * Author: Laan Rose
 * Purpose: Displays a window containing a procedurally generated planetary system.
 */
public class GUI extends ApplicationAdapter {
  private PerspectiveCamera camera;
  private ModelBatch modelBatch;
  private Environment environment;
  private ModelBuilder modelBuilder = new ModelBuilder();
  private Material mat;
  private Random rng = new Random();
  // Objects representing the state of displayed planets/stars.
  private Model[] objectModel;
  private ModelInstance[] objectInstance;
  private Vector3[] objectPosition;

  @Override
  public void create () {
    // Set view options, including antialiasing.
    Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling?GL20.GL_COVERAGE_BUFFER_BIT_NV:0));

    // Make a camera that's looking down upon the star system.
    camera = new PerspectiveCamera(67,
      Gdx.graphics.getWidth(),
      Gdx.graphics.getHeight());
    camera.position.set(75f, 75f, 75f);
    camera.lookAt(0, 0, 0);
    camera.near = 1f;
    camera.far = 3000f;
    camera.update();

    // Create environmental lighting.
    environment = new Environment();
    environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 1.0f, 1.0f, 1.0f, 1f));
    Vector3 sunlightPosition = new Vector3();
    environment.add(new PointLight().set(50.0f, 50.0f, 50.0f, sunlightPosition, 2000));

    // Generate and display initial planetary system.
    generatePlanetarySystem();
    render();
  }

  /**
   * Creates a new star and set of planets.
   */
  public void generatePlanetarySystem() {
    // Remove old planetary system (if one has already been generated).
    dispose();

    // Initialize new system.
    initializeNewSystem();

    // Generate star.
    int size = rng.nextInt(6) + 6;
    mat = new Material(ColorAttribute.createDiffuse(Color.YELLOW));
    objectModel[0] = modelBuilder.createSphere(size, size, size, 20, 20, mat,
      VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
    objectInstance[0] = new ModelInstance(objectModel[0]);
    objectInstance[0].transform.getTranslation(objectPosition[0]);
    objectPosition[0].x = 0.0f; // Star located in center of system
    objectPosition[0].z = 0.0f;
    objectInstance[0].transform.setTranslation(objectPosition[0]);

    // Generate planets.
    for (int x = 1; x < objectModel.length; x++)  {
      size = rng.nextInt(4) + 2;
      mat = new Material(ColorAttribute.createDiffuse(Color.BROWN));
      objectModel[x] = modelBuilder.createSphere(size, size, size, 20, 20, mat,
        VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
      objectInstance[x] = new ModelInstance(objectModel[x]);
      objectInstance[x].transform.getTranslation(objectPosition[x]);
      objectPosition[x].x = ((float) (rng.nextInt(8000) - 4000)) / 100;
      objectPosition[x].z = ((float) (rng.nextInt(8000) - 4000)) / 100;
      objectInstance[x].transform.setTranslation(objectPosition[x]);
    }
  }

  /**
   * Resets all arrays that contain info for planets/stars to a new size for a new system.
   */
  public void initializeNewSystem() {
    // Initialize a model, instance, and position object for each planet/star.
    objectModel = new Model[10];
    objectInstance = new ModelInstance[10];
    objectPosition = new Vector3[10];
    // Initialize positions to the center of the planetary system.
    for (int x = 0; x < objectPosition.length; x++) {
      objectPosition[x] = new Vector3();
    }

    modelBatch = new ModelBatch();
  }

  /**
   * Remove old planetary system data and display.
   */
  @Override
  public void dispose() {
    // Only dispose of objects if a planetary system has been generated already.
    if (objectModel != null) {
      for (int x = 0; x < objectModel.length; x++) {
        objectModel[x].dispose();
      }
    }
    if (modelBatch != null) {
      modelBatch.dispose();
      modelBatch = null;
    }

    // Set arrays to null, reinitialize them later for a new planetary system.
    objectModel = new Model[10];
    objectPosition = new Vector3[10];
    objectInstance = new ModelInstance[10];
  }

  @Override
  public void render() {
    // Set view options, including antialiasing.
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling?GL20.GL_COVERAGE_BUFFER_BIT_NV:0));

    // Render all planetary system objects.
    modelBatch.begin(camera);
    for (int x = 0; x < 9; x++) {
      modelBatch.render(objectInstance[x], environment);
    }
    modelBatch.end();

    // Begin processing user input.
    controls();
  }

  /**
   * Adds key functionality.
   */
  public void controls() {
    if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
      generatePlanetarySystem();
    }
  }
}

package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.DirectionalLightsAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.PointLightsAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.SpotLightsAttribute;
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
  public PerspectiveCamera camera;
  public ModelBatch modelBatch;
  public Environment environment;
  public ModelBuilder modelBuilder = new ModelBuilder();
  public Material mat;
  private Random rng = new Random();
  Vector3 position = new Vector3();
  Vector3 lightPos = position;
  // Astronomical objects.
  public Model[] objectModel = new Model[30];
  public ModelInstance[] objectInstance = new ModelInstance[30];
  public Vector3[] objectPosition = new Vector3[30];

  @Override
  public void create () {
    // Make a camera that's looking down upon the star system.
    camera = new PerspectiveCamera(67,
      Gdx.graphics.getWidth(),
      Gdx.graphics.getHeight());
    camera.position.set(50f, 50f, 50f);
    camera.lookAt(0, 0, 0);
    camera.near = 1f;
    camera.far = 3000f;
    camera.update();

    // Initialize planets and stars.
    for (int x = 0; x < objectModel.length; x++) {
      objectModel[x] = new Model();
      objectPosition[x] = new Vector3();
    }

    // Create environment and lighting.
    modelBatch = new ModelBatch();
    environment = new Environment();
    environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 1.0f, 1.0f, 1.0f, 1f));
    environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
    //lightPos.y += 20.0;
    //environment.add(new PointLight().set(1.0f, 1.0f, 1.0f, lightPos, 1000));

    // Create and add planetary system.
    generatePlanetarySystem();
  }

  /**
   * Creates a star and planets.
   */
  public void generatePlanetarySystem() {
    // Remove old stars/planets.
    reset();

    // Star.
    int size = rng.nextInt(6) + 6;
    mat = new Material(ColorAttribute.createDiffuse(Color.YELLOW));
    objectModel[0] = modelBuilder.createSphere(size, size, size, 20, 20, mat,
      VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
    objectInstance[0] = new ModelInstance(objectModel[0]);
    objectInstance[0].transform.getTranslation(objectPosition[0]);
    objectPosition[0].x = 0.0f; // Star located in center of system
    objectPosition[0].z = 0.0f;
    objectInstance[0].transform.setTranslation(objectPosition[0]);

    // Planets.
    for (int x = 1; x < 10; x++)  {
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

    render();
  }

  @Override
  public void render() {
    // View options- antialiasing.
    Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling?GL20.GL_COVERAGE_BUFFER_BIT_NV:0));

    modelBatch.begin(camera);
    for (int x = 0; x < 9; x++) {
      modelBatch.render(objectInstance[x], environment);
    }
    modelBatch.end();

    controls();
  }

  public void redraw() {

  }

  private void controls() {
    if (Gdx.input.isKeyPressed(Input.Keys.W)){
      //dispose();
      generatePlanetarySystem();
    }
  }

  private void movement() {
    /*instance.transform.getTranslation(position);
    if(Gdx.input.isKeyPressed(Input.Keys.W)){
        position.x += Gdx.graphics.getDeltaTime() * 20;
    }
    if(Gdx.input.isKeyPressed(Input.Keys.D)){
        position.z+=Gdx.graphics.getDeltaTime() * 20;
    }
    if(Gdx.input.isKeyPressed(Input.Keys.A)){
        position.z-=Gdx.graphics.getDeltaTime() * 20;
    }
    if(Gdx.input.isKeyPressed(Input.Keys.S)){
        position.x-=Gdx.graphics.getDeltaTime() * 20;
    }
    instance.transform.setTranslation(position);*/
  }

  /**
   * Remove/reset all data for the current system.
   */
  public void reset() {
    dispose();

    for (int x = 0; x < objectInstance.length; x++) {
      objectInstance[x] = null;
      objectPosition[x].x = 0.0f;
      objectPosition[x].y = 0.0f;
      objectPosition[x].z = 0.0f;
    }
  }

  @Override
  public void dispose() {
    for (int x = 0; x < objectModel.length; x++) {
      objectModel[x].dispose();
    }
  }
}

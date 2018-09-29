package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.collision.Sphere;

/**
 * File: GUI.java
 * Author: Laan Rose
 * Purpose: Displays a window containing a procedurally generated planetary system.
 */

public class GUI extends ApplicationAdapter {
  SpriteBatch batch;
  Texture img;
  Sphere astronomicalObject[]; // All the stars, planets, asteroids, etc. displayed onscreen.

  @Override
  public void create () {
    batch = new SpriteBatch();
    //img = new Texture("core/assets/badlogic.jpg");
  }

  @Override
  public void render () {
    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    batch.begin();
    batch.draw(img, 0, 0);
    batch.end();
  }

  @Override
  public void dispose () {
    batch.dispose();
    img.dispose();
  }
}

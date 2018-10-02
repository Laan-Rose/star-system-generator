package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.math.Vector3;

import java.io.Serializable;

/**
 * File: Star.java
 * Author: Laan Rose
 */
public class Star extends AstronomicalObject implements Serializable {
  /**
   * Generates values for this star which correspond to one of the 7 spectral star types.
   * Classification of stars: http://www.atlasoftheuniverse.com/startype.html
   */
  public void generate() {
    // 7 spectral types, only main sequence stars (for now). Ratio of star types not realistic.
    int spectralType = random.nextInt(7);

    // Create 3D instance of star.
    int size = generateStarSize(spectralType);
    Material mat = generateStarColor(spectralType);
    model = builder.createSphere(size, size, size, 20, 20, mat,
      VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
    instance = new ModelInstance(model);

    // Center star in the middle of the system.
    position = new Vector3();
    instance.transform.getTranslation(position);
    position.x = 0.0f;
    position.z = 0.0f;
    instance.transform.setTranslation(position);

    name = nameGen.generateName();
  }

  /**
   * Generates a value for the size of a star based on its type (not to scale).
   * @param spectralType
   * @return
   */
  public int generateStarSize(int spectralType) {
    int size = 1;

    // O-class star.
    if (spectralType == 0) {
      size = 12;
    }
    // B-class star.
    else if (spectralType == 1) {
      size = 10;
    }
    // A-class star.
    else if (spectralType == 2) {
      size = 8;
    }
    // F-class star.
    else if (spectralType == 3) {
      size = 7;
    }
    // G-class star.
    else if (spectralType == 4) {
      size = 6;
    }
    // K-class star.
    else if (spectralType == 5) {
      size = 6;
    }
    // M-class star.
    else if (spectralType == 6) {
      size = 4;
    }

    return size;
  }

  /**
   * Returns a material color for a star based on the given star type.
   * @param spectralType
   * @return
   */
  public Material generateStarColor(int spectralType) {
    Material mat = new Material(ColorAttribute.createDiffuse(Color.LIME));

    // O-class star.
    if (spectralType == 0) {
      mat = new Material(ColorAttribute.createDiffuse(Color.CYAN));
    }
    // B-class star.
    else if (spectralType == 1) {
      mat = new Material(ColorAttribute.createDiffuse(Color.CYAN));
    }
    // A-class star.
    else if (spectralType == 2) {
      mat = new Material(ColorAttribute.createDiffuse(Color.WHITE));
    }
    // F-class star.
    else if (spectralType == 3) {
      mat = new Material(ColorAttribute.createDiffuse(Color.YELLOW));
    }
    // G-class star.
    else if (spectralType == 4) {
      mat = new Material(ColorAttribute.createDiffuse(Color.YELLOW));
    }
    // K-class star.
    else if (spectralType == 5) {
      mat = new Material(ColorAttribute.createDiffuse(Color.ORANGE));
    }
    // M-class star.
    else if (spectralType == 6) {
      mat = new Material(ColorAttribute.createDiffuse(Color.RED));
    }

    return mat;
  }
}

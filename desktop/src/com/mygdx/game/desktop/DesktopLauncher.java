package com.mygdx.game.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.GUI;

public class DesktopLauncher {
  public static void main(String[] arg) {
    LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
    config.title = "Star System Generator";
    config.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
    config.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;
    config.samples = 3;
    new LwjglApplication(new GUI(), config);
  }
}

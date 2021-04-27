package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Fondo {
    // variables
    Texture texture;

    // para crear el fondo.
    Fondo(){
        texture = new Texture("fondo.jpg");
    }

    // para mostrar el fondo en la posicion 0, 0.
    void render(SpriteBatch batch){
        batch.draw(texture, 0, 0);
    }
}

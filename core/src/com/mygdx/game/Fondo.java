package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Fondo {
    // variables
    Texture texture = new Texture("fondo.jpg");
    Animacion animacion = new Animacion(6f,true,"start1.png","start2.png","start3.png");

    // para mostrar el fondo en la posicion 0, 0.
    void render(SpriteBatch batch){
        batch.draw(texture, 0, 0);

    }
}

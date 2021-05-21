package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bala {
    // variables
    static Texture texture = new Texture("bala.png");
    float x, y, w , h, v;

    // para crear la imagen de bala y sus valores.
    Bala(float xNave, float yNave){
        w = 10;
        h = 50;
        x = xNave - w/2;
        y = yNave;
        v = 20;
    }
    // para mostrar la bala es la posicion X, Y.
    void render(SpriteBatch batch){
        batch.draw(texture, x, y, w,h);
    }

    // Esto es la velocidad que lo he puesto, cuando dispare la bala.
    void update(){
        y += v;
    }

}

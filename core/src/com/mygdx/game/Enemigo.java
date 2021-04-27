package com.mygdx.game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Enemigo {
    // variables
    Texture texture;
    float x, y, w, h, v;

    // para crear la imagen de enemigo y sus valores.
    Enemigo(){
        texture = new Texture("enemigo1.png");
        x = 300;
        y = 500;
        w = 80;
        h = 80;
        v = 2;
    }

    // para mostrar el avion es la posicion X, Y y que tenga tamaño de 100x100.
    void render(SpriteBatch batch){ batch.draw(texture, x, y, w, h); }

    // Es la velocidad y la posicion de mover el enemigo.
    public void update() {
        y -= 1;
        x += 1;
    }
}

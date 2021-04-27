package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;


public class Caza {
    // variables
    Texture texture;
    float x, y, w, h, v;
    List<Bala> balas;

    // para crear la imagen de avion y sus valores.
    Caza(){
        texture = new Texture("nave.png");
        x = 100;
        y = 100;
        w = 41;
        h = 56;
        v = 10;
        balas = new ArrayList<>();
    }

    // para mostrar el avion es la posicion X y Y.
    void render(SpriteBatch batch){
        batch.draw(texture, x, y, w, h);


        // Por cada bala que has creado en la ArrayList que los muestre.
        for (Bala bala: balas) {
            bala.render(batch);
        }
    }

    // Esto va las cosas que pasa, cuando clicas algo.
    void update(){
        // Si hay bala, que lo muestre, y que va moviendo con la velocidad que lo tengo puesto en la clase Bala.
        for (Bala bala: balas) {
            bala.update();
        }

        // Si presiono tecla D, que se mueva hacia derecha con un velocidad de v.
        if (Gdx.input.isKeyPressed(Input.Keys.D)) x += v;

        // Si presiono tecla A, que se mueva hacia izquierda con un velocidad de v.
		if (Gdx.input.isKeyPressed(Input.Keys.A)) x -= v;

        // Si presiono tecla W, que se mueva hacia arriba con un velocidad de v.
		if (Gdx.input.isKeyPressed(Input.Keys.W)) y += v;

        // Si presiono tecla S, que se mueva hacia abajo con un velocidad de v.
		if (Gdx.input.isKeyPressed(Input.Keys.S)) y -= v;

        // Si presiono tecla J, que se cree una bala en ArrayList con una posicion tal.
        if (Gdx.input.isKeyJustPressed(Input.Keys.J)) {
            balas.add(new Bala(x+w/2, y+h));
        }
    }
}

package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;


public class Caza {
    // variables
    Animacion animacion = new Animacion(6f, true,  "1.png","2.png");
    float x, y, w, h, v;
    List<Bala> balas = new ArrayList<>();
    int vidas = 3;
    int puntos = 0;
    boolean muerta = false;
    Temporizador fireRate = new Temporizador(10);
    Temporizador respawn = new Temporizador(120, false);
    Sonido sonido = new Sonido();


    // para crear la imagen de avion y sus valores.
    Caza(){
        x = 100;
        y = 100;
        w = 100;
        h = 50;
        v = 10;
    }

    void update(){
        for (Bala bala: balas) bala.update();

        if (Gdx.input.isKeyPressed(Input.Keys.D)) x += v;
		if (Gdx.input.isKeyPressed(Input.Keys.A)) x -= v;
		if (Gdx.input.isKeyPressed(Input.Keys.W)) y += v;
		if (Gdx.input.isKeyPressed(Input.Keys.S)) y -= v;

        if (Gdx.input.isKeyJustPressed(Input.Keys.J) && !fireRate.suena() && !muerta) {
            balas.add(new Bala(x+w/2, y+h));
            sonido.disparo.play(0.2f);
        }

        if (x<0) x = 1030;
        if (x>1030) x = 0;
        if (y<0) y = 0;
        if (y>585) y = 585;

        if(respawn.suena()){
            muerta = false;
        }
    }
    void render(SpriteBatch batch){
        if (muerta) batch.setColor(1,1,1,0.25f);
        batch.draw(animacion.getFrame(Temporizador.tiempoJuego), x, y, w, h);
        if (muerta) batch.setColor(1,1,1,1f);
        for (Bala bala: balas) bala.render(batch);


    }

    public void morir() {
        vidas--;
        muerta = true;

        respawn.activar();
    }
}

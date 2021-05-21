package com.mygdx.game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Enemigo2 {
    // variables
    Animacion animacion = new Animacion(6, true, "enemigo2.png");
    Texture texture = new Texture("explosion.png");
    float x, y, w, h, vx, vy;
    int vidas = 3;
    Temporizador cambioVelocidad = new Temporizador(60);
    Temporizador dead = new Temporizador(7);
    boolean explota = false;


    // para crear la imagen de enemigo y sus valores.
    Enemigo2(){
        x = Utils.random.nextInt(640);
        y = 650;
        w = 60;
        h = 60;
        vx = -2;
        vy = 0;
    }

    // para mostrar el avion es la posicion X, Y.
    void render(SpriteBatch batch){

        if (explota){
            batch.draw(texture, x, y, w, h);
        }else{
            batch.draw(animacion.getFrame(Temporizador.tiempoJuego), x, y, w, h);
        }
    }

    // Es la velocidad y la posicion de mover el enemigo.
    public void update() {
        y -= vy;
        x += vx;
        if (cambioVelocidad.suena()){
            vy = Utils.random.nextInt(3);
            vx = Utils.random.nextInt(6)-3;
        }
    }
}

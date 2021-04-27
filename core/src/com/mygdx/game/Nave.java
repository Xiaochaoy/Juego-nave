package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import java.util.ArrayList;
import java.util.List;

public class Nave extends ApplicationAdapter {
	// variables
	SpriteBatch batch;
	Caza caza;
	Fondo fondo;
	List<Enemigo> enemigos;
	Temporizador temporizadorNuevoEnemigo;

	@Override
	public void create () {
		batch = new SpriteBatch();
		caza = new Caza(); 				// Para mostrar la funcion Caza de la clase Caza.
		fondo = new Fondo(); 			// Para mostrar la funcion Fondo de la clase Fondo.
		enemigos = new ArrayList<>();   // Para decir que enemigos es una lista de Arrays.

		enemigos.add(new Enemigo());    // Para añadir un nuevo Enemigo en enemigos.

		temporizadorNuevoEnemigo = new Temporizador(120);   // Para decir que temporizadorNuevoEnemigo es el tiempo para crear un nuevo Enemigo.
	}

	// esto es lo que va mostrar todo el rato del juego.
	@Override
	public void render () {
		Gdx.gl.glClearColor(0,0,0,0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		Temporizador.tiempoJuego += 1;  // Que va sumar 1 por acabes que ejecute este bucle.

		// Cuando el tio suena, significa que es la hora de crear un nuevo Enemigo.
		if(temporizadorNuevoEnemigo.suena()){
			enemigos.add(new Enemigo());
		}

		caza.update(); 			// Para cuando hago movimiento que actualize los datos.
		for(Enemigo enemigo : enemigos) enemigo.update();    // Para cuando hago movimiento que actualize los datos.

		batch.begin(); 					// Comienza a guardar las cosas que va mostrar en la pantalla.
		fondo.render(batch); 			// Ejecutar la funcion render de la clase Fondo y le mandamos un batch para que funcione.
		caza.render(batch); 			// Ejecutar la funcion render de la clase Caza y le mandamos un batch para que funcione.
		for(Enemigo enemigo : enemigos) enemigo.render(batch);   // Ejecutar la funcion render de la clase Enemigo y le mandamos un batch para que funcione.
		batch.end(); 					// Y esto manda directamente a la RAM para que ejecute de golpe.
	}
}

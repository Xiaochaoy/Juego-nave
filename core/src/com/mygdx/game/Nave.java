package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.List;

public class Nave extends ApplicationAdapter {
	// variables
	SpriteBatch batch;
	BitmapFont bitmapFont;
	BitmapFont bpausa;
	Caza caza;
	Fondo fondo;
	List<Enemigo> enemigos;
	List<Enemigo2> enemigos2;
	List<Enemigo3> enemigos3;
	List<Bala> balasAEliminar;
	List<Enemigo> enemigosAEliminar;
	List<Enemigo2> enemigosAEliminar2;
	List<Enemigo3> enemigosAEliminar3;
	Temporizador temporizadorNuevoEnemigo;
	Temporizador temporizadorNuevoEnemigo2;
	Temporizador temporizadorNuevoEnemigo3;
	ScoreBoard scoreboard;
	boolean gameover;
	boolean pausa;
	boolean start;
	Sonido sonido;

	@Override
	public void create () {
		sonido = new Sonido();
		batch = new SpriteBatch();
		bitmapFont = new BitmapFont();
		bpausa = new BitmapFont();
		bitmapFont.setColor(Color.WHITE);
		bitmapFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		bitmapFont.getData().setScale(2f);
		bpausa.setColor(Color.PINK);
		bpausa.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		bpausa.getData().setScale(4f);

		inicializarJuego();

	}

	void inicializarJuego(){
		fondo = new Fondo();
		caza = new Caza();
		enemigos = new ArrayList<>();
		enemigos2 = new ArrayList<>();
		enemigos3 = new ArrayList<>();
		balasAEliminar = new ArrayList<>();
		enemigosAEliminar = new ArrayList<>();
		enemigosAEliminar2 = new ArrayList<>();
		enemigosAEliminar3 = new ArrayList<>();
		temporizadorNuevoEnemigo = new Temporizador(120);
		temporizadorNuevoEnemigo2 = new Temporizador(180);
		temporizadorNuevoEnemigo3 = new Temporizador(500);
		scoreboard = new ScoreBoard();
		sonido.music.play();
		sonido.music.setVolume(0.1f);
		gameover = false;
		pausa = false;
		start = false;

	}

	void update() {

			Temporizador.tiempoJuego += 1;

			if (Gdx.input.isKeyJustPressed(Input.Keys.P)) pausa = !pausa;
			if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) start = true;

		if (temporizadorNuevoEnemigo.suena()) enemigos.add(new Enemigo());
			if (temporizadorNuevoEnemigo2.suena()) enemigos2.add(new Enemigo2());
			if (temporizadorNuevoEnemigo3.suena()) enemigos3.add(new Enemigo3());
			if (start) {
				if (!pausa) {
					if (!gameover) {
						caza.update();
						for (Enemigo enemigo : enemigos)
							enemigo.update();
						for (Enemigo2 enemigo2 : enemigos2)
							enemigo2.update();
						for (Enemigo3 enemigo3 : enemigos3)
							enemigo3.update();
					}
				}
			}
			for (Enemigo enemigo : enemigos) {
				for (Bala bala : caza.balas) {
					if (Utils.solapan(bala.x, bala.y, bala.w, bala.h, enemigo.x, enemigo.y, enemigo.w, enemigo.h)) {
						enemigo.vidas--;
						sonido.danyo.play(10f);
						if (enemigo.vidas == 0) {
							caza.puntos++;
							enemigo.explota = true;
							enemigo.dead.activar();
							sonido.explotar.play();
							sonido.danyo.stop();
						}
						balasAEliminar.add(bala);
						break;
					}
				}
				if (!gameover && !caza.muerta && Utils.solapan(enemigo.x, enemigo.y, enemigo.w, enemigo.h, caza.x, caza.y, caza.w, caza.h)) {
					caza.morir();
					enemigosAEliminar.add(enemigo);
					if (caza.vidas == 0) {
						gameover = true;
					}
				}
				if (enemigo.y < -80) enemigosAEliminar.add(enemigo);
				if (enemigo.x < -20) enemigo.x = 1020;
				if (enemigo.x > 1040) enemigo.x = -20;
				if (enemigo.explota && enemigo.dead.suena()){
					enemigosAEliminar.add(enemigo);
				}
			}
			for (Enemigo2 enemigo2 : enemigos2) {
				for (Bala bala : caza.balas) {
					if (Utils.solapan(bala.x, bala.y, bala.w, bala.h, enemigo2.x, enemigo2.y, enemigo2.w, enemigo2.h)) {
						enemigo2.vidas--;
						sonido.danyo.play(10f);
						if (enemigo2.vidas == 0) {
							enemigo2.explota = true;
							enemigo2.dead.activar();
							caza.puntos += 2;
							sonido.explotar.play();
							sonido.danyo.stop();
						}
						balasAEliminar.add(bala);
						break;
					}
				}
				if (!gameover && !caza.muerta && Utils.solapan(enemigo2.x, enemigo2.y, enemigo2.w, enemigo2.h, caza.x, caza.y, caza.w, caza.h)) {
					caza.morir();
					enemigosAEliminar2.add(enemigo2);
					if (caza.vidas == 0) {
						gameover = true;
					}
				}
				if (enemigo2.y < -80) enemigosAEliminar2.add(enemigo2);
				if (enemigo2.x < -20) enemigo2.x = 1020;
				if (enemigo2.x > 1040) enemigo2.x = -20;
				if (enemigo2.explota && enemigo2.dead.suena()){
					enemigosAEliminar2.add(enemigo2);
				}
			}
			for (Enemigo3 enemigo3 : enemigos3) {
				for (Bala bala : caza.balas) {
					if (Utils.solapan(bala.x, bala.y, bala.w, bala.h, enemigo3.x, enemigo3.y, enemigo3.w, enemigo3.h)) {
						enemigo3.vidas--;
						sonido.danyo.play(10f);
						if (enemigo3.vidas == 0) {
							enemigo3.explota = true;
							enemigo3.dead.activar();
							caza.puntos += 4;
							sonido.explotar.play();
							sonido.danyo.stop();
						}
						balasAEliminar.add(bala);
						break;
					}
				}
				if (!gameover && !caza.muerta && Utils.solapan(enemigo3.x, enemigo3.y, enemigo3.w, enemigo3.h, caza.x, caza.y, caza.w, caza.h)) {
					caza.morir();
					enemigosAEliminar3.add(enemigo3);
					if (caza.vidas == 0) {
						gameover = true;
					}
				}
				if (enemigo3.y < -80) enemigosAEliminar3.add(enemigo3);
				if (enemigo3.x < -20) enemigo3.x = 1020;
				if (enemigo3.x > 1040) enemigo3.x = -20;
				if (enemigo3.explota && enemigo3.dead.suena()){
					enemigosAEliminar3.add(enemigo3);
				}
			}
			for (Bala bala : caza.balas) {
				if (bala.y > 590) {
					balasAEliminar.add(bala);
				}
			}

			if (pausa){
				batch.setColor(1,1,1,0.25f);
				bitmapFont.setColor(Color.BLUE);
				sonido.music.pause();
			}else{
				batch.setColor(1,1,1,1f);
				bitmapFont.setColor(Color.WHITE);
				sonido.music.play();
			}

			for (Bala bala : balasAEliminar) caza.balas.remove(bala);
			for (Enemigo enemigo : enemigosAEliminar) enemigos.remove(enemigo);
			for (Enemigo2 enemigo2 : enemigosAEliminar2) enemigos2.remove(enemigo2);
			for (Enemigo3 enemigo3 : enemigosAEliminar3) enemigos3.remove(enemigo3);
			balasAEliminar.clear();
			enemigosAEliminar.clear();

			if(gameover) {
				sonido.music.stop();
				int result = scoreboard.update(caza.puntos);
				if(result == 1) {
					inicializarJuego();
				} else if (result == 2) {
					Gdx.app.exit();
				}
			}
	}
	@Override
	public void render () {
		Gdx.gl.glClearColor(0,0,0,0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		update();

		batch.begin();
		if(!start){
			batch.draw(fondo.animacion.getFrame(Temporizador.tiempoJuego), 0, 0);
		}else{
			fondo.render(batch);
			caza.render(batch);
		}
		for(Enemigo enemigo : enemigos) enemigo.render(batch);
		for(Enemigo2 enemigo2 : enemigos2) enemigo2.render(batch);
		for(Enemigo3 enemigo3 : enemigos3) enemigo3.render(batch);
		if (pausa){
			bpausa.draw(batch,"PAUSA", 450, 350);
		}

		bitmapFont.draw(batch, "VIDAS: "+caza.vidas, 30, 600);
		bitmapFont.draw(batch, "PUNTOS: "+caza.puntos, 30, 550);
		if (gameover){
			scoreboard.render(batch, bitmapFont);
		}
		batch.end();
	}
}

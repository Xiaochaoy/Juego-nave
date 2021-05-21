package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class Sonido {
    public Sound disparo = Gdx.audio.newSound(Gdx.files.internal("shot.mp3"));
    public Sound danyo = Gdx.audio.newSound(Gdx.files.internal("hurt.mp3"));
    public Sound explotar = Gdx.audio.newSound(Gdx.files.internal("explota.mp3"));
    public Music music = Gdx.audio.newMusic(Gdx.files.internal("Battleship.ogg"));
    public Music gameover = Gdx.audio.newMusic(Gdx.files.internal("Gameover.mp3"));
}

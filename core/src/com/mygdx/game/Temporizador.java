package com.mygdx.game;

public class Temporizador {
    // variables
    static int tiempoJuego;
    int alarma;
    int frecuencia;

    // Es el tiempo que le damos para crear el nuevo enemigo
    Temporizador(int f){
        frecuencia = f;
        alarma = tiempoJuego + f;
    }

    // Cuando el tiempoJuego sea igual que alarma, retornamos un true para crear nuevo enemigo y le subimos el valor de alarma.
    public boolean suena() {
        if (tiempoJuego == alarma) {
            alarma = tiempoJuego + frecuencia;
            return true;
        }
        return false;
    }
}

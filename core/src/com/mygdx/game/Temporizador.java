package com.mygdx.game;

public class Temporizador {
    // variables
    static int tiempoJuego;
    int alarma;
    int frecuencia;
    boolean repetir = true;
    boolean activo = true;

    // Es el tiempo que le damos para crear el nuevo enemigo
    Temporizador(int f){
        this.frecuencia = f;
        alarma = tiempoJuego + f;
    }
    Temporizador(int f, boolean r){
        this.frecuencia = f;
        alarma = tiempoJuego + f;
        this.repetir = r;
    }

    // Cuando el tiempoJuego sea igual que alarma, retornamos un true para crear nuevo enemigo y le subimos el valor de alarma.
    public boolean suena() {
        if (activo) {
            if (tiempoJuego == alarma) {
                alarma = tiempoJuego + frecuencia;
                if (!repetir) {
                    activo = false;
                }
                return true;
            }
        }
            return false;
    }

    public void activar() {
        activo = true;
        alarma = tiempoJuego + frecuencia;
    }
}

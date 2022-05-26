package Clases;

import java.util.Arrays;

public class Pais {
    private Jugador[] jugadores = new Jugador[23];
    int i = 0;

    public Pais() {
    }


    public Pais(Jugador jugador) {
        this.jugadores[i] = jugador;
    }

    public Jugador getJugadores(int j) {
        return this.jugadores[j];
    }

    public void setJugadores(Jugador jugador) {
        this.jugadores[i] = jugador;
        i++;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "jugadores=" + Arrays.toString(jugadores) +
                '}';
    }
}

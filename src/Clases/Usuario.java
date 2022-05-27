package Clases;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Usuario extends JFrame{

    LinkedList<Jugador>jugadores = new LinkedList<>();
    LinkedList<Jugador>jugadoresRepetidos = new LinkedList<>();
    private String tipoDeUsuario;  //Basic, Silver o Gold

    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(String tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public Usuario() {
    }

    public boolean buscarJugador(Jugador jugador){
        for (Jugador aux: jugadores) {
            if(aux.equals(jugador)){
                return true;
            }
        }
        return false;
    }

    public void agregarJugadores(Jugador jugador){
        if(!buscarJugador(jugador)){
            jugadores.add(jugador);
        }
        else{
            jugadoresRepetidos.add(jugador);
        }
    }

    @Override
    public Jugador[] abrirSobre(int validos) {
        Sistema sistema = new Sistema();
        int i;
        int j;
        Jugador[] aux = new Jugador[validos];

        for(int a = 0; a < validos; a++){
            Random rand = new Random();
            i = rand.nextInt(0, 2);
            j = rand.nextInt(0, 4);
            aux[a] = Sistema.paises[i].getJugadores(j);
            if(!buscarJugador(Sistema.paises[i].getJugadores(j)))
                this.setContadorDeFiguritas(this.getContadorDeFiguritas() + 1);
            this.agregarJugadores(Sistema.paises[i].getJugadores(j));
        }
        return aux;
    }
}

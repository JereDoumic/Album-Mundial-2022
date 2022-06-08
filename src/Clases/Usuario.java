package Clases;

import com.google.gson.Gson;

import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Type;
import java.sql.Array;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class Usuario implements MetodosDeUsuario, Serializable{
    LinkedList<Jugador>jugadores = new LinkedList<>();
    LinkedList<Jugador>jugadoresRepetidos = new LinkedList<>();
    private String tipoDeUsuario;  //Basic, Silver o Gold
    public int contadorDeFiguritas;
    public boolean puedoAbrirSobre = true;
    public int[] jugadoresArchivo = new int[78];



    public int getContadorDeFiguritas() {
        return contadorDeFiguritas;
    }

    public void setContadorDeFiguritas(int contadorDeFiguritas) {
        this.contadorDeFiguritas = contadorDeFiguritas;
    }

    public LinkedList<Jugador> getJugadoresRepetidos() {
        return jugadoresRepetidos;
    }

    public void setJugadoresRepetidos(LinkedList<Jugador> jugadoresRepetidos) {
        this.jugadoresRepetidos = jugadoresRepetidos;
    }

    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(String tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public Usuario() {
    }

    public void guardarFiguritaEnArchivo(int[] arreglo){

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("usuario.json"); // podemos agregar datos
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutputStream);
            objectOutput.writeObject(jugadoresArchivo);

            objectOutput.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void leerArchivoDeFiguritas() {
        File file = new File("usuario.json");
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Gson gson = new Gson();
        int[] aux = gson.fromJson((Reader) bufferedReader, (Type) Integer.class);
        System.out.println(aux);
    }

    public boolean buscarJugadorEnArchivo(Jugador jugador){
        File file = new File("usuario.json");
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while (bufferedReader != null){
                Gson gson = new Gson();
                int aux = gson.fromJson(bufferedReader, Integer.class);
                if(jugador.getFiguritaNro() == aux)
                    return true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
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
        int i;
        int j;
        Jugador[] aux = new Jugador[validos];
        Sistema sistema = new Sistema();


        for(int a = 0; a < validos; a++) {
            Random rand = new Random();
            i = rand.nextInt(0, 5);
            j = rand.nextInt(0, 6);
            aux[a] = Sistema.paises[i].getJugadores(j);
            if (!buscarJugador(Sistema.paises[i].getJugadores(j)))
                this.setContadorDeFiguritas(this.getContadorDeFiguritas() + 1);
            this.agregarJugadores(Sistema.paises[i].getJugadores(j));
        }

        this.puedoAbrirSobre = false;
        //TimerUsuario.timerUsuario(this);
        return aux;
    }

    @Override
    public int hashCode() {
        return Objects.hash(jugadores, jugadoresRepetidos, tipoDeUsuario, contadorDeFiguritas);
    }
}

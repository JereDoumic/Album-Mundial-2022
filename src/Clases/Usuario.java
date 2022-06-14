package Clases;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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

public class Usuario extends Cuenta implements MetodosDeUsuario, Serializable{
    LinkedList<Jugador>jugadores = new LinkedList<>();
    LinkedList<Jugador>jugadoresRepetidos = new LinkedList<>();
    private String tipoDeUsuario;  //Basic, Silver o Gold
    public int contadorDeFiguritas;
    public boolean puedoAbrirSobre = true;
    public LinkedList<Integer> figuritasEnArchivo = new LinkedList<>();
    public LinkedList<Integer> figuritasEnArchivoRepetidas = new LinkedList<>();
    Gson gson = new Gson();
    private BufferedWriter bufferedWriter = null;
    private BufferedReader bufferedReader = null;
    private File file = new File(this.getUsuario() + ".json");
    private File fileRepetidas = new File(this.getUsuario() + "FiguritasRepetidas.json");

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

    public void crearArchivo() {
        if(!file.exists()){
           file = new File(this.getUsuario() + ".json");
        }
    }

    public void crearArchivoFiguritasRepetidas() {
        if(!fileRepetidas.exists()){
            fileRepetidas = new File(this.getUsuario() + "FiguritasRepetidas.json");
        }
    }

    public void guardarFiguritasEnArchivo(LinkedList<Integer> arreglo){

        if (!file.exists()) {
            crearArchivo();
        }

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            gson.toJson(arreglo, arreglo.getClass(), bufferedWriter);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void guardarFiguritasRepetidasEnArchivo(LinkedList<Integer> arreglo){

        if (!fileRepetidas.exists()) {
            crearArchivoFiguritasRepetidas();
        }

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(fileRepetidas));
            gson.toJson(arreglo, arreglo.getClass(), bufferedWriter);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public LinkedList<Integer> leerArchivoAArreglo() {

        LinkedList<Integer> figuritas = new LinkedList<>();
        File file = new File(this.getUsuario() + ".json");
        if (!file.exists()) {
            crearArchivo();
        }else{
            Type type = new TypeToken<LinkedList<Integer>>() {}.getType();
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    figuritas = gson.fromJson(bufferedReader, type);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        return figuritas;
    }

    public LinkedList<Integer> leerArchivoFiguritasRepetidasAArreglo() {

        LinkedList<Integer> figuritas = new LinkedList<>();
        File fileRepetidas = new File(this.getUsuario() + "FiguritasRepetidas.json");
        if (!fileRepetidas.exists()) {
            crearArchivo();
        }else{
            Type type = new TypeToken<LinkedList<Integer>>() {}.getType();
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(fileRepetidas));
                    figuritas = gson.fromJson(bufferedReader, type);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        return figuritas;
    }

    public int contarFiguritasEnElArchivo(){
        LinkedList<Integer> aux = leerArchivoAArreglo();
        return aux.size();
    }

    public boolean buscarFiguritaEnArchivo(Jugador jugador) {
        LinkedList<Integer> listaDeFiguritas;
        listaDeFiguritas = leerArchivoAArreglo();

        for (int p: listaDeFiguritas) {
            if(p == jugador.getFiguritaNro())
                return true;
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

        figuritasEnArchivo = leerArchivoAArreglo();
        figuritasEnArchivoRepetidas = leerArchivoFiguritasRepetidasAArreglo();

        for(int a = 0; a < validos; a++) {
            Random rand = new Random();
            i = rand.nextInt(0, 5);
            j = rand.nextInt(0, 6);
            aux[a] = Sistema.paises[i].getJugadores(j);
            if (!buscarFiguritaEnArchivo(Sistema.paises[i].getJugadores(j))) {
                this.setContadorDeFiguritas(this.getContadorDeFiguritas() + 1);
                this.figuritasEnArchivo.add(Sistema.paises[i].getJugadores(j).getFiguritaNro());
            } else {
                figuritasEnArchivoRepetidas.add(Sistema.paises[i].getJugadores(j).getFiguritaNro());
            }

            this.agregarJugadores(Sistema.paises[i].getJugadores(j));
        }

        guardarFiguritasEnArchivo(figuritasEnArchivo);
        if(figuritasEnArchivoRepetidas != null)
            guardarFiguritasRepetidasEnArchivo(figuritasEnArchivoRepetidas);

        this.puedoAbrirSobre = false;
        return aux;
    }

    @Override
    public int hashCode() {
        return Objects.hash(jugadores, jugadoresRepetidos, tipoDeUsuario, contadorDeFiguritas);
    }
}

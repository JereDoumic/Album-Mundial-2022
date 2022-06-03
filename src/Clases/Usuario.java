package Clases;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

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


    public Usuario registrarUs() {
        Scanner sc = new Scanner(System.in);
        Usuari usurioAux = new Usuari();
        System.out.println("nombre: ");
        sc.next(usurioAux.getNombre());
        System.out.println("apellido: ");
        sc.next(usurioAux.getApellido());
        System.out.println("mail: ");
        sc.next(usurioAux.email);
        System.out.println("paswerd: ");
        sc.next(usurioAux.password);
        if (!buscarUsuario(usurioAux)) {
            usuarios.add(usurioAux);
        } else {
            System.out.println("El usuario ya existe, inicia sesion ");
        }
        sc.close();
        return usurioAux;
    }

    public boolean buscarUsuario(Usuario us) {
        for (Usuario aux : usuarios) {
            if (aux.equals(us)) {
                return true;
            }
        }
        return false;
    }

    public boolean buscaUsReg(String mail, String password ){
        for ( Usuario usAux : usuarios) {
            if (usAux.email.compareTo(mail) == 0){
                if (usAux.password.compareTo(password) == 0){
                    return true;
                }
            }
        }
        return false;
    }

    public void iniciaSesionCliente() {
        Scanner sc = new Scanner(System.in);
        Usuario usurioAux = new Usuario();
        System.out.println("mail: ");
        sc.next(usurioAux.email);
        System.out.println("paswerd: ");
        sc.next(usurioAux.password);
        if (buscaUsReg(usurioAux.email, usurioAux.password)) {
            //continua con menu . . .
        } else {
            System.out.println("El usuario no existe, registrate ");
        }
    }
}

package Clases;

import java.util.Objects;

public class Jugador {
    private String nombre;
    private String apellido;
    private String pais;




    public Jugador(String nombre, String apellido, String pais) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
    }

    public Jugador(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return Objects.equals(nombre, jugador.nombre) && Objects.equals(apellido, jugador.apellido) &&  Objects.equals(pais, jugador.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, pais);
    }


    @Override
    public String toString() {
        return "\nJugador{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}

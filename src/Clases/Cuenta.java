package Clases;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;

public class Cuenta{
    private String nombre;
    private String apellido;
    private String dni;
    private String usuario;
    private String password;
    private String email;


    private int tipo = 0; /// admin = 1

    public Cuenta(String nombre, String apellido, String dni, String usuario, String password, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.usuario = usuario;
        this.password = password;
        this.email = email;

    }

    public Cuenta(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public Cuenta() {

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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return "Usuario: \n" +
                "Nombre: " + nombre +
                " y Apellido: " + apellido + "\n" +
                "Dni: " + dni + "\n" +
                "Usuario: " + usuario +
                " | Password: " + password + "\n" +
                "Email: " + email + "\n" +
                "Tipo: " + tipo + "\n" +
                "********************************\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuenta cuenta = (Cuenta) o;
        return Objects.equals(dni, cuenta.dni) && Objects.equals(usuario, cuenta.usuario) && Objects.equals(password, cuenta.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, usuario, password);
    }
}
package Clases;

import java.util.Comparator;

public class Cuenta implements Comparable{
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
        return "Cuenta{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", tipo=" + tipo +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        int result = 1;
        Cuenta nuevaCuenta = (Cuenta) o;
        if (this.usuario == ((Cuenta) o).usuario){
            result=0;
        }
        return result;
    }


}

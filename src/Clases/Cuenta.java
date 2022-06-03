package Clases;

import java.util.Comparator;

public class Cuenta extends Persona implements Comparable{
    private String usuario;
    private String password;
    private String email;

    private int tipo = 0; /// admin = 1

    public Cuenta(String usuario, String password, String email, String name, String lastName, String dni) {
        super();
        this.usuario = usuario;
        this.password = password;
        this.email = email;
        this.setNombre(name);
        this.setApellido(lastName);
        this.setDni(dni);
    }

    public Cuenta() {

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
                "usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
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

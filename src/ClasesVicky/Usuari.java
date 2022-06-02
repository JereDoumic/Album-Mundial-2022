package ClasesVicky;

import Clases.Persona;

import java.util.LinkedList;
import java.util.Scanner;

public class Usuari extends Persona {
    private String email;
    private String password;
    private String tipoUsuario;
    LinkedList<Usuari> usuarios = new LinkedList<>();

    public Usuari(String nombre, String apellido, String email, String paswerd, String tipoUsuario) {
        super(nombre, apellido);
        this.email = email;
        this.password = paswerd;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuari() {
    }

    public Usuari registrarUs() {
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

    public boolean buscarUsuario(Usuari us) {
        for (Usuari aux : usuarios) {
            if (aux.equals(us)) {
                return true;
            }
        }
        return false;
    }

    public boolean buscaUsReg(String mail, String password ){
        for ( Usuari usAux : usuarios) {
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
        Usuari usurioAux = new Usuari();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

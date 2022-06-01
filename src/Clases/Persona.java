package Clases;

abstract class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private int idPersona;
    private static int idGlobal=0;

    public Persona() {
        this.idPersona = generarId() ;
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

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public static int getIdGlobal() {
        return idGlobal;
    }

    public static void setIdGlobal(int idGlobal) {
        Persona.idGlobal = idGlobal;
    }

    public int generarId(){return ++idGlobal;}
}

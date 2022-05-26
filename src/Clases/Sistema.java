package Clases;

public final class Sistema {
    public Pais ARGENTINA = new Pais();
    public Pais URUGUAY = new Pais();
    public static Pais[] paises = new Pais[32];

    //regionJugadoresArgentina
    public static Jugador Messi = new Jugador("Lionel Andres", "Messi", "Argentina");
    public static Jugador DePaul = new Jugador("Rodrigo", "DePaul", "Argentina");
    public static Jugador Paredes = new Jugador("Leandro", "Paredes", "Argentina");
    //endregion

    //regionJugadoresUruguay
    public static Jugador Suarez = new Jugador("Luis", "Suarez", "Uruguay");
    public static Jugador Cavani = new Jugador("Edinson", "Cavani", "Uruguay");
    public static Jugador Muslera = new Jugador("Fernando", "Muslera",  "Uruguay");
    //enregion

    public Sistema() {
        cargarJugadoresArgentina();
        cargarJugadoresUruguay();
        cargarArregloDePaises();
    }

    public void cargarArregloDePaises(){
        paises[0] = ARGENTINA;
        paises[1] = URUGUAY;
    }



    public void cargarJugadoresArgentina(){
        ARGENTINA.setJugadores(Messi);
        ARGENTINA.setJugadores(DePaul);
        ARGENTINA.setJugadores(Paredes);
    }

    public void cargarJugadoresUruguay(){
        URUGUAY.setJugadores(Suarez);
        URUGUAY.setJugadores(Cavani);
        URUGUAY.setJugadores(Muslera);
    }



}

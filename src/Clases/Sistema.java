package Clases;

public final class Sistema {
    public Pais ARGENTINA = new Pais();
    public Pais URUGUAY = new Pais();
    public static Pais[] paises = new Pais[32];


    //regionJugadoresArgentina
    public static Jugador EscudoArgentina = new Jugador("EscudoArgentina", "EscudoArgentina", "Argentina");
    public static Jugador Messi = new Jugador("Lionel Andres", "Messi", "Argentina");
    public static Jugador DePaul = new Jugador("Rodrigo", "DePaul", "Argentina");
    public static Jugador Paredes = new Jugador("Leandro", "Paredes", "Argentina");
    public static Jugador Otamendi = new Jugador("Nicolas", "Otamendi", "Argentina");
    public static Jugador DiMaria = new Jugador("Angel", "DiMaria", "Argentina");
    //endregion

    //regionJugadoresUruguay
    public static Jugador EscudoUruguay = new Jugador("EscudoUruguay", "EscudoUruguay", "Uruguay");
    public static Jugador Suarez = new Jugador("Luis", "Suarez", "Uruguay");
    public static Jugador Cavani = new Jugador("Edinson", "Cavani", "Uruguay");
    public static Jugador Muslera = new Jugador("Fernando", "Muslera",  "Uruguay");
    public static Jugador Gimenez = new Jugador("Jose", "Gimenez",  "Uruguay");
    public static Jugador Godin = new Jugador("Diego", "Godin",  "Uruguay");
    //endregion


    public static final String BASIC = "Basic";
    public static final String SILVER = "Silver";
    public static final String GOLD = "Gold";


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
        ARGENTINA.setJugadores(Otamendi);
        ARGENTINA.setJugadores(DiMaria);
        ARGENTINA.setJugadores(EscudoArgentina);
    }

    public void cargarJugadoresUruguay(){
        URUGUAY.setJugadores(Suarez);
        URUGUAY.setJugadores(Cavani);
        URUGUAY.setJugadores(Muslera);
        URUGUAY.setJugadores(Gimenez);
        URUGUAY.setJugadores(Godin);
        URUGUAY.setJugadores(EscudoUruguay);
    }



}

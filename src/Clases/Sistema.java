package Clases;

public final class Sistema {
    public Pais ARGENTINA = new Pais();
    public Pais URUGUAY = new Pais();
    public Pais ESPANIA = new Pais();
    public Pais FRANCIA = new Pais();
    public Pais MEXICO = new Pais();
    public static Pais[] paises = new Pais[32];
    public Jugador[] jugadores = {EscudoArgentina, Messi, DePaul, Acunia, Otamendi, DiMaria, EscudoUruguay, Suarez, Cavani, Muslera, Gimenez, Godin, EscudoEspania, DeGea, Carvajal, Morata, Busquets, Alcantara, EscudoFrancia, Lloris, Mbappe, Kante, Pogba, Varane, EscudoMexico, Guardado, Herrera, Lozano, Moreno, Ochoa};


    //regionJugadoresArgentina
    public static Jugador EscudoArgentina = new Jugador("EscudoArgentina", "EscudoArgentina", "Argentina", 1);
    public static Jugador Messi = new Jugador("Lionel Andres", "Messi", "Argentina", 2);
    public static Jugador DePaul = new Jugador("Rodrigo", "DePaul", "Argentina", 3);
    public static Jugador Acunia = new Jugador("Marcos", "Acunia", "Argentina", 4);
    public static Jugador Otamendi = new Jugador("Nicolas", "Otamendi", "Argentina", 5);
    public static Jugador DiMaria = new Jugador("Angel", "DiMaria", "Argentina",  6);
    //endregion

    //regionJugadoresUruguay
    public static Jugador EscudoUruguay = new Jugador("EscudoUruguay", "EscudoUruguay", "Uruguay", 24);
    public static Jugador Suarez = new Jugador("Luis", "Suarez", "Uruguay", 25);
    public static Jugador Cavani = new Jugador("Edinson", "Cavani", "Uruguay", 26);
    public static Jugador Muslera = new Jugador("Fernando", "Muslera",  "Uruguay", 27);
    public static Jugador Gimenez = new Jugador("Jose", "Gimenez",  "Uruguay", 28);
    public static Jugador Godin = new Jugador("Diego", "Godin",  "Uruguay",29);
    //endregion

    //regionJugadoresEspaña
    public static Jugador EscudoEspania = new Jugador("EscudoEsp", "EscudoEsp", "España", 47);
    public static Jugador DeGea = new Jugador("David", "DeGea", "España", 48);
    public static Jugador Carvajal = new Jugador("Daniel", "Caravajal", "España", 49);
    public static Jugador Morata = new Jugador("Alvaro", "Morata",  "España", 50);
    public static Jugador Busquets = new Jugador("Sergio", "Busquets",  "España", 51);
    public static Jugador Alcantara = new Jugador("Thiago", "Alcantara",  "España", 52);
    //endregion

    //regionJugadoresFrancia
    public static Jugador EscudoFrancia = new Jugador("EscudoFr", "EscudoFr", "Francia", 70);
    public static Jugador Lloris = new Jugador("David", "Lloris", "Francia", 71);
    public static Jugador Mbappe = new Jugador("Kylian", "Mbappe", "Francia", 72);
    public static Jugador Kante = new Jugador("Ngolo", "Kante",  "Francia", 73);
    public static Jugador Pogba = new Jugador("Sergio", "Pogba",  "Francia", 74);
    public static Jugador Varane = new Jugador("Raphael", "Varane",  "Francia", 75);
    //endregion

    //regionJugadoresMexico
    public static Jugador EscudoMexico = new Jugador("EscudoArgentina", "EscudoArgentina", "Mexico", 93);
    public static Jugador Guardado = new Jugador("Lionel Andres", "Guardado", "Mexico", 94);
    public static Jugador Herrera = new Jugador("Rodrigo", "Herrera", "Mexico", 95);
    public static Jugador Lozano = new Jugador("Marcos", "Lozano", "Mexico", 96);
    public static Jugador Moreno = new Jugador("Nicolas", "Moreno", "Mexico", 97);
    public static Jugador Ochoa = new Jugador("Angel", "Ochoa", "Mexico", 98);
    //endregion


    public static final String BASIC = "Basic";
    public static final String SILVER = "Silver";
    public static final String GOLD = "Gold";


    public Sistema() {
        cargarJugadoresArgentina();
        cargarJugadoresUruguay();
        cargarJugadoresEspania();
        cargarJugadoresFrancia();
        cargarJugadoresMexico();
        cargarArregloDePaises();
    }

    public void cargarArregloDePaises(){
        paises[0] = ARGENTINA;
        paises[1] = URUGUAY;
        paises[2] = ESPANIA;
        paises[3] = FRANCIA;
        paises[4] = MEXICO;
    }


    public void cargarJugadoresArgentina(){
        ARGENTINA.setJugadores(Messi);
        ARGENTINA.setJugadores(DePaul);
        ARGENTINA.setJugadores(Acunia);
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

    public void cargarJugadoresEspania(){
        ESPANIA.setJugadores(EscudoEspania);
        ESPANIA.setJugadores(DeGea);
        ESPANIA.setJugadores(Alcantara);
        ESPANIA.setJugadores(Carvajal);
        ESPANIA.setJugadores(Busquets);
        ESPANIA.setJugadores(Morata);
    }

    public void cargarJugadoresFrancia(){
        FRANCIA.setJugadores(EscudoFrancia);
        FRANCIA.setJugadores(Lloris);
        FRANCIA.setJugadores(Mbappe);
        FRANCIA.setJugadores(Pogba);
        FRANCIA.setJugadores(Kante);
        FRANCIA.setJugadores(Varane);
    }

    public void cargarJugadoresMexico(){
        MEXICO.setJugadores(EscudoMexico);
        MEXICO.setJugadores(Ochoa);
        MEXICO.setJugadores(Herrera);
        MEXICO.setJugadores(Lozano);
        MEXICO.setJugadores(Moreno);
        MEXICO.setJugadores(Guardado);
    }

    public String retornarRutaDeJugadorPorNumeroDeFigurita(int numeroDeFigurita){
        String rutaJugador = "no encontrado";
        for (Jugador aux: jugadores) {
            if(aux.getFiguritaNro() == numeroDeFigurita)
                rutaJugador = "Imagenes\\" + aux.getPais() + "\\" + aux.getApellido() + "2.jpg";
        }
        return rutaJugador;
    }
}

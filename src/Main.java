import Clases.*;
import Paneles.Administrador;
import Paneles.Login;
import Paneles.VentanaPrincipal;
import Paneles.VerPefil;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        //Reproductor.reproducirCancion();
        Db_cuentas db = new Db_cuentas();
        db.Db_status();
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
    }
}

import Clases.*;
import Paneles.Login;
import Paneles.VentanaPrincipal;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Reproductor.reproducirCancion();
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
    }
}

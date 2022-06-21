package Clases;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Reproductor{


    private static AudioClip ac;

     public static void reproducirCancion() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
         Clip sonido = AudioSystem.getClip();
         sonido.open(AudioSystem.getAudioInputStream(new File("Musica\\Hayya.wav")));
         sonido.start();
     }
}

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

public class Reproductor extends JFrame{


    private static AudioClip ac;

     public static void reproducirCancion() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
         Clip sonido = AudioSystem.getClip();
         sonido.open(AudioSystem.getAudioInputStream(new File("Musica\\Hayya.wav")));
         sonido.start();
     }

    public void reproducir() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        this.setTitle("QATAR 2022");
        setSize(1600, 900);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setOpaque(false);

        setLayout(new FlowLayout());
        add(content);
        ((JPanel) getContentPane()).setOpaque(false);

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        reproducirCancion();

    }
}

package Paneles;

import Clases.Jugador;
import Clases.Menuu;
import Clases.Usuario;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.Period;

public class FiguritasRepetidas {
    private JPanel figuritasRepetidasPanel;
    private JButton volverButton;
    private JTextArea FiguritasRepetidas;
    private Usuario usuario;

    public FiguritasRepetidas(Usuario usuario) {
        this.usuario = usuario;
        fondo();
    }

    public JPanel getFiguritasRepetidasPanel() {
        return figuritasRepetidasPanel;
    }

    public void actionVolver(JFrame f, VerPefil perfil){
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(perfil.getVerPefilPanel());
                f.setVisible(true);
            }
        });
    }

    public void fondo(){
        try {
            Menuu.fondoPanel fondo = new Menuu.fondoPanel(ImageIO.read(new File("Imagenes\\Menu.jpg")));
            getFiguritasRepetidasPanel().setBorder(fondo);
        } catch (
                IOException ex) {
            JOptionPane.showMessageDialog(getFiguritasRepetidasPanel(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cargarText(){
        FiguritasRepetidas.setText(usuario.getJugadoresRepetidos().toString());
    }
}

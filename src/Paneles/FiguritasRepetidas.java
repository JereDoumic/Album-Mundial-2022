package Paneles;

import Clases.Jugador;
import Clases.Menuu;
import Clases.Sistema;
import Clases.Usuario;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Period;
import java.util.LinkedList;

public class FiguritasRepetidas {
    private JPanel figuritasRepetidasPanel;
    private JButton volverButton;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextArea FiguritasRepetidas;
    private Usuario usuario;
    private JLabel[] labels = new JLabel[25];

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

    public void cargarJlabels(){
        LinkedList<Integer> aux = usuario.leerArchivoFiguritasRepetidasAArreglo();
        Sistema sistema = new Sistema();
        int i = 0;
        for (int numero: aux) {
            ImageIcon imagen = new ImageIcon(sistema.retornarRutaDeJugadorPorNumeroDeFigurita(numero));
            labels[i] = new JLabel();
            labels[i].setVisible(true);
            labels[i].setIcon(imagen);
            i++;
        }
    }
}

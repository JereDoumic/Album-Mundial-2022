package Paneles;

import Clases.Menuu;
import Clases.Sistema;
import Clases.Usuario;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class FiguritasRepetidas {
    private JPanel figuritasRepetidasPanel;
    private JButton volverButton;
    //regionLabels
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JLabel label16;
    private JLabel label17;
    private JLabel label18;
    private JLabel label19;
    private JLabel label20;
    private JLabel label21;
    private JLabel label22;
    //endregion
    private JTextArea FiguritasRepetidas;
    private Usuario usuario;
    private JLabel[] labels = {label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13, label14, label15, label16, label17, label18, label19, label20, label21, label22};

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
        Collections.sort(aux);
        Sistema sistema = new Sistema();
        int i = 0;
        for (int numero: aux) {
            if(i < 22){
                ImageIcon imagen = new ImageIcon(sistema.retornarRutaDeJugadorPorNumeroDeFigurita(numero));
                labels[i].setVisible(true);
                labels[i].setIcon(imagen);
                i++;
            }
        }
        label9.setOpaque(false);
        label9.setVisible(false);
        label19.setOpaque(false);
        label19.setVisible(false);
    }
}

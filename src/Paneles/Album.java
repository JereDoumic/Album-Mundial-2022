package Paneles;

import Clases.Menu;
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

public class Album extends Component {
    private JPanel contentPanelAlbum;
    private JPanel panelAlbum;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private Usuario usuario;

    public Album(Usuario usuario) {
        fondo();
        this.usuario = usuario;
    }

    public JPanel getContentPanelAlbum() {
        return contentPanelAlbum;
    }

    public void setContentPanelAlbum(JPanel contentPanelAlbum) {
        this.contentPanelAlbum = contentPanelAlbum;
    }

    public JPanel getPanelAlbum() {
        return panelAlbum;
    }

    public void setPanelAlbum(JPanel panelAlbum) {
        this.panelAlbum = panelAlbum;
    }

    public void fondo() {
        try {
            Menuu.fondoPanel fondo = new Menuu.fondoPanel(ImageIO.read(new File("Imagenes\\probando.jpg")));
            getPanelAlbum().setBorder(fondo);
        } catch (
                IOException ex) {
            JOptionPane.showMessageDialog(getContentPanelAlbum(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void completarArgentina(){
        ImageIcon imagen1 = new ImageIcon("Imagenes\\Messi.jpg");
        label1.setIcon(imagen1);
        label1.setVisible(usuario.buscarJugador(Sistema.Messi));

        ImageIcon imagen2 = new ImageIcon("Imagenes\\DePaul.jpg");
        label2.setIcon(imagen2);
        label2.setVisible(usuario.buscarJugador(Sistema.DePaul));

        ImageIcon imagen3 = new ImageIcon("Imagenes\\Paredes.jpg");
        label3.setIcon(imagen3);
        label3.setVisible(usuario.buscarJugador(Sistema.Paredes));
        //label1.setVisible(this.usuario.buscarJugador(Sistema.Messi));

        /*ImageIcon imagen2 = new ImageIcon("Imagenes\\DePaul2.jpg");
        JLabel label2 = new JLabel(imagen2);
        getPanelAlbum().add(label2, new Integer(Integer.MIN_VALUE));
        label2.setBounds(370, 295, imagen2.getIconWidth(), imagen2.getIconHeight());
        label2.setSize(new Dimension(150, 200));
        //label2.setVisible(this.usuario.buscarJugador(Sistema.DePaul));

        ImageIcon imagen3 = new ImageIcon("Imagenes\\Paredes.jpg");
        JLabel label3 = new JLabel(imagen3);
        getPanelAlbum().add(label3, new Integer(Integer.MIN_VALUE));
        label3.setBounds(570, 295, imagen3.getIconWidth(), imagen3.getIconHeight());
        label3.setSize(new Dimension(150, 200));*/
        //label3.setVisible(this.usuario.buscarJugador(Sistema.Paredes));
    }



    public void uruguay(){
        try {
            Menu.fondoPanel fondo = new Menu.fondoPanel(ImageIO.read(new File("Imagenes\\probandoUruguay.jpg")));
            getContentPanelAlbum().setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


        ImageIcon imagen1 = new ImageIcon("Imagenes\\Muslera.jpg");
        JLabel label1 = new JLabel(imagen1);
        getContentPanelAlbum().add(label1, new Integer(Integer.MIN_VALUE));
        label1.setBounds(70, 320, imagen1.getIconWidth(), imagen1.getIconHeight());
        label1.setSize(new Dimension(180, 230));
        label1.setVisible(this.usuario.buscarJugador(Sistema.Muslera));

        ImageIcon imagen2 = new ImageIcon("Imagenes\\Suarez.jpg");
        JLabel label2 = new JLabel(imagen2);
        getContentPanelAlbum().add(label2, new Integer(Integer.MIN_VALUE));
        label2.setBounds(300, 320, imagen2.getIconWidth(), imagen2.getIconHeight());
        label2.setSize(new Dimension(180, 230));
        label2.setVisible(this.usuario.buscarJugador(Sistema.Suarez));

        ImageIcon imagen3 = new ImageIcon("Imagenes\\Cavani.jpg");
        JLabel label3 = new JLabel(imagen3);
        getContentPanelAlbum().add(label3, new Integer(Integer.MIN_VALUE));
        label3.setBounds(530, 320, imagen3.getIconWidth(), imagen3.getIconHeight());
        label3.setSize(new Dimension(180, 230));
        label3.setVisible(this.usuario.buscarJugador(Sistema.Cavani));



        JButton botonVolver = new JButton();
        botonVolver.setText("VOLVER");
        botonVolver.setEnabled(true);
        botonVolver.setBounds(10, 750, 100, 100);
        getContentPanelAlbum().add(botonVolver, new Integer(Integer.MIN_VALUE));

        JButton botonSiguiente = new JButton();
        botonSiguiente.setText("SIGUIENTE");
        botonSiguiente.setEnabled(true);
        botonSiguiente.setBounds(1470, 750, 100, 100);
        getContentPanelAlbum().add(botonSiguiente, new Integer(Integer.MIN_VALUE));

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setVisible(false);
                label2.setVisible(false);
                label3.setVisible(false);
                botonVolver.setVisible(false);
                botonSiguiente.setVisible(false);
                //menu();
            }
        });

        botonSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setVisible(false);
                label2.setVisible(false);
                label3.setVisible(false);
                botonVolver.setVisible(false);
                botonSiguiente.setVisible(false);
                //argentina();
            }
        });
    }


}

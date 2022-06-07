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
import java.util.Random;

public class AbrirSobre {
    public JPanel contentPanelAbrirSobre;
    public JPanel panelAbrirSobre;
    public JButton volverButton;
    public JButton abrirButton;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label5;
    private JLabel label4;
    private JLabel label6;
    private JPanel panel1;
    private Usuario usuario;

    public AbrirSobre(Usuario usuario) {
        fondo();
        this.usuario = usuario;
    }

    //regionGetersAndSetters
    public JPanel getContentPanelAbrirSobre() {
        return contentPanelAbrirSobre;
    }

    public void setContentPanelAbrirSobre(JPanel contentPanelAbrirSobre) {
        this.contentPanelAbrirSobre = contentPanelAbrirSobre;
    }

    public JPanel getPanelAbrirSobre() {
        return panelAbrirSobre;
    }

    public void setPanelAbrirSobre(JPanel panelAbrirSobre) {
        this.panelAbrirSobre = panelAbrirSobre;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }
    //endregion

    //regionBotones
    public void actionVolverAMenu(JFrame f, Menuu menu){
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(menu.getContentPanelMenu());
                f.setVisible(true);
            }
        });
    }

    public void actionAbrir(JFrame f, AbrirSobre sobre){
        abrirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(usuario.getContadorDeFiguritas() < 20){
                    Jugador[] aux = usuario.abrirSobre(4);

                    ImageIcon imagen1 = new ImageIcon("Imagenes\\" + aux[0].getPais() + "\\" + aux[0].getApellido() + "2.jpg");
                    label1.setIcon(imagen1);

                    ImageIcon imagen2 = new ImageIcon("Imagenes\\" +  aux[1].getPais() + "\\" + aux[1].getApellido() + "2.jpg");
                    label2.setIcon(imagen2);

                    ImageIcon imagen3 = new ImageIcon("Imagenes\\" + aux[2].getPais() + "\\" + aux[2].getApellido() + "2.jpg");
                    label3.setIcon(imagen3);

                    ImageIcon imagen4 = new ImageIcon("Imagenes\\" +  aux[3].getPais() + "\\" + aux[3].getApellido() + "2.jpg");
                    label4.setIcon(imagen4);
                }
                if(usuario.getContadorDeFiguritas() >= 20 && usuario.getContadorDeFiguritas() < 40){
                    Jugador[] aux = usuario.abrirSobre(5);

                    ImageIcon imagen1 = new ImageIcon("Imagenes\\" + aux[0].getPais() + "\\" + aux[0].getApellido() + "2.jpg");
                    label1.setIcon(imagen1);

                    ImageIcon imagen2 = new ImageIcon("Imagenes\\" +  aux[1].getPais() + "\\" + aux[1].getApellido() + "2.jpg");
                    label2.setIcon(imagen2);

                    ImageIcon imagen3 = new ImageIcon("Imagenes\\" + aux[2].getPais() + "\\" + aux[2].getApellido() + "2.jpg");
                    label3.setIcon(imagen3);

                    ImageIcon imagen4 = new ImageIcon("Imagenes\\" +  aux[3].getPais() + "\\" + aux[3].getApellido() + "2.jpg");
                    label4.setIcon(imagen4);

                    ImageIcon imagen5 = new ImageIcon("Imagenes\\" +  aux[4].getPais() + "\\" + aux[4].getApellido() + "2.jpg");
                    label5.setIcon(imagen5);
                }
                if(usuario.getContadorDeFiguritas() >= 40){
                    Jugador[] aux = usuario.abrirSobre(6);

                    ImageIcon imagen1 = new ImageIcon("Imagenes\\" + aux[0].getPais() + "\\" + aux[0].getApellido() + "2.jpg");
                    label1.setIcon(imagen1);

                    ImageIcon imagen2 = new ImageIcon("Imagenes\\" +  aux[1].getPais() + "\\" + aux[1].getApellido() + "2.jpg");
                    label2.setIcon(imagen2);

                    ImageIcon imagen3 = new ImageIcon("Imagenes\\" + aux[2].getPais() + "\\" + aux[2].getApellido() + "2.jpg");
                    label3.setIcon(imagen3);

                    ImageIcon imagen4 = new ImageIcon("Imagenes\\" +  aux[3].getPais() + "\\" + aux[3].getApellido() + "2.jpg");
                    label4.setIcon(imagen4);

                    ImageIcon imagen5 = new ImageIcon("Imagenes\\" +  aux[4].getPais() + "\\" + aux[4].getApellido() + "2.jpg");
                    label5.setIcon(imagen5);

                    ImageIcon imagen6 = new ImageIcon("Imagenes\\" +  aux[5].getPais() + "\\" + aux[5].getApellido() + "2.jpg");
                    label6.setIcon(imagen5);
                }

            }
        });
    }
    //endregion


    public void fondo(){
        try {
            Menuu.fondoPanel fondo = new Menuu.fondoPanel(ImageIO.read(new File("Imagenes\\Menu.jpg")));
            getContentPanelAbrirSobre().setBorder(fondo);
        } catch (
                IOException ex) {
            JOptionPane.showMessageDialog(getContentPanelAbrirSobre(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}

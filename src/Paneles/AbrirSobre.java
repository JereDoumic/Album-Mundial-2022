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
    private JLabel label4;
    private JLabel label5;
    private JPanel panel1;
    private Usuario usuario;

    public AbrirSobre(Usuario usuario) {
        fondo();
        this.usuario = usuario;
        //usuario.abrirSobre(this.getPanelAbrirSobre());
    }

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

    public void abrirSobreDeFiguritas(){

    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

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
                Jugador[] aux = usuario.abrirSobre();

                ImageIcon imagen1 = new ImageIcon("Imagenes\\" + aux[0].getApellido() + ".jpg");
                label1.setBounds(1500, 10, imagen1.getIconWidth(), imagen1.getIconHeight());
                label1.setIcon(imagen1);



                /*ImageIcon imagen2 = new ImageIcon("Imagenes\\" + aux[1].getApellido() + ".jpg");
                label2.setIcon(imagen2);
                /*label2.setBounds(590, 10, imagen2.getIconWidth(), imagen2.getIconHeight());
                label2.setSize(new Dimension(400, 400));

                ImageIcon imagen3 = new ImageIcon("Imagenes\\" + aux[3].getApellido() + ".jpg");
                label3.setIcon(imagen3);
                label3.setBounds(250, 450, imagen3.getIconWidth(), imagen3.getIconHeight());
                label3.setSize(new Dimension(400, 400));

                ImageIcon imagen4 = new ImageIcon("Imagenes\\" + aux[4].getApellido() + ".jpg");
                label4.setIcon(imagen4);
                label4.setBounds(750, 450, imagen4.getIconWidth(), imagen4.getIconHeight());
                label4.setSize(new Dimension(400, 400));*/
            }
        });
    }


    public void fondo(){
        try {
            Menuu.fondoPanel fondo = new Menuu.fondoPanel(ImageIO.read(new File("Imagenes\\Menu.jpg")));
            getContentPanelAbrirSobre().setBorder(fondo);
        } catch (
                IOException ex) {
            JOptionPane.showMessageDialog(getContentPanelAbrirSobre(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

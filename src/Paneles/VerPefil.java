package Paneles;

import Clases.Menuu;
import Clases.Usuario;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class VerPefil {
    private JPanel VerPefilPanel;
    private JTextField figuritasEnonctradasTextField;
    private JButton botonVolver;
    private JButton verFiguritasRepetidasButton;
    private Usuario usuario;

    public VerPefil(Usuario usuario) {
        this.usuario = usuario;
        fondo();
    }

    public JPanel getVerPefilPanel() {
        return VerPefilPanel;
    }

    public void fondo(){
        try {
            Menuu.fondoPanel fondo = new Menuu.fondoPanel(ImageIO.read(new File("Imagenes\\Menu.jpg")));
            getVerPefilPanel().setBorder(fondo);
        } catch (
                IOException ex) {
            JOptionPane.showMessageDialog(getVerPefilPanel(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public void cargarText(){

        figuritasEnonctradasTextField.setText("Figuritas encontradas: " + usuario.getContadorDeFiguritas() + "/178");
    }

    public void actionVolver(JFrame f, Menuu menu){
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(menu.getContentPanelMenu());
                f.setVisible(true);
            }
        });
    }

    public void actionVerFiguritasRepetidas(JFrame f, FiguritasRepetidas figuritasRepetidas){
        verFiguritasRepetidasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(figuritasRepetidas.getFiguritasRepetidasPanel());
                figuritasRepetidas.cargarText();
                f.setVisible(true);
            }
        });
    }
}

package Paneles;

import Clases.Cuenta;
import Clases.ManejoArchivos;
import Clases.Menuu;
import Clases.Usuario;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class    VerPefil {
    private JPanel VerPefilPanel;
    private JTextArea figuritasEnonctradasTextField;
    private JButton botonVolver;
    private JButton verFiguritasRepetidasButton;
    private JButton buttonCambiarPassword;
    private JTextField textField1;
    private JButton botonConfirmar;
    private JTextField ingreseSuNuevaContraseñaTextField;
    private Usuario usuario;

    public VerPefil() {
    }

    public VerPefil(Usuario usuario) {
        this.usuario = usuario;
        fondo();
        actionCambiarPassword();
        actionConfirmar();
        botonConfirmar.setVisible(false);
        textField1.setVisible(false);
        ingreseSuNuevaContraseñaTextField.setVisible(false);
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
                figuritasEnonctradasTextField.setText("Usuario: " + usuario.getUsuario() +
                "\nRango de cuenta: " + usuario.retornarTipoDeCuenta()  +
                "\nFiguritas encontradas: " + usuario.contarFiguritasEnElArchivo() + "/178");

    }

    public void actionVolver(JFrame f, Menuu menu){
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(menu.getContentPanelMenu());
                buttonCambiarPassword.setVisible(true);
                verFiguritasRepetidasButton.setVisible(true);
                figuritasEnonctradasTextField.setVisible(true);
                f.setVisible(true);

            }
        });
    }

    public void actionCambiarPassword(){
        buttonCambiarPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                buttonCambiarPassword.setVisible(false);
                verFiguritasRepetidasButton.setVisible(false);
                figuritasEnonctradasTextField.setVisible(false);
                botonConfirmar.setVisible(true);
                textField1.setVisible(true);
                ingreseSuNuevaContraseñaTextField.setVisible(true);
            }
        });
    }

    public void actionConfirmar(){
        botonConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarContrasenia(usuario.getUsuario());
                Cartel cartel = new Cartel("Password cambiado con éxito");
                textField1.setText("");
                ingreseSuNuevaContraseñaTextField.setVisible(false);
                textField1.setVisible(false);
            }
        });
    }

    public void cambiarContrasenia(String usuario) {
        ManejoArchivos manejoArchivos = new ManejoArchivos();
        LinkedList<Cuenta> listCuentas = new LinkedList<>();
        listCuentas = manejoArchivos.leerArchivosAlista();

        for (Object p : listCuentas) {
            if (p instanceof Cuenta) {
                if (usuario.compareTo(((Cuenta) p).getUsuario()) == 0) {
                    ((Cuenta) p).setPassword(textField1.getText());
                }
            }
        }

        manejoArchivos.cargarListaDeCuentasAarchivo(listCuentas);
    }

    public void actionVerFiguritasRepetidas(JFrame f, FiguritasRepetidas figuritasRepetidas){
        verFiguritasRepetidasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(figuritasRepetidas.getFiguritasRepetidasPanel());
                f.setVisible(true);
                figuritasRepetidas.cargarJlabels();
            }
        });
    }

}

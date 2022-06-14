package Paneles;

import Clases.*;
import com.google.gson.Gson;
import com.google.gson.stream.MalformedJsonException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Login {
    private JPanel contenPanelLogin;
    private JTextField textField1;
    private JButton irButton;
    private JPasswordField passwordField1;
    private JButton iniciarSesionButton;
    private JPanel panelLogin;


    private ManejoArchivos mg = new ManejoArchivos();

    public Login() {
        textField1.setText("");
        passwordField1.setText("");
        Thread hilo = new Thread(this::run);
        fondoPanel();
        fondoBotones(iniciarSesionButton,"Imagenes\\botonInicSesion.png");
        fondoBotones(irButton,"Imagenes\\botonRegistrarse.png");
        hilo.start();
    }

    public void run() {
        try {
            while (true) {
                if (textField1.getText().isEmpty() || passwordField1.getText().isEmpty()) {
                    iniciarSesionButton.setEnabled(false);
                }else {
                    iniciarSesionButton.setEnabled(true);
                }
            }
        }catch (Exception io){
            System.out.println(io);
        }
    }


    public void actionIrButton(JFrame f, Registro rg) {
        irButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setTitle("Registro");
                f.setContentPane(rg.getContenPanelRegistro());
                f.setVisible(true);
            }
        });
    }

    public void actionIrAMenuButton(JFrame f, Menuu menu) {
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cuenta c = new Cuenta();
                c = buscarCuentaPorUsuario(textField1.getText());

                if (mg.buscarCuenta(c) && c.getTipo() == 0) {
                    f.setTitle("Registro");
                    f.setContentPane(menu.getPanel1());
                    f.setVisible(false);

                    mg.archivoTemporal(c);
                    Usuario usu = new Usuario();
                    usu.setUsuario(c.getUsuario());

                    InicProgram ip = new InicProgram(usu);

                    textField1.setText("");
                    passwordField1.setText("");

                } else if (c.getTipo() == 1) {
                    f.setTitle("Administrador");
                    f.setContentPane(menu.getPanel1());
                    f.setVisible(false);
                    Administrador administrador = new Administrador();
                }
                else {

                    Cartel car = new Cartel("Usuario no Registrado");

                }

            }
        });
    }


    public Cuenta buscarCuentaPorUsuario(String usuario) {
        ManejoArchivos manejoArchivos = new ManejoArchivos();
        LinkedList<Cuenta> listCuentas = new LinkedList<>();
        listCuentas = manejoArchivos.leerArchivosAlista();

        Cuenta aux = new Cuenta();

        for (Cuenta cuenta: listCuentas) {
            if (cuenta instanceof Cuenta){
                if (usuario.compareTo(((Cuenta) cuenta).getUsuario()) == 0){
                    aux = cuenta;
                }
            }
        }
        return aux;
    }

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }

    public void setPasswordField1(JPasswordField passwordField1) {
        this.passwordField1 = passwordField1;
    }

    public JPanel getContenPanelLogin() {
        return contenPanelLogin;
    }

    public void setContenPanelLogin(JPanel contenPanelLogin) {
        this.contenPanelLogin = contenPanelLogin;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }


    public JButton getIrButton() {
        return irButton;
    }

    public void setIrButton(JButton irButton) {
        this.irButton = irButton;
    }

    public JPanel getPanelLogin() {
        return panelLogin;
    }

    public void setPanelLogin(JPanel panelLogin) {
        this.panelLogin = panelLogin;
    }

    public void fondo (){
        try{
            Menuu.fondoPanel fondo = new Menuu.fondoPanel(ImageIO.read(new File("Imagenes\\FondoLogin.png")));
            getPanelLogin().setBorder(fondo);
        }catch (IOException ex){
            JOptionPane.showMessageDialog(getPanelLogin(),ex.getMessage());
        }
    }

    public void fondoPanel(){
        try{
            Menuu.fondoPanel fondo = new Menuu.fondoPanel(ImageIO.read(new File("Imagenes\\FondoLogin.png")));
            getPanelLogin().setBorder(fondo);
        }catch (IOException ex){
            JOptionPane.showMessageDialog(getPanelLogin(),ex.getMessage());
        }
    }

    public void fondoBotones (JButton boton, String ruta){
        try{
            Menuu.fondoPanel fondo = new Menuu.fondoPanel(ImageIO.read(new File(ruta)));
            boton.setBorder(fondo);
        }catch (IOException ex){
            JOptionPane.showMessageDialog(boton,ex.getMessage());
        }
    }

}
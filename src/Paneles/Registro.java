package Paneles;

import Clases.Cuenta;
import Clases.ManejoArchivos;
import Clases.Menuu;
import com.google.gson.Gson;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.RequestingUserName;
import javax.swing.*;
import java.awt.event.*;
import java.beans.PersistenceDelegate;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Registro implements Runnable{
    private JPanel contenPanelRegistro;
    private JTextField textName;

    private JTextField textDni;
    private JButton volverButton;
    private JButton registerButton;
    private JLabel labelName;
    private JLabel labelLastname;
    private JTextField textLastname;
    private JLabel labelDni;
    private JTextField textEmail;
    private JPasswordField passwordField1;
    private JTextField textUsuario;
    private JLabel labelEmail;
    private JLabel labelUsuario;
    private JLabel labelPassword;
    private JPanel panelRegistro;
    private ManejoArchivos ma = new ManejoArchivos();

    public Registro() {
        textName.setText("");
        textLastname.setText("");
        textDni.setText("");
        textEmail.setText("");
        textUsuario.setText("");
        passwordField1.setText("");

        Thread hilo =new Thread(this);
        fondo();
        fondoBotones(registerButton,"Imagenes\\botonRegistrarse.png");
        fondoBotones(volverButton,"Imagenes\\botonVolver.png");
        hilo.start();
    }

// textDni.getText()==""&&textEmail.getText()==""&&textLastname.getText()==""&&textName.getText()==""&&textUsuario.getText()==""&&passwordField1.getText()==""

    public void run () {
        while(true) {

            if (textDni.getText().isEmpty() || textEmail.getText().isEmpty() ||
                    textLastname.getText().isEmpty() || textName.getText().isEmpty() ||
                    textUsuario.getText().isEmpty() || passwordField1.getText().isEmpty()) {
                registerButton.setEnabled(false);
            }else{
                registerButton.setEnabled(true);
            }
        }

    }

    public void validarCampoNumeros(){
        textDni.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                int key = e.getKeyChar();
                boolean num = key >= 48 && key <=57;
                if (!num){
                    e.consume();
                }

                if(textDni.getText().trim().length() == 8){
                    e.consume();
                }

            }
        });
    }


    public void actionRegisterButton(JFrame f){
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LinkedList<Cuenta> aux = new LinkedList<>();
                // aca va a recuperar del archivo en la Auxiliar ; (METODO)
                if (ma.getFile().exists()){
                    aux = ma.leerArchivosAlista();
                }
                Cuenta c = new Cuenta(textName.getText(), textLastname.getText(), textDni.getText(), textUsuario.getText(), passwordField1.getText(), textEmail.getText());

                aux.add(c);

                AnimationLoad val = new AnimationLoad();

                if (!ma.buscarCuentaParaRegistro(c)) {
                    ma.cargarListaDeCuentasAarchivo(aux);
                } else {
                    Cartel car = new Cartel("Usuario ya Existente");
                }



                textUsuario.setText("");
                passwordField1.setText("");
                textEmail.setText("");
                textDni.setText("");
                textName.setText("");
                textLastname.setText("");
            }
        });
    }

    public void actionVolverButton(JFrame f,Login lg){
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setTitle("Login");
                f.setContentPane(lg.getContenPanelLogin());
                f.setVisible(true);
            }
        });
    }


    public boolean comprobarCampos(String text){
        if(text.length()==8){
            return true;
        }
        return false;
    }


    public JPanel getContenPanelRegistro() {
        return contenPanelRegistro;
    }

    public void setContenPanelRegistro(JPanel contenPanelRegistro) {
        this.contenPanelRegistro = contenPanelRegistro;
    }

    public JTextField getTextField1() {
        return textName;
    }

    public void setTextField1(JTextField textField1) {
        this.textName = textField1;
    }

    public JTextField getTextField3() {
        return textDni;
    }

    public void setTextField3(JTextField textField3) {
        this.textDni = textField3;
    }

    public JButton getVolverButton() {
        return volverButton;
    }

    public void setVolverButton(JButton volverButton) {
        this.volverButton = volverButton;
    }

    public JTextField getTextName() {
        return textName;
    }

    public JTextField getTextDni() {
        return textDni;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public JLabel getLabelName() {
        return labelName;
    }

    public JLabel getLabelLastname() {
        return labelLastname;
    }

    public JTextField getTextLastname() {
        return textLastname;
    }

    public JLabel getLabelDni() {
        return labelDni;
    }

    public JPanel getPanelRegistro() {
        return panelRegistro;
    }

    public void fondo (){
        try{
            Menuu.fondoPanel fondo = new Menuu.fondoPanel(ImageIO.read(new File("Imagenes\\FondoLogin.png")));
            getPanelRegistro().setBorder(fondo);
        }catch (IOException ex){
            JOptionPane.showMessageDialog(getPanelRegistro(),ex.getMessage());
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

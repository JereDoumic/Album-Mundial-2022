package Paneles;

import Clases.Cuenta;
import Clases.ManejoArchivos;
import Clases.Menuu;
import Clases.Usuario;
import com.google.gson.stream.MalformedJsonException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Login  {
    private JPanel contenPanelLogin;
    private JTextField textField1;
    private JButton irButton;
    private JPasswordField passwordField1;
    private JButton iniciarSesionButton;
    private ManejoArchivos mg= new ManejoArchivos();

    public Login(){
    }

    public void actionIrButton(JFrame f,Registro rg){
        irButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setTitle("Registro");
                f.setContentPane(rg.getContenPanelRegistro());
                f.setVisible(true);
            }
        });
    }

    public void actionIrAMenuButton(JFrame f, Menuu menu){
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cuenta c = new Cuenta(textField1.getText(),passwordField1.getText());
                if (mg.buscarCuenta(c)){
                    f.setTitle("Registro");
                    f.setContentPane(menu.getPanel1());
                    f.setVisible(true);
                }

            }
        });
    }


    public Usuario buscarUsuario(ArrayList<Usuario> listUsuarios, Usuario us){
        for (Usuario u: listUsuarios) {
            if (u.equals(us)){
                return u;
            }
        }
        System.out.println("no se encontró usuario");
        return null;
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

}

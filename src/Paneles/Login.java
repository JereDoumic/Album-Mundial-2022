package Paneles;

import Clases.Menuu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login  {
    private JPanel contenPanelLogin;
    private JTextField textField1;
    private JTextField textField2;
    private JButton irButton;
    private JPasswordField passwordField1;
    private JButton iniciarSesionButton;

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
                f.setTitle("Registro");
                f.setContentPane(menu.getPanel1());
                f.setVisible(true);
            }
        });
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

    public JTextField getTextField2() {
        return textField2;
    }

    public void setTextField2(JTextField textField2) {
        this.textField2 = textField2;
    }

    public JButton getIrButton() {
        return irButton;
    }

    public void setIrButton(JButton irButton) {
        this.irButton = irButton;
    }

}

package Paneles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro {
    private JPanel contenPanelRegistro;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton volverButton;
    private JPasswordField passwordField1;
    private JButton registerButton;

    public Registro() {

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

     public void actionRegisterButton(){
         registerButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 
             }
         });
     }

    public JPanel getContenPanelRegistro() {
        return contenPanelRegistro;
    }

    public void setContenPanelRegistro(JPanel contenPanelRegistro) {
        this.contenPanelRegistro = contenPanelRegistro;
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

    public JTextField getTextField3() {
        return textField3;
    }

    public void setTextField3(JTextField textField3) {
        this.textField3 = textField3;
    }

    public JButton getVolverButton() {
        return volverButton;
    }

    public void setVolverButton(JButton volverButton) {
        this.volverButton = volverButton;
    }


}

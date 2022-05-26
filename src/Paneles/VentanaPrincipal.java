package Paneles;

import Clases.Menuu;
import Clases.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal{
    private Usuario usuario = new Usuario();

    private Login lg = new Login();
    private Registro rg = new Registro();
    private Menuu menu = new Menuu(usuario);
    private Album album = new Album(usuario);
    private AbrirSobre sobre = new AbrirSobre(usuario);
    private JPanel panelPrincipal;




    public VentanaPrincipal() {
        JFrame frame = new JFrame("login");
        //frame.setLocationRelativeTo(null);
        frame.setContentPane(lg.getContenPanelLogin());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        lg.actionIrButton(frame, rg);
        rg.actionVolverButton(frame, lg);
        lg.actionIrAMenuButton(frame, menu);

        menu.actionVerAlbum(frame, album);
        menu.actionAbrirSobre(frame, sobre);

        sobre.actionVolverAMenu(frame, menu);
        sobre.actionAbrir(frame, sobre);


    }
}

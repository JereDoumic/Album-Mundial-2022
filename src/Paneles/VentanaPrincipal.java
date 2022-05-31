package Paneles;


import Clases.Menuu;
import Clases.Metodos;
import Clases.Usuario;

import javax.swing.*;

public class VentanaPrincipal{
    private Usuario usuario = new Usuario();

    JFrame frame = new JFrame("login");

    private Metodos metodos = new Metodos(usuario, frame);
    private Login lg = new Login();
    private Registro rg = new Registro();
    private Menuu menu = new Menuu(usuario);
    private Album album = new Album(usuario);
    private AbrirSobre sobre = new AbrirSobre(usuario);
    private JPanel panelPrincipal;



    public VentanaPrincipal() {

        //frame.setLocationRelativeTo(null);
        frame.setContentPane(lg.getContenPanelLogin());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        lg.actionIrButton(frame, rg);
        rg.actionVolverButton(frame, lg);
        lg.actionIrAMenuButton(frame, menu);

        menu.actionVerAlbum(frame, metodos);
        menu.actionAbrirSobre(frame, sobre);
        menu.actionVolver(frame, lg);

        sobre.actionVolverAMenu(frame, menu);
        sobre.actionAbrir(frame, sobre);

        album.actionVolverAlMenu(frame, menu);
    }
}

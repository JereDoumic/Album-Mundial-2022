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
    private AbrirSobre sobre = new AbrirSobre(usuario);
    private VerPefil perfil = new VerPefil(usuario);
    private FiguritasRepetidas figuritasRepetidas = new FiguritasRepetidas(usuario);
    private JPanel panelPrincipal;


    public VentanaPrincipal() {

        frame.setContentPane(lg.getContenPanelLogin());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        lg.actionIrButton(frame, rg);
        rg.actionVolverButton(frame, lg);
        rg.actionRegisterButton(frame);
        lg.actionIrAMenuButton(frame, menu);

        menu.actionVerAlbum(frame, metodos);
        menu.actionAbrirSobre(frame, sobre);
        menu.actionVolver(frame, lg);
        menu.actionVerPerfil(frame, perfil);

        sobre.actionVolverAMenu(frame, menu);
        sobre.actionAbrir(frame, sobre);

        perfil.actionVolver(frame, menu);
        perfil.actionVerFiguritasRepetidas(frame, figuritasRepetidas);

        figuritasRepetidas.actionVolver(frame, perfil);

        frame.setLocationRelativeTo(null);
    }
}

package Clases;

import Paneles.*;

import javax.swing.*;

public class InicProgram {
    private Usuario usuario = new Usuario();
    private Login lg = new Login();
    JFrame frame = new JFrame("Programa");
    private Metodos metodos;
    private Menuu menu = new Menuu(usuario);
    private AbrirSobre sobre;
    private VerPefil perfil;
    private FiguritasRepetidas figuritasRepetidas;

    public InicProgram(Usuario usua) {
        this.usuario = usua;
        frame.setTitle("QATAR 2022");
        frame.setSize(1600, 900);


        frame.setLocationRelativeTo(null);
        frame.setContentPane(menu.getContentPanelMenu());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        metodos = new Metodos(usuario, frame);
        sobre = new AbrirSobre(usuario);
        perfil = new VerPefil(usuario);
        figuritasRepetidas = new FiguritasRepetidas(usuario);

        menu.actionAbrirSobre(frame, sobre);
        menu.actionVolver(frame, lg);
        menu.actionVerAlbum(frame, metodos);
        menu.actionVerPerfil(frame, perfil);
        sobre.actionVolverAMenu(frame, menu);
        sobre.actionAbrir(frame, sobre);

        perfil.actionVolver(frame, menu);
        perfil.actionVerFiguritasRepetidas(frame, figuritasRepetidas);


        figuritasRepetidas.actionVolver(frame, perfil);
    }
}
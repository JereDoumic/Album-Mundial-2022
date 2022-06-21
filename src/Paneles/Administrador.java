package Paneles;

import Clases.Cuenta;
import Clases.ManejoArchivos;
import Clases.Menuu;
import Clases.Usuario;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.LinkedList;

public class Administrador extends ManejoArchivos {

    private JFrame frame = new JFrame();
    private JPanel panelMenuAdmin;
    private JPanel menuAdmin;
    private JPanel panelDeBotones;
    private JPanel panelDeTexto;
    private JButton listUsuarios;
    private JButton baja;
    private JButton salir;
    private JScrollPane scroll;
    private JTextArea textArea1;
    private JButton confirmar;
    private JTextField textField1;
    private JPanel panelVista;
    private JPanel panelVista2;


    public Administrador() {

        frame.setTitle("QATAR 2022");
        frame.setSize(1200, 600);

        frame.setLocationRelativeTo(null);
        frame.setContentPane(menuAdmin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        fondo();
        ocultarPanelDeTexto();


        botonListUsuarios();
        botonBaja();
        botonSalir();

    }


    //region Setter and Getters

    public JPanel getPanelMenuAdmin() {
        return panelMenuAdmin;
    }

    public void setPanelMenuAdmin(JPanel panelMenuAdmin) {
        this.panelMenuAdmin = panelMenuAdmin;
    }

    public JPanel getMenuAdmin() {
        return menuAdmin;
    }

    public void setMenuAdmin(JPanel menuAdmin) {
        this.menuAdmin = menuAdmin;
    }


    public JButton getBaja() {
        return baja;
    }

    public void setBaja(JButton baja) {
        this.baja = baja;
    }

    public JButton getSalir() {
        return salir;
    }

    public void setSalir(JButton salir) {
        this.salir = salir;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }


    //endregion

    //region Fondo
    public void fondo() {
        try {
            Menuu.fondoPanel fondo = new Menuu.fondoPanel(ImageIO.read(new File("Imagenes\\FondoLogin.png")));
            getMenuAdmin().setBorder(fondo);
        } catch (
                IOException ex) {
            JOptionPane.showMessageDialog(panelMenuAdmin, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //endregion


    //region Buttons

    public void botonListUsuarios() {
        listUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setVisible(false);
                mostrarPanelDeTexto();
                scroll.setVisible(true);
                scroll.setOpaque(false);
                LinkedList<Cuenta> aux = Administrador.super.leerArchivosAlista();
                textArea1.setText(aux.toString());
            }
        });

    }


    public void botonBaja() {
        baja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelDeTexto();
                confirmar.setVisible(true);
                scroll.setVisible(true);
                scroll.setOpaque(false);
                textField1.setVisible(true);
                textField1.setBackground(new Color(6,43,65));
                textArea1.setText("");
                textField1.setText("Escriba el nombre del usuario que desea eliminar: ");
                botonConfirmar(textArea1);
            }
        });
    }

    public void botonConfirmar(JTextArea textArea1) {
        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = " ";

                usuario = textArea1.getText();

                Cartel cartel;

                if (buscarCuentaPorNombre(usuario)) {
                    LinkedList<Cuenta> aux = Administrador.super.leerArchivosAlista();
                    aux.remove(buscarPosicionDeUsuario(usuario));
                    Administrador.super.cargarListaDeCuentasAarchivo(aux);
                    cartel = new Cartel("Usuario " + usuario + " eliminado");
                } else
                    cartel = new Cartel("No se encontro el usuario: " + usuario);

                textArea1.setText("");
            }
        });
    }


    public void botonSalir() {
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

    }


    //endregion


    //region Metodos

    public void ocultarPanelDeTexto(){
        menuAdmin.setVisible(true);

        panelDeBotones.setVisible(true);
        panelDeBotones.setOpaque(false);

        panelDeTexto.setVisible(true);
        panelDeTexto.setOpaque(false);

        scroll.setVisible(false);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);


        textArea1.setVisible(true);
        textArea1.setOpaque(false);

        textField1.setVisible(true);
        textField1.setBorder(null);
        textField1.setBackground(new Color(0, 0, 0, 0));

        confirmar.setVisible(false);
        confirmar.setOpaque(false);



    }


    public void mostrarPanelDeTexto(){

        menuAdmin.setVisible(true);

        panelDeBotones.setVisible(true);
        panelDeBotones.setOpaque(false);

        panelDeTexto.setVisible(true);
        panelDeTexto.setOpaque(true);

        textArea1.setVisible(true);

        confirmar.setVisible(false);
        confirmar.setOpaque(false);




    }


    public boolean buscarCuentaPorNombre(String usuario) {
        LinkedList<Cuenta> listCuentas = new LinkedList<>();
        listCuentas = leerArchivosAlista();

        for (Object p : listCuentas) {
            if (p instanceof Cuenta) {
                if (usuario.compareTo(((Cuenta) p).getUsuario()) == 0) {
                    return true;
                }
            }
        }
        return false;
    }


    private int buscarPosicionDeUsuario(String usuario) {
        LinkedList<Cuenta> lista = Administrador.super.leerArchivosAlista();
        for (Cuenta aux : lista) {
            if (aux.getUsuario().compareTo(usuario) == 0)
                return lista.indexOf(aux);
        }
        return -1;
    }
    //endregion


}

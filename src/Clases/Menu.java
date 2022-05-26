package Clases;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;


public class Menu extends JFrame {


    private Usuario usuario;



    //regionArgentinaJugadores
    Jugador Messi = new Jugador("Lionel Andres", "Messi", "Argentina");
    Jugador DePaul = new Jugador("Rodrigo", "DePaul", "Argentina");
    Jugador Paredes = new Jugador("Leandro", "Paredes", "Argentina");
    //endregion

    //regionUruguayJugadores
    Jugador Suarez = new Jugador("Luis", "Suarez", "Uruguay");
    Jugador Cavani = new Jugador("Edinson", "Cavani", "Uruguay");
    Jugador Muslera = new Jugador("Fernando", "Muslera",  "Uruguay");
    //endregion

    private LinkedList<Jugador>listaDeJugadores = new LinkedList<>();

    public Menu(Usuario usuario) throws HeadlessException {
        this.usuario = usuario;
    }

    public void menu() {

        this.setTitle("QATAR 2022");
        setSize(1600, 900);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setOpaque(false);


        setLayout(new FlowLayout());
        add(content);
        ((JPanel) getContentPane()).setOpaque(false);

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        try {
            fondoPanel fondo = new fondoPanel(ImageIO.read(new File("Imagenes\\Menu.jpg")));
            getLayeredPane().setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


        //regionBotones
        //BOTON ABRIR SOBRE
        JButton boton = new JButton();
        boton.setText("ABRIR SOBRE");
        boton.setEnabled(true);
        boton.setBounds(675, 325, 250, 250);
        getLayeredPane().add(boton, new Integer(Integer.MIN_VALUE));

        //BOTON USUARIO
        JButton botonUsuario = new JButton();
        botonUsuario.setText("USUARIO");
        botonUsuario.setEnabled(true);
        botonUsuario.setBounds(200, 200, 250, 250);
        getLayeredPane().add(botonUsuario, new Integer(Integer.MIN_VALUE));

        JButton botonVerAlbum = new JButton();
        botonVerAlbum.setText("VER ALBUM");
        botonVerAlbum.setEnabled(true);
        botonVerAlbum.setBounds(1100, 500, 250, 250);
        getLayeredPane().add(botonVerAlbum, new Integer(Integer.MIN_VALUE));
        //endregion

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getLayeredPane().remove(boton);
                getLayeredPane().remove(botonUsuario);
                getLayeredPane().remove(botonVerAlbum);
                abrirSobre();
            }
        });

        botonUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getLayeredPane().remove(botonUsuario);
                getLayeredPane().remove(boton);
                botonVerAlbum.setVisible(false);
                probando();
            }
        });

        botonVerAlbum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonVerAlbum.setVisible(false);
                boton.setVisible(false);
                botonUsuario.setVisible(false);
                argentina();
            }
        });

    }

    public void saludar(){
        System.out.println("hola");
    }

    public void probando(){

        ImageIcon imagen1 = new ImageIcon( "Imagenes\\Messi.jpg");
        JLabel label1 = new JLabel(imagen1);
        getLayeredPane().add(label1, new Integer(Integer.MIN_VALUE));
        label1.setBounds(90, 10, imagen1.getIconWidth(), imagen1.getIconHeight());
        label1.setSize(new Dimension(400, 400));


        //regionBotones
        JButton botonVolver = new JButton();
        botonVolver.setText("VOLVER");
        botonVolver.setEnabled(true);
        botonVolver.setBounds(1200, 500, 100, 100);
        getLayeredPane().add(botonVolver, new Integer(Integer.MIN_VALUE));

        JButton botonVisible = new JButton();
        botonVisible.setText("VISIBLE");
        botonVisible.setEnabled(true);
        botonVisible.setBounds(1000, 500, 100, 100);
        getLayeredPane().add(botonVisible, new Integer(Integer.MIN_VALUE));

        JButton botonNoVisible = new JButton();
        botonNoVisible.setText("NO VISIBLE");
        botonNoVisible.setEnabled(true);
        botonNoVisible.setBounds(800, 500, 100, 100);
        getLayeredPane().add(botonNoVisible, new Integer(Integer.MIN_VALUE));
        //endregion


        botonVisible.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setVisible(true);
            }
        });

        botonNoVisible.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setVisible(false);
            }
        });

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonVolver.setVisible(false);
                botonVisible.setVisible(false);
                botonNoVisible.setVisible(false);
                label1.setVisible(false);
                menu();
            }
        });

    }

    public void abrirSobre(){




        //regionAregntina
        Pais Argentina = new Pais();
        Argentina.setJugadores(Messi);
        Argentina.setJugadores(DePaul);
        Argentina.setJugadores(Paredes);
        //endregion

        //regionUruguay
        Pais Uruguay = new Pais();
        Uruguay.setJugadores(Suarez);
        Uruguay.setJugadores(Cavani);
        Uruguay.setJugadores(Muslera);
        //endregion


        int i;
        int j;
        Jugador[] aux = new Jugador[5];
        Pais[] paises = {Argentina, Uruguay};
        for(int a = 0; a < 5; a++){
            Random rand = new Random();
            i = rand.nextInt(0, 2);
            j = rand.nextInt(0, 3);
            aux[a] = paises[i].getJugadores(j);
            this.usuario.agregarJugadores(paises[i].getJugadores(j));
        }



        ImageIcon imagen1 = new ImageIcon("Imagenes\\" + aux[0].getApellido() + ".jpg");
        JLabel label1 = new JLabel(imagen1);
        getLayeredPane().add(label1, new Integer(Integer.MIN_VALUE));
        label1.setBounds(90, 10, imagen1.getIconWidth(), imagen1.getIconHeight());
        label1.setSize(new Dimension(400, 400));

        ImageIcon imagen2 = new ImageIcon("Imagenes\\" + aux[1].getApellido() + ".jpg");
        JLabel label2 = new JLabel(imagen2);
        getLayeredPane().add(label2, new Integer(Integer.MIN_VALUE));
        label2.setBounds(590, 10, imagen2.getIconWidth(), imagen2.getIconHeight());
        label2.setSize(new Dimension(400, 400));

        ImageIcon imagen3 = new ImageIcon("Imagenes\\" + aux[2].getApellido() + ".jpg");
        JLabel label3 = new JLabel(imagen3);
        getLayeredPane().add(label3, new Integer(Integer.MIN_VALUE));
        label3.setBounds(1090, 10, imagen3.getIconWidth(), imagen3.getIconHeight());
        label3.setSize(new Dimension(400, 400));

        ImageIcon imagen4 = new ImageIcon("Imagenes\\" + aux[3].getApellido() + ".jpg");
        JLabel label4 = new JLabel(imagen4);
        getLayeredPane().add(label4, new Integer(Integer.MIN_VALUE));
        label4.setBounds(250, 450, imagen4.getIconWidth(), imagen4.getIconHeight());
        label4.setSize(new Dimension(400, 400));

        ImageIcon imagen5 = new ImageIcon("Imagenes\\" + aux[4].getApellido() + ".jpg");
        JLabel label5 = new JLabel(imagen5);
        getLayeredPane().add(label5, new Integer(Integer.MIN_VALUE));
        label5.setBounds(750, 450, imagen5.getIconWidth(), imagen5.getIconHeight());
        label5.setSize(new Dimension(400, 400));

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JButton botonVolver = new JButton();
        botonVolver.setText("VOLVER");
        botonVolver.setEnabled(true);
        botonVolver.setBounds(1200, 500, 100, 100);
        getLayeredPane().add(botonVolver, new Integer(Integer.MIN_VALUE));
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setVisible(false);
                label2.setVisible(false);
                label3.setVisible(false);
                label4.setVisible(false);
                label5.setVisible(false);
                botonVolver.setVisible(false);
                menu();
            }
        });
    }


    public void argentina(){

        try {
            fondoPanel fondo = new fondoPanel(ImageIO.read(new File("Imagenes\\probando.jpg")));
            getLayeredPane().setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


        ImageIcon imagen1 = new ImageIcon("Imagenes\\Messi.jpg");
        JLabel label1 = new JLabel(imagen1);
        getLayeredPane().add(label1, new Integer(Integer.MIN_VALUE));
        label1.setBounds(170, 295, imagen1.getIconWidth(), imagen1.getIconHeight());
        label1.setSize(new Dimension(150, 200));
        label1.setVisible(this.usuario.buscarJugador(Messi));

        ImageIcon imagen2 = new ImageIcon("Imagenes\\DePaul2.jpg");
        JLabel label2 = new JLabel(imagen2);
        getLayeredPane().add(label2, new Integer(Integer.MIN_VALUE));
        label2.setBounds(370, 295, imagen2.getIconWidth(), imagen2.getIconHeight());
        label2.setSize(new Dimension(150, 200));
        label2.setVisible(this.usuario.buscarJugador(DePaul));

        ImageIcon imagen3 = new ImageIcon("Imagenes\\Paredes.jpg");
        JLabel label3 = new JLabel(imagen3);
        getLayeredPane().add(label3, new Integer(Integer.MIN_VALUE));
        label3.setBounds(570, 295, imagen3.getIconWidth(), imagen3.getIconHeight());
        label3.setSize(new Dimension(150, 200));
        label3.setVisible(this.usuario.buscarJugador(Paredes));



        JButton botonVolver = new JButton();
        botonVolver.setEnabled(true);
        botonVolver.setBounds(10, 750, 100, 100);
        try {
            fondoPanel fondo = new fondoPanel(ImageIO.read(new File("Imagenes\\volver.jpg")));
            botonVolver.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        getLayeredPane().add(botonVolver, new Integer(Integer.MIN_VALUE));

        JButton botonSiguiente = new JButton();
        botonSiguiente.setText("SIGUIENTE");
        botonSiguiente.setEnabled(true);
        botonSiguiente.setBounds(1470, 750, 100, 100);
        getLayeredPane().add(botonSiguiente, new Integer(Integer.MIN_VALUE));

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setVisible(false);
                label2.setVisible(false);
                label3.setVisible(false);
                botonVolver.setVisible(false);
                botonSiguiente.setVisible(false);
                menu();
            }
        });

        botonSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setVisible(false);
                label2.setVisible(false);
                label3.setVisible(false);
                botonVolver.setVisible(false);
                botonSiguiente.setVisible(false);
                uruguay();
            }
        });
    }

    public void uruguay(){
        try {
            fondoPanel fondo = new fondoPanel(ImageIO.read(new File("Imagenes\\probandoUruguay.jpg")));
            getLayeredPane().setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


        ImageIcon imagen1 = new ImageIcon("Imagenes\\Muslera.jpg");
        JLabel label1 = new JLabel(imagen1);
        getLayeredPane().add(label1, new Integer(Integer.MIN_VALUE));
        label1.setBounds(70, 320, imagen1.getIconWidth(), imagen1.getIconHeight());
        label1.setSize(new Dimension(180, 230));
        label1.setVisible(this.usuario.buscarJugador(Muslera));

        ImageIcon imagen2 = new ImageIcon("Imagenes\\Suarez.jpg");
        JLabel label2 = new JLabel(imagen2);
        getLayeredPane().add(label2, new Integer(Integer.MIN_VALUE));
        label2.setBounds(300, 320, imagen2.getIconWidth(), imagen2.getIconHeight());
        label2.setSize(new Dimension(180, 230));
        label2.setVisible(this.usuario.buscarJugador(Suarez));

        ImageIcon imagen3 = new ImageIcon("Imagenes\\Cavani.jpg");
        JLabel label3 = new JLabel(imagen3);
        getLayeredPane().add(label3, new Integer(Integer.MIN_VALUE));
        label3.setBounds(530, 320, imagen3.getIconWidth(), imagen3.getIconHeight());
        label3.setSize(new Dimension(180, 230));
        label3.setVisible(this.usuario.buscarJugador(Cavani));



        JButton botonVolver = new JButton();
        botonVolver.setText("VOLVER");
        botonVolver.setEnabled(true);
        botonVolver.setBounds(10, 750, 100, 100);
        getLayeredPane().add(botonVolver, new Integer(Integer.MIN_VALUE));

        JButton botonSiguiente = new JButton();
        botonSiguiente.setText("SIGUIENTE");
        botonSiguiente.setEnabled(true);
        botonSiguiente.setBounds(1470, 750, 100, 100);
        getLayeredPane().add(botonSiguiente, new Integer(Integer.MIN_VALUE));

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setVisible(false);
                label2.setVisible(false);
                label3.setVisible(false);
                botonVolver.setVisible(false);
                botonSiguiente.setVisible(false);
                menu();
            }
        });

        botonSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setVisible(false);
                label2.setVisible(false);
                label3.setVisible(false);
                botonVolver.setVisible(false);
                botonSiguiente.setVisible(false);
                argentina();
            }
        });
    }

    public static class fondoPanel implements Border {

        private BufferedImage mImagen = null;

        /**
         * Constructor, indicamos la imagen que queremos que se redimensione
         * @param pImagen ImageIO.read(new File(ruta imagen))
         */
        public fondoPanel(BufferedImage pImagen) {
            mImagen = pImagen;
        }

        public fondoPanel() {
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            if (mImagen != null) {
                g.drawImage(mImagen, 0, 0, width, height, null);
            }
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(0, 0, 0, 0);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }
    }
}

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


public class Metodos extends JFrame {


    private Usuario usuario;
    private JFrame frame;

    public Metodos(Usuario usuario, JFrame frame) throws HeadlessException {
        this.usuario = usuario;
        this.frame = frame;
    }

    public void argentina(){
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
            fondoPanel fondo = new fondoPanel(ImageIO.read(new File("Imagenes\\Argentina\\Argentina.jpg")));
            getLayeredPane().setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


        ImageIcon imagen1 = new ImageIcon("Imagenes\\Argentina\\EscudoArgentina2.jpg");
        JLabel label1 = new JLabel(imagen1);
        getLayeredPane().add(label1, new Integer(Integer.MIN_VALUE));
        label1.setBounds(75, 320, imagen1.getIconWidth(), imagen1.getIconHeight());
        label1.setSize(new Dimension(180, 230));
        label1.setFocusable(true);
        label1.setVisible(this.usuario.buscarJugador(Sistema.EscudoArgentina));

        ImageIcon imagen2 = new ImageIcon("Imagenes\\Argentina\\Otamendi2.jpg");
        JLabel label2 = new JLabel(imagen2);
        getLayeredPane().add(label2, new Integer(Integer.MIN_VALUE));
        label2.setBounds(305, 320, imagen2.getIconWidth(), imagen2.getIconHeight());
        label2.setSize(new Dimension(180, 230));
        label2.setVisible(this.usuario.buscarJugador(Sistema.Otamendi));

        ImageIcon imagen3 = new ImageIcon("Imagenes\\Argentina\\Messi2.jpg");
        JLabel label3 = new JLabel(imagen3);
        getLayeredPane().add(label3, new Integer(Integer.MIN_VALUE));
        label3.setBounds(535, 320, imagen3.getIconWidth(), imagen3.getIconHeight());
        label3.setSize(new Dimension(180, 230));
        label3.setVisible(this.usuario.buscarJugador(Sistema.Messi));

        ImageIcon imagen4 = new ImageIcon("Imagenes\\Argentina\\DiMaria2.jpg");
        JLabel label4 = new JLabel(imagen4);
        getLayeredPane().add(label4, new Integer(Integer.MIN_VALUE));
        label4.setBounds(75, 570, imagen4.getIconWidth(), imagen4.getIconHeight());
        label4.setSize(new Dimension(180, 230));
        label4.setVisible(this.usuario.buscarJugador(Sistema.DiMaria));

        ImageIcon imagen5 = new ImageIcon("Imagenes\\Argentina\\Acunia2.jpg");
        JLabel label5 = new JLabel(imagen5);
        getLayeredPane().add(label5, new Integer(Integer.MIN_VALUE));
        label5.setBounds(305, 570, imagen5.getIconWidth(), imagen5.getIconHeight());
        label5.setSize(new Dimension(180, 230));
        label5.setVisible(this.usuario.buscarJugador(Sistema.DiMaria));


        JButton botonVolver = new JButton();
        botonVolver.setEnabled(true);
        botonVolver.setFocusPainted(true);
        botonVolver.setBorderPainted(true);
        botonVolver.setContentAreaFilled(false);
        botonVolver.setBounds(5, 5, 71, 71);
        try {
            fondoPanel fondo = new fondoPanel(ImageIO.read(new File("Imagenes\\volver.png")));
            botonVolver.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        getLayeredPane().add(botonVolver, new Integer(Integer.MIN_VALUE));

        JButton botonSiguiente = new JButton();
        botonSiguiente.setEnabled(true);
        botonSiguiente.setFocusPainted(true);
        botonSiguiente.setBorderPainted(true);
        botonSiguiente.setContentAreaFilled(false);
        botonSiguiente.setBounds(1500, 780, 71, 71);
        try {
            fondoPanel fondo = new fondoPanel(ImageIO.read(new File("Imagenes\\flechaDerecha.png")));
            botonSiguiente.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(botonSiguiente, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        getLayeredPane().add(botonSiguiente, new Integer(Integer.MIN_VALUE));

        JButton botonAnterior = new JButton();
        botonAnterior.setEnabled(true);
        botonAnterior.setFocusPainted(true);
        botonAnterior.setBorderPainted(true);
        botonAnterior.setContentAreaFilled(false);
        botonAnterior.setBounds(10, 780, 71, 71);
        try {
            fondoPanel fondo = new fondoPanel(ImageIO.read(new File("Imagenes\\flechaIzquierda.png")));
            botonAnterior.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(botonAnterior, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        getLayeredPane().add(botonAnterior, new Integer(Integer.MIN_VALUE));

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setVisible(false);
                label2.setVisible(false);
                label3.setVisible(false);
                label4.setVisible(false);
                label5.setVisible(false);
                botonVolver.setVisible(false);
                botonAnterior.setVisible(false);
                botonSiguiente.setVisible(false);
                setVisible(false);
                frame.setVisible(true);
            }
        });

        botonSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setVisible(false);
                label2.setVisible(false);
                label3.setVisible(false);
                label4.setVisible(false);
                label5.setVisible(false);
                botonVolver.setVisible(false);
                botonAnterior.setVisible(false);
                botonSiguiente.setVisible(false);
                uruguay();
            }
        });
    }

    public void uruguay(){
        try {
            fondoPanel fondo = new fondoPanel(ImageIO.read(new File("Imagenes\\Uruguay\\Uruguay.jpg")));
            getLayeredPane().setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


        ImageIcon imagen1 = new ImageIcon("Imagenes\\Uruguay\\EscudoUruguay2.jpg");
        JLabel label1 = new JLabel(imagen1);
        getLayeredPane().add(label1, new Integer(Integer.MIN_VALUE));
        label1.setBounds(75, 320, imagen1.getIconWidth(), imagen1.getIconHeight());
        label1.setSize(new Dimension(180, 230));
        label1.setVisible(this.usuario.buscarJugador(Sistema.Muslera));

        ImageIcon imagen2 = new ImageIcon("Imagenes\\Uruguay\\Muslera2.jpg");
        JLabel label2 = new JLabel(imagen2);
        getLayeredPane().add(label2, new Integer(Integer.MIN_VALUE));
        label2.setBounds(305, 320, imagen2.getIconWidth(), imagen2.getIconHeight());
        label2.setSize(new Dimension(180, 230));
        label2.setVisible(this.usuario.buscarJugador(Sistema.Muslera));

        ImageIcon imagen3 = new ImageIcon("Imagenes\\Uruguay\\Cavani2.jpg");
        JLabel label3 = new JLabel(imagen3);
        getLayeredPane().add(label3, new Integer(Integer.MIN_VALUE));
        label3.setBounds(535, 320, imagen3.getIconWidth(), imagen3.getIconHeight());
        label3.setSize(new Dimension(180, 230));
        label3.setVisible(this.usuario.buscarJugador(Sistema.Cavani));

        ImageIcon imagen4 = new ImageIcon("Imagenes\\Uruguay\\Gimenez2.jpg");
        JLabel label4 = new JLabel(imagen4);
        getLayeredPane().add(label4, new Integer(Integer.MIN_VALUE));
        label4.setBounds(75, 570, imagen4.getIconWidth(), imagen4.getIconHeight());
        label4.setSize(new Dimension(180, 230));
        label4.setVisible(this.usuario.buscarJugador(Sistema.Gimenez));

        ImageIcon imagen5 = new ImageIcon("Imagenes\\Uruguay\\Godin2.jpg");
        JLabel label5 = new JLabel(imagen5);
        getLayeredPane().add(label5, new Integer(Integer.MIN_VALUE));
        label5.setBounds(1095, 320, imagen5.getIconWidth(), imagen5.getIconHeight());
        label5.setSize(new Dimension(180, 230));
        label5.setVisible(this.usuario.buscarJugador(Sistema.Godin));

        ImageIcon imagen6 = new ImageIcon("Imagenes\\Uruguay\\Suarez2.jpg");
        JLabel label6 = new JLabel(imagen6);
        getLayeredPane().add(label6, new Integer(Integer.MIN_VALUE));
        label6.setBounds(868, 320, imagen6.getIconWidth(), imagen6.getIconHeight());
        label6.setSize(new Dimension(180, 230));
        label6.setVisible(this.usuario.buscarJugador(Sistema.Suarez));


        JButton botonVolver = new JButton();
        botonVolver.setEnabled(true);
        botonVolver.setFocusPainted(true);
        botonVolver.setBorderPainted(true);
        botonVolver.setContentAreaFilled(false);
        botonVolver.setBounds(5, 5, 71, 71);
        try {
            fondoPanel fondo = new fondoPanel(ImageIO.read(new File("Imagenes\\volver.png")));
            botonVolver.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        getLayeredPane().add(botonVolver, new Integer(Integer.MIN_VALUE));

        JButton botonSiguiente = new JButton();
        botonSiguiente.setEnabled(true);
        botonSiguiente.setFocusPainted(true);
        botonSiguiente.setBorderPainted(true);
        botonSiguiente.setContentAreaFilled(false);
        botonSiguiente.setBounds(1500, 780, 71, 71);
        try {
            fondoPanel fondo = new fondoPanel(ImageIO.read(new File("Imagenes\\flechaDerecha.png")));
            botonSiguiente.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(botonSiguiente, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        getLayeredPane().add(botonSiguiente, new Integer(Integer.MIN_VALUE));

        JButton botonAnterior = new JButton();
        botonAnterior.setEnabled(true);
        botonAnterior.setFocusPainted(true);
        botonAnterior.setBorderPainted(true);
        botonAnterior.setContentAreaFilled(false);
        botonAnterior.setBounds(10, 780, 71, 71);
        try {
            fondoPanel fondo = new fondoPanel(ImageIO.read(new File("Imagenes\\flechaIzquierda.png")));
            botonAnterior.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(botonAnterior, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        getLayeredPane().add(botonAnterior, new Integer(Integer.MIN_VALUE));

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setVisible(false);
                label2.setVisible(false);
                label3.setVisible(false);
                label4.setVisible(false);
                label5.setVisible(false);
                label6.setVisible(false);
                botonVolver.setVisible(false);
                botonSiguiente.setVisible(false);
                botonAnterior.setVisible(false);
                setVisible(false);
                frame.setVisible(true);
            }
        });

        botonAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setVisible(false);
                label2.setVisible(false);
                label3.setVisible(false);
                label4.setVisible(false);
                label5.setVisible(false);
                label6.setVisible(false);
                botonVolver.setVisible(false);
                botonSiguiente.setVisible(false);
                botonAnterior.setVisible(false);
                argentina();
            }
        });

        botonSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setVisible(false);
                label2.setVisible(false);
                label3.setVisible(false);
                label4.setVisible(false);
                label5.setVisible(false);
                label6.setVisible(false);
                botonVolver.setVisible(false);
                botonSiguiente.setVisible(false);
                botonAnterior.setVisible(false);
                espania();
            }
        });
    }

    public void espania(){
        try {
            fondoPanel fondo = new fondoPanel(ImageIO.read(new File("Imagenes\\Espania\\Espania.jpg")));
            getLayeredPane().setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


        ImageIcon imagen1 = new ImageIcon("Imagenes\\Espania\\DeGea2.jpg");
        JLabel label1 = new JLabel(imagen1);
        getLayeredPane().add(label1, new Integer(Integer.MIN_VALUE));
        label1.setBounds(70, 320, imagen1.getIconWidth(), imagen1.getIconHeight());
        label1.setSize(new Dimension(180, 230));
        label1.setVisible(this.usuario.buscarJugador(Sistema.Muslera));

        ImageIcon imagen2 = new ImageIcon("Imagenes\\Espania\\Alcantara2.jpg");
        JLabel label2 = new JLabel(imagen2);
        getLayeredPane().add(label2, new Integer(Integer.MIN_VALUE));
        label2.setBounds(300, 320, imagen2.getIconWidth(), imagen2.getIconHeight());
        label2.setSize(new Dimension(180, 230));
        label2.setVisible(this.usuario.buscarJugador(Sistema.Suarez));

        ImageIcon imagen3 = new ImageIcon("Imagenes\\Espania\\Busquets2.jpg");
        JLabel label3 = new JLabel(imagen3);
        getLayeredPane().add(label3, new Integer(Integer.MIN_VALUE));
        label3.setBounds(530, 320, imagen3.getIconWidth(), imagen3.getIconHeight());
        label3.setSize(new Dimension(180, 230));
        label3.setVisible(this.usuario.buscarJugador(Sistema.Cavani));

        ImageIcon imagen4 = new ImageIcon("Imagenes\\Espania\\Alba2.jpg");
        JLabel label4 = new JLabel(imagen4);
        getLayeredPane().add(label4, new Integer(Integer.MIN_VALUE));
        label4.setBounds(868, 320, imagen4.getIconWidth(), imagen4.getIconHeight());
        label4.setSize(new Dimension(180, 230));
        label4.setVisible(this.usuario.buscarJugador(Sistema.Cavani));

        ImageIcon imagen5 = new ImageIcon("Imagenes\\Espania\\Caravajal2.jpg");
        JLabel label5 = new JLabel(imagen5);
        getLayeredPane().add(label5, new Integer(Integer.MIN_VALUE));
        label5.setBounds(1168, 320, imagen5.getIconWidth(), imagen5.getIconHeight());
        label5.setSize(new Dimension(180, 230));
        label5.setVisible(this.usuario.buscarJugador(Sistema.Cavani));


        JButton botonVolver = new JButton();
        botonVolver.setEnabled(true);
        botonVolver.setFocusPainted(true);
        botonVolver.setBorderPainted(true);
        botonVolver.setContentAreaFilled(false);
        botonVolver.setBounds(5, 5, 71, 71);
        try {
            fondoPanel fondo = new fondoPanel(ImageIO.read(new File("Imagenes\\volver.png")));
            botonVolver.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        getLayeredPane().add(botonVolver, new Integer(Integer.MIN_VALUE));

        JButton botonSiguiente = new JButton();
        botonSiguiente.setEnabled(true);
        botonSiguiente.setFocusPainted(true);
        botonSiguiente.setBorderPainted(true);
        botonSiguiente.setContentAreaFilled(false);
        botonSiguiente.setBounds(1500, 780, 71, 71);
        try {
            fondoPanel fondo = new fondoPanel(ImageIO.read(new File("Imagenes\\flechaDerecha.png")));
            botonSiguiente.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(botonSiguiente, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        getLayeredPane().add(botonSiguiente, new Integer(Integer.MIN_VALUE));

        JButton botonAnterior = new JButton();
        botonAnterior.setEnabled(true);
        botonAnterior.setFocusPainted(true);
        botonAnterior.setBorderPainted(true);
        botonAnterior.setContentAreaFilled(false);
        botonAnterior.setBounds(10, 780, 71, 71);
        try {
            fondoPanel fondo = new fondoPanel(ImageIO.read(new File("Imagenes\\flechaIzquierda.png")));
            botonAnterior.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(botonAnterior, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        getLayeredPane().add(botonAnterior, new Integer(Integer.MIN_VALUE));

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setVisible(false);
                label2.setVisible(false);
                label3.setVisible(false);
                label4.setVisible(false);
                label5.setVisible(false);
                botonVolver.setVisible(false);
                botonSiguiente.setVisible(false);
                botonAnterior.setVisible(false);
                setVisible(false);
                frame.setVisible(true);
            }
        });

        botonAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setVisible(false);
                label2.setVisible(false);
                label3.setVisible(false);
                label4.setVisible(false);
                label5.setVisible(false);
                botonVolver.setVisible(false);
                botonSiguiente.setVisible(false);
                botonAnterior.setVisible(false);
                uruguay();
            }
        });

        botonSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setVisible(false);
                label2.setVisible(false);
                label3.setVisible(false);
                label4.setVisible(false);
                label5.setVisible(false);
                botonVolver.setVisible(false);
                botonSiguiente.setVisible(false);
                botonAnterior.setVisible(false);
                francia();
            }
        });
    }

    public void francia(){

        try {
            fondoPanel fondo = new fondoPanel(ImageIO.read(new File("Imagenes\\Francia\\Francia.jpg")));
            getLayeredPane().setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


        ImageIcon imagen1 = new ImageIcon("Imagenes\\Uruguay\\Muslera2.jpg");
        JLabel label1 = new JLabel(imagen1);
        getLayeredPane().add(label1, new Integer(Integer.MIN_VALUE));
        label1.setBounds(75, 320, imagen1.getIconWidth(), imagen1.getIconHeight());
        label1.setSize(new Dimension(180, 230));
        label1.setVisible(this.usuario.buscarJugador(Sistema.Muslera));

        ImageIcon imagen2 = new ImageIcon("Imagenes\\Uruguay\\Suarez2.jpg");
        JLabel label2 = new JLabel(imagen2);
        getLayeredPane().add(label2, new Integer(Integer.MIN_VALUE));
        label2.setBounds(305, 320, imagen2.getIconWidth(), imagen2.getIconHeight());
        label2.setSize(new Dimension(180, 230));
        label2.setVisible(this.usuario.buscarJugador(Sistema.Suarez));

        ImageIcon imagen3 = new ImageIcon("Imagenes\\Uruguay\\Cavani2.jpg");
        JLabel label3 = new JLabel(imagen3);
        getLayeredPane().add(label3, new Integer(Integer.MIN_VALUE));
        label3.setBounds(535, 320, imagen3.getIconWidth(), imagen3.getIconHeight());
        label3.setSize(new Dimension(180, 230));
        label3.setVisible(this.usuario.buscarJugador(Sistema.Cavani));

        ImageIcon imagen4 = new ImageIcon("Imagenes\\Uruguay\\Gimenez2.jpg");
        JLabel label4 = new JLabel(imagen4);
        getLayeredPane().add(label4, new Integer(Integer.MIN_VALUE));
        label4.setBounds(868, 320, imagen4.getIconWidth(), imagen4.getIconHeight());
        label4.setSize(new Dimension(180, 230));
        label4.setVisible(this.usuario.buscarJugador(Sistema.Gimenez));

        ImageIcon imagen5 = new ImageIcon("Imagenes\\Uruguay\\Godin2.jpg");
        JLabel label5 = new JLabel(imagen5);
        getLayeredPane().add(label5, new Integer(Integer.MIN_VALUE));
        label5.setBounds(1168, 320, imagen5.getIconWidth(), imagen5.getIconHeight());
        label5.setSize(new Dimension(180, 230));
        label5.setVisible(this.usuario.buscarJugador(Sistema.Godin));


        JButton botonVolver = new JButton();
        botonVolver.setEnabled(true);
        botonVolver.setFocusPainted(true);
        botonVolver.setBorderPainted(true);
        botonVolver.setContentAreaFilled(false);
        botonVolver.setBounds(5, 5, 71, 71);
        try {
            fondoPanel fondo = new fondoPanel(ImageIO.read(new File("Imagenes\\volver.png")));
            botonVolver.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        getLayeredPane().add(botonVolver, new Integer(Integer.MIN_VALUE));

        JButton botonSiguiente = new JButton();
        botonSiguiente.setEnabled(true);
        botonSiguiente.setFocusPainted(true);
        botonSiguiente.setBorderPainted(true);
        botonSiguiente.setContentAreaFilled(false);
        botonSiguiente.setBounds(1500, 780, 71, 71);
        try {
            fondoPanel fondo = new fondoPanel(ImageIO.read(new File("Imagenes\\flechaDerecha.png")));
            botonSiguiente.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(botonSiguiente, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        getLayeredPane().add(botonSiguiente, new Integer(Integer.MIN_VALUE));

        JButton botonAnterior = new JButton();
        botonAnterior.setEnabled(true);
        botonAnterior.setFocusPainted(true);
        botonAnterior.setBorderPainted(true);
        botonAnterior.setContentAreaFilled(false);
        botonAnterior.setBounds(10, 780, 71, 71);
        try {
            fondoPanel fondo = new fondoPanel(ImageIO.read(new File("Imagenes\\flechaIzquierda.png")));
            botonAnterior.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(botonAnterior, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        getLayeredPane().add(botonAnterior, new Integer(Integer.MIN_VALUE));

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setVisible(false);
                label2.setVisible(false);
                label3.setVisible(false);
                label4.setVisible(false);
                label5.setVisible(false);
                botonVolver.setVisible(false);
                botonSiguiente.setVisible(false);
                botonAnterior.setVisible(false);
                setVisible(false);
                frame.setVisible(true);
            }
        });

        botonAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setVisible(false);
                label2.setVisible(false);
                label3.setVisible(false);
                label4.setVisible(false);
                label5.setVisible(false);
                botonVolver.setVisible(false);
                botonSiguiente.setVisible(false);
                botonAnterior.setVisible(false);
                espania();
            }
        });

        botonSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setVisible(false);
                label2.setVisible(false);
                label3.setVisible(false);
                label4.setVisible(false);
                label5.setVisible(false);
                botonVolver.setVisible(false);
                botonSiguiente.setVisible(false);
                botonAnterior.setVisible(false);
                argentina();
            }
        });
    }

    public class fondoPanel implements Border {

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

package Clases;

import Paneles.AbrirSobre;
import Paneles.Login;
import Paneles.VerPefil;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menuu extends Component {
    private JPanel panel1;
    private JButton verAlbumButton;
    private JPanel contentPanelMenu;
    private JButton abrirSobreButton;
    private JPanel PanelMenu;
    private JButton volverButton;
    private JButton verPerfil;

    public Menuu(Usuario usuario) {
        fondo();
    }

    public Menuu(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel1() {
        return contentPanelMenu;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JButton getVerAlbumButton() {
        return verAlbumButton;
    }

    public void setVerAlbumButton(JButton verAlbumButton) {
        this.verAlbumButton = verAlbumButton;
    }

    public JPanel getContentPanelMenu() {
        return contentPanelMenu;
    }

    public void setContentPanelMenu(JPanel contentPanelMenu) {
        this.contentPanelMenu = contentPanelMenu;
    }

    public JButton getAbrirSobreButton() {
        return abrirSobreButton;
    }

    public void setAbrirSobreButton(JButton abrirSobreButton) {
        this.abrirSobreButton = abrirSobreButton;
    }

    public JPanel getPanelMenu() {
        return PanelMenu;
    }

    public void setPanelMenu(JPanel panelMenu) {
        PanelMenu = panelMenu;
    }

    public void fondo(){
        try {
            Menuu.fondoPanel fondo = new fondoPanel(ImageIO.read(new File("Imagenes\\Menu.jpg")));
            getPanelMenu().setBorder(fondo);
        } catch (
                IOException ex) {
            JOptionPane.showMessageDialog(contentPanelMenu, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //regionBotones
    public void actionVerAlbum(JFrame frame, Metodos menu){
        verAlbumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                menu.argentina();
            }
        });
    }

    public void actionAbrirSobre(JFrame f, AbrirSobre abrirSobre){
        abrirSobreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(abrirSobre.getContentPanelAbrirSobre());
                f.setVisible(true);
            }
        });
    }

    public void actionVolver(JFrame f, Login lg){
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(lg.getContenPanelLogin());
                f.setVisible(true);
            }
        });
    }

    public void actionVerPerfil(JFrame f, VerPefil perfil){
        verPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(perfil.getVerPefilPanel());
                perfil.cargarText();
                f.setVisible(true);
            }
        });
    }



    //endregion

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

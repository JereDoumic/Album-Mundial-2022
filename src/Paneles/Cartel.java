package Paneles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cartel {
    private JPanel contentPanelCartel;

    private JButton okButton;
    private JLabel textLabel;

    public Cartel(String text) {

        JFrame frame = new JFrame("Adventencia");
        frame.setContentPane(getContentPanelCartel());
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        textLabel.setText(text);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public JPanel getContentPanelCartel() {
        return contentPanelCartel;
    }

    public void setContentPanelCartel(JPanel contentPanelCartel) {
        this.contentPanelCartel = contentPanelCartel;
    }

}



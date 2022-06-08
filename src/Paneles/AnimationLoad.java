package Paneles;

import javax.swing.*;

public class AnimationLoad extends JFrame implements Runnable {
    private JPanel contentPanelValidation;
    private JProgressBar progressBar1;


    public AnimationLoad() {
        setTitle("Validando");
        setContentPane(getContentPanelValidacion());
        setBounds(300,300,550,100);
        setVisible(true);
        Thread hilo =new Thread(this::run);
        hilo.start();

    }

    @Override
    public void run() {
        for (int i=0;i<=100;i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.getProgressBar1().setValue(i);
        }
        dispose();
    }



    public JPanel getContentPanelValidacion() {
        return contentPanelValidation;
    }

    public void setContentPanelValidacion(JPanel contentPanelValidacion) {
        this.contentPanelValidation = contentPanelValidacion;
    }

    public JProgressBar getProgressBar1() {
        return progressBar1;
    }

    public void setProgressBar1(JProgressBar progressBar1) {
        this.progressBar1 = progressBar1;
    }


}

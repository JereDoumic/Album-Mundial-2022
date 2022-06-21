package Clases;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class TimerUsuario {
    public static int tic = 10;

    public static void timerUsuario(Usuario usuario, JButton boton) {
        Timer timer;
        timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run()
            {
                if (!usuario.puedoAbrirSobre){
                    if(tic == 0) {
                        usuario.puedoAbrirSobre = true;
                        tic = 10;
                        boton.setText("Abrir");
                        timer.cancel();
                        return;
                    }
                    boton.setText(String.valueOf(tic));
                    tic--;
                }
            }
        };
        // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
        timer.schedule(task, 10,1000);
    }
}

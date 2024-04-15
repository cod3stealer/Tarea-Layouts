package Panel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panel {
    private JProgressBar progressBar;
    private Timer timer;
    private int counter = 0;

    public Panel() {
        // Crea un panel para los controles de reproducción
        JPanel controlPanel = new JPanel();

        // Establece el administrador de diseño BoxLayout (organiza componentes horizontalmente)
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));

        // Crea botones para reproducir, pausar y borrar
        JButton playButton = new JButton("Play");
        JButton pauseButton = new JButton("Pause");
        JButton stopButton = new JButton("Borrar");  // Se corrige el nombre del botón a "Stop" para mayor claridad

        // Agrega los botones al panel de control
        controlPanel.add(playButton);
        controlPanel.add(pauseButton);
        controlPanel.add(stopButton);

        // Crea un panel para el teclado (suponiendo que sea un teclado numérico)
        JPanel keypadPanel = new JPanel(new GridLayout(3, 3));

        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            keypadPanel.add(button);
        }

        // Crea botones numéricos y los agrega al panel del teclado
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            keypadPanel.add(button);
        }

        // Crea la ventana principal (JFrame)
        JFrame frame = new JFrame("Media Control Panel");

        // Establece el administrador de diseño BorderLayout
        frame.setLayout(new BorderLayout());
        progressBar = new JProgressBar();
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);

        // Agrega los paneles a la ventana en distintas regiones del BorderLayout
        frame.add(controlPanel, BorderLayout.SOUTH);  // Panel de control en la parte inferior
        frame.add(keypadPanel, BorderLayout.CENTER);  // Panel del teclado en el centro
        frame.add(progressBar, BorderLayout.NORTH);    // Barra de progreso en la parte superior

        // Configura el tamaño y posición de la ventana
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);  // Centra la ventana en la pantalla
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Define el comportamiento al cerrar la ventana
        frame.setVisible(true);             // Hace que la ventana sea visible

        // Crea un temporizador con un intervalo de 1 segundo (1000 milisegundos)
        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;
                progressBar.setValue(counter);

                if (counter >= 100) {
                    timer.stop();
                }
            }
        });

        // Manejador del botón Play
        playButton.addActionListener(e -> timer.start());

        // Manejador del botón Pause
        pauseButton.addActionListener(e -> timer.stop());

        // Manejador del botón Stop
        stopButton.addActionListener(e -> {
            timer.stop();
            counter = 0;
            progressBar.setValue(counter);
        });
    }
}
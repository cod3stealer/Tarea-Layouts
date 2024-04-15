package CalculadoraSimple;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Inicia la ventana de la calculadora en un hilo de trabajo separado del hilo principal de la aplicación
        SwingUtilities.invokeLater(Calculadora::new);
    }
}

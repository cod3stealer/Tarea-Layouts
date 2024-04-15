package CalculadoraSimple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame implements ActionListener {
    //Atributos
    private JTextField operacion,operacion2;
    private int num, num1, resul, aux;
    private JTextArea resultado;
    private JButton suma, resta, multi, div, limpiar, calcular;

    public Calculadora(){
        // Establece el título de la ventana como "Calculadora"
        setTitle("Calculadora");

        // Define el comportamiento al cerrar la ventana
        // (JFrame.EXIT_ON_CLOSE asegura que la aplicación finalice)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Establece el tamaño de la ventana (700 píxeles de ancho, 500 píxeles de alto)
        setSize(700, 500);

        // Hace que la ventana sea visible en la pantalla
        setVisible(true);

        // Obtiene el panel de contenido principal de la ventana (donde se agregan los componentes)
        Container container = getContentPane();

        // Establece el administrador de diseño para el panel de contenido (BorderLayout organiza los componentes en 5 regiones)
        container.setLayout(new BorderLayout());

        // Crea botones para operaciones aritméticas
        suma = new JButton("Suma");
        resta = new JButton("Resta");
        multi = new JButton("Multiplicación");
        div = new JButton("División");

        // Agrega oyentes de acción a los botones (maneja clics)
        suma.addActionListener(this);
        resta.addActionListener(this);
        multi.addActionListener(this);
        div.addActionListener(this);

        // Crea un panel para contener los botones de operación
        JPanel opciones = new JPanel();

        // Establece el administrador de diseño para el panel opciones (GridLayout organiza en una cuadrícula)
        opciones.setLayout(new GridLayout(4, 4)); // 4 filas, 4 columnas

        // Agrega los botones de operación al panel opciones
        opciones.add(suma);
        opciones.add(resta);
        opciones.add(multi);
        opciones.add(div);

        // Agrega el panel opciones al panel de contenido (región central de BorderLayout)
        add(opciones, BorderLayout.CENTER);

        // Crea campos de texto para ingresar números
        operacion = new JTextField(10); // 10 columnas de ancho
        operacion2 = new JTextField(10);

        // Crea un área de texto para mostrar el resultado (no editable)
        resultado = new JTextArea(1, 10); // 1 fila, 10 columnas de ancho
        resultado.setEditable(false);

        // Crea un panel para contener los campos de entrada de números y la visualización del resultado
        JPanel operar = new JPanel();

        // Establece el administrador de diseño para el panel operar (GridLayout organiza en una cuadrícula)
        operar.setLayout(new GridLayout(1, 3)); // 1 fila, 3 columnas

        // Agrega etiquetas para los campos de entrada de números
        operar.add(new Label("Número")); // Suponiendo que Label sea una clase personalizada para etiquetas
        operar.add(operacion);
        operar.add(new Label("Número"));
        operar.add(operacion2);

        // Agrega una etiqueta para la visualización del resultado
        operar.add(new Label("Resultado"));
        operar.add(resultado);

        // Agrega el panel operar al panel de contenido (región norte de BorderLayout)
        add(operar, BorderLayout.NORTH);

        // Crea un panel para contener los botones "Limpiar" (borrar) y "="
        JPanel fin = new JPanel();

        // Establece el administrador de diseño para el panel fin (GridLayout organiza en una cuadrícula)
        fin.setLayout(new GridLayout(2, 1)); // 2 filas, 1 columna

        // Crea botones para borrar y calcular
        limpiar = new JButton("Limpiar");
        calcular = new JButton("=");

        // Agrega oyentes de acción a los botones (maneja clics)
        limpiar.addActionListener(this);
        calcular.addActionListener(this);

        // Agrega los botones "Limpiar" y "=" al panel fin
        fin.add(limpiar);
        fin.add(calcular);

        // Agrega el panel fin al panel de contenido (región este de BorderLayout)
        add(fin, BorderLayout.EAST);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Intenta convertir los textos de los campos de entrada a números enteros (Integer)
        try {
            num = Integer.parseInt(operacion.getText());
            num1 = Integer.parseInt(operacion2.getText());

            // Determina la operación a realizar según el botón presionado
            if (e.getSource() == suma) {
                aux = 1;  // Suma
            } else if (e.getSource() == resta) {
                aux = 2;  // Resta
            } else if (e.getSource() == multi) {
                aux = 3;  // Multiplicación
            } else if (e.getSource() == div) {
                aux = 4;  // División
            }

            // Maneja el botón "Limpiar"
            if (e.getSource() == limpiar) {
                aux = 0;
                operacion.setText(null);  // Limpia el campo de texto "operacion"
                operacion2.setText(null); // Limpia el campo de texto "operacion2"
                resultado.setText(null);   // Limpia el área de texto "resultado"
            }

            // Maneja el botón "=" (Calcular)
            if (e.getSource() == calcular) {
                switch (aux) {
                    case 1:
                        resul = num + num1;
                        resultado.setText(String.valueOf(resul));
                        break;
                    case 2:
                        resul = num - num1;
                        resultado.setText(String.valueOf(resul));
                        break;
                    case 3:
                        resul = num * num1;
                        resultado.setText(String.valueOf(resul));
                        break;
                    case 4:
                        resul = num / num1;
                        resultado.setText(String.valueOf(resul));
                        break;
                    default:
                        System.out.println("No valido");  // Opción no válida (por ejemplo, ningún botón presionado)
                }
            }
            // Maneja la excepción en caso de que el texto ingresado no sea un número entero válido
        } catch (NumberFormatException ae) {
            System.out.println("Error");  // Mensaje genérico de error (considera una ventana emergente o mensaje de usuario más informativo)
        }
    }

}
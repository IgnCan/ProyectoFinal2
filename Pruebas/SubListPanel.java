package Pruebas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SubListPanel extends JPanel {

    private SubListCallback subListCallback;
    private ArrayList<ArrayList<Object>> listaPrincipal;

    // Componentes para mostrar botones
    private JButton boton1;
    private JButton boton2;

    public SubListPanel(SubListCallback subListCallback, ArrayList<ArrayList<Object>> listaPrincipal) {
        this.subListCallback = subListCallback;
        this.listaPrincipal = listaPrincipal;

        setLayout(new FlowLayout());

        // Crear campo de texto para el identificador
        JTextField identificadorTextField = new JTextField(10);
        add(identificadorTextField);

        // Crear botón para agregar nueva sub-lista
        JButton agregarSubListaButton = new JButton("Agregar Sub-Lista");
        agregarSubListaButton.addActionListener(e -> subListCallback.mostrarSubLista(identificadorTextField.getText()));
        add(agregarSubListaButton);

        // Inicializar los botones (se muestran después)
        boton1 = new JButton("Botón 1");
        boton2 = new JButton("Botón 2");
    }

    public interface SubListCallback {
        void mostrarSubLista(String nuevoIdentificador);
    }

    // Método para mostrar todos los componentes de la sublista
    public void mostrarBotones(ArrayList<Object> subLista) {
        removeAll(); // Limpiar el panel antes de agregar componentes
        String identificador = (String) subLista.get(0);
        add(new JLabel("Identificador: " + identificador));

        // Iterar sobre los elementos de la sublista y agregarlos al panel
        for (int i = 1; i < subLista.size(); i++) {
            Object elemento = subLista.get(i);
            if (elemento instanceof JButton) {
                JButton boton = (JButton) elemento;
                add(boton);
            } else {
                // Puedes agregar lógica para otros tipos de elementos aquí
            }
        }

        // Volver a validar el layout
        revalidate();
        repaint();
    }
}

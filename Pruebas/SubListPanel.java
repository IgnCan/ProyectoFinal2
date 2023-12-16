package Pruebas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SubListPanel extends JPanel {

    public SubListPanel() {
        setLayout(new FlowLayout());
    }

    public void mostrarBotones(ArrayList<Object> subLista) {
        removeAll();
        String identificador = (String) subLista.get(0);
        add(new JLabel("Identificador: " + identificador));

        for (int i = 1; i < subLista.size(); i++) {
            Object elemento = subLista.get(i);
            if (elemento instanceof JButton) {
                JButton boton = (JButton) elemento;
                add(boton);
            }
        }

        revalidate();
        repaint();
    }
}




package Paneles;

import AsignacionDeHorarios.AsignacionFinal;
import Enums.Recorrido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelCompra extends JPanel implements PanelChangeListener{
    CardLayout cardLayout;
    JPanel cardPanel;
    public PanelCompra(CardLayout cardLayout, JPanel cardPanel, ArrayList<ArrayList<Object>> listaPrincipal){
        this.cardPanel=cardPanel;
        this.cardLayout=cardLayout;
        this.setBackground(Color.GREEN);

        JButton nextButton = new JButton("Siguiente");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avanPanel();
            }
        });

        add(new JLabel("Contenido del panel"));
        add(nextButton);

        JButton backButton = new JButton("atras");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retroPanel();
            }
        });
        add(backButton);
    }

    public interface SubListCallback {
        void mostrarSubLista(String nuevoIdentificador);
    }

    public void mostrarBotones(ArrayList<Object> subLista) {
        this.removeAll();

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

        JButton nextButton = new JButton("Siguiente");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avanPanel();
            }
        });

        add(new JLabel("Contenido del panel"));
        add(nextButton);

        JButton backButton = new JButton("atras");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retroPanel();
            }
        });
        add(backButton);



        revalidate();
        repaint();
    }

    @Override
    public void avanPanel() {
        cardLayout.next(cardPanel);
    }
    public void retroPanel() {
        cardLayout.previous(cardPanel);
    }
}

package Paneles;

import AsignacionDeHorarios.AsignacionFinal;
import AsignacionDeHorarios.Asignaciones;
import Enums.Recorrido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelHorario extends JPanel implements PanelChangeListener {
    CardLayout cardLayout;
    JPanel cardPanel;
    public Asignaciones asignaciones = new Asignaciones();

    //List<AsignacionFinal> asignacionesRecorrido1;
    List<AsignacionFinal> asignacionesRecorrido1;// = asignaciones.obtenerAAsignacionFinal(Recorrido.RECORRIDO5);

    AsignacionFinal asignacionFinal;

    public PanelHorario(CardLayout cardLayout, JPanel cardPanel){
        this.cardPanel=cardPanel;
        this.cardLayout=cardLayout;
        this.setBackground(Color.PINK);

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


    public void mostrarPanelHorario(Recorrido rec) {

        this.removeAll();
        this.setLayout(new GridLayout(0, 1));
        asignacionesRecorrido1=asignaciones.obtenerAAsignacionFinal(rec);
        for (AsignacionFinal asignacion : asignacionesRecorrido1) {
            JButton boton = new JButton(asignacion.toString());

            /**
             * Método para agregar acciones al presionar le jbutton del hora
             */

            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(asignacion.toString());
                    asignacionFinal=asignacion;

                }
            });
            this.add(boton);
        }
//        // Cambiar al segundo panel
//        this.show(mainPanel, "Panel2");

        // Repintar el frame para que los cambios sean visibles
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

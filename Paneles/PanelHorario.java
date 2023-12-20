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

    private APpanel3 APpanel3;
    CardLayout cardLayout;
    JPanel cardPanel;
    public Asignaciones asignaciones = new Asignaciones();
    List<AsignacionFinal> asignacionesRecorrido1;
    AsignacionFinal asignacionFinal;

    public PanelHorario(CardLayout cardLayout, JPanel cardPanel, APpanel3 callback){
        this.APpanel3 =callback;
        this.cardPanel=cardPanel;
        this.cardLayout=cardLayout;
        this.setBackground(Color.PINK);
    }


    public void mostrarPanelHorario(Recorrido rec) {

        this.removeAll();
        this.setLayout(new GridLayout(0, 1));
        this.asignacionesRecorrido1=asignaciones.obtenerAAsignacionFinal(rec);
        for (AsignacionFinal asignacion : asignacionesRecorrido1) {
            JButton boton = new JButton(asignacion.toString());

            /**
             * Método para agregar acciones al presionar el jbutton de la hora
             */

            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(asignacion.toString());
                    asignacionFinal=asignacion;
                    asignacionFinal.getTipoAsiento().getPresio();
                    APpanel3.onIdentificadorSelected(asignacionFinal);
                }
            });
            this.add(boton);
        }

        add(new JLabel("Contenido del panel"));

        JButton backButton = new JButton("atras");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retroPanel();
            }
        });
        add(backButton);
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

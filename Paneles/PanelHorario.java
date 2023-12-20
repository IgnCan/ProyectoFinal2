package Paneles;

import AsignacionDeHorarios.AsignacionFinal;
import AsignacionDeHorarios.Asignaciones;
import Enums.Recorrido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * crea un panel en el que se muestra 
 */
public class PanelHorario extends JPanel implements PanelChangeListener {

    private APpanel3 APpanel3;
    CardLayout cardLayout;
    JPanel cardPanel;
    public Asignaciones asignaciones = new Asignaciones();
    List<AsignacionFinal> asignacionesRecorrido1;
    AsignacionFinal asignacionFinal;

    private Image imagenFondo;

    private String rutaImagen = "Visuales/OIG.jpg";

    public PanelHorario(CardLayout cardLayout, JPanel cardPanel, APpanel3 callback){
        this.APpanel3 =callback;
        this.cardPanel=cardPanel;
        this.cardLayout=cardLayout;
        //this.setBackground(Color.PINK);
    }


    public void mostrarPanelHorario(Recorrido rec) {

        this.removeAll();
        this.setLayout(new GridLayout(0, 1));
        this.asignacionesRecorrido1=asignaciones.obtenerAAsignacionFinal(rec);

        this.imagenFondo = new ImageIcon(rutaImagen).getImage();

        for (AsignacionFinal asignacion : asignacionesRecorrido1) {
            JButton boton = new JButton(asignacion.toString());

            /**
             * Método para agregar acciones al presionar el jbutton de la hora
             */

            // Configurar la transparencia del color de fondo
            Color fondoTransparente = new Color(255, 255, 255, 150); // R, G, B, Alfa
            boton.setBackground(fondoTransparente);
            boton.setRolloverEnabled(false);
            boton.setForeground(Color.BLACK);

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

        Color fondoTransparente = new Color(255, 255, 255, 150); // R, G, B, Alfa
        backButton.setBackground(fondoTransparente);
        backButton.setRolloverEnabled(false);
        backButton.setForeground(Color.BLACK);
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

package Paneles;

import AsignacionDeHorarios.AsignacionFinal;
import AsignacionDeHorarios.Asignaciones;
import Enums.Recorrido;
import Interfaces.APpanel3;
import Interfaces.PanelChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Crea un panel en el que se muestra los horarios disponibles de acuerdo al recorrido seleccionado.
 */
public class PanelHorario extends JPanel implements PanelChangeListener {

    private Interfaces.APpanel3 APpanel3;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private Asignaciones asignaciones = new Asignaciones();
    private List<AsignacionFinal> asignacionesRecorrido1;
    AsignacionFinal asignacionFinal;

    private Image imagenFondo;
    private String rutaImagen = "Visuales/OIG.jpg";

    /**
     * Constructor, define cardLayout, cardPanel y callback los que son utilizados en otros métodos de la clase.
     *
     * @param cardLayout CardLayout usado para poder moverse entre sus JPaneles
     * @param cardPanel JPanel
     * @param callback APpanel llama a la interfaz para moverse al panel siguiente cuando sea necesario
     */

    public PanelHorario(CardLayout cardLayout, JPanel cardPanel, APpanel3 callback){
        this.APpanel3 =callback;
        this.cardPanel=cardPanel;
        this.cardLayout=cardLayout;
    }

    /**
     *  Muestra los botones co los horarios.
     * @param rec Recorrio elegido por el usuario
     */
    public void mostrarPanelHorario(Recorrido rec) {

        this.removeAll();
        this.setLayout(new GridLayout(0, 1));
        this.asignacionesRecorrido1=asignaciones.obtenerAAsignacionFinal(rec);

        this.imagenFondo = new ImageIcon(rutaImagen).getImage();

        for (AsignacionFinal asignacion : asignacionesRecorrido1) {
            JButton boton = new JButton(asignacion.getDatosHorario());

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
                    APpanel3.pasarPanelCompra(asignacionFinal);
                }
            });
            this.add(boton);
        }
        Color fondoTransparente = new Color(255, 255, 255, 150); // R, G, B, Alfa

        JLabel jLhorario = new JLabel("Seleccione horario para recorrido : " + rec.getRecorrido());
        jLhorario.setBackground(fondoTransparente);

        // Configuración adicional del JLabel
        jLhorario.setOpaque(true); // Asegurar que el JLabel sea opaco para mostrar el color de fondo
        jLhorario.setForeground(Color.BLACK);
        add(jLhorario);

        JButton backButton = new JButton("atras");


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

        // Repintar el frame para que los cambios sean visibles
        revalidate();
        repaint();
    }

    /**
     * Permite avanzar un panel
     */
    @Override
    public void avanPanel() {
        cardLayout.next(cardPanel);
    }

    /**
     * Permite retroceder un panel
     */
    public void retroPanel() {
        cardLayout.previous(cardPanel);
    }

    /**
     * modifica el fondo de panel con una imagen.
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

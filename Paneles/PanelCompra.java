package Paneles;

import AsignacionDeHorarios.AsignacionFinal;
import Botones.Asientos;
import Botones.Reservador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Crea un panel que muestra los botones de Asientos adémas de los satos del recorrido, un botón para volver atrás y cambiar de recorrido y otro para realizar la reserva.
 */
public class PanelCompra extends JPanel implements PanelChangeListener {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    private Image imagenFondo;

    private String rutaImagen = "Visuales/OIG.jpg";

    /**
     * Método constructor.
     *
     * @param cardLayout CardLayout
     * @param cardPanel  JPanel
     */
    public PanelCompra(CardLayout cardLayout, JPanel cardPanel) {
        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        //this.setBackground(ImageIcon());
    }

    /**
     * Muestra los botones de los asientos dependiendo del tipo de bus seleccionado y los datos relacionados al recorrido y agrega los botones para realizar la reserva y volver al paso anterior.
     * @param subLista ArrayList con los datos de los asientos dependiendo del tipo de bus.
     * @param asignacionFinal AsignacionFinal datos del recorrido.
     */
    public void mostrarBotones(ArrayList<Object> subLista, AsignacionFinal asignacionFinal) {
        this.removeAll();
        this.setLayout(new GridLayout(3,1));

        this.imagenFondo = new ImageIcon(rutaImagen).getImage();

        JPanel boleto=new JPanel(new FlowLayout(FlowLayout.CENTER));
        boleto.setBackground(new Color(0, 0, 0, 0));

        //boleto.setLayout(new GridLayout(0,1));
        boleto.add(new JLabel("Recorrido: "+asignacionFinal.getRecorrido().getRecorrido()));
        boleto.add(new JLabel("Horario: "+asignacionFinal.getHorario().getHora()));
        boleto.add(new JLabel("Tipo de Asiento: "+asignacionFinal.getTipoAsiento().getNombre()));
        boleto.add(new JLabel("Precio del Boleto: " + asignacionFinal.getPresioTotal()));


        JPanel p=new JPanel();

        if (Objects.equals(asignacionFinal.getTipoBus().toString(), "UNO_PISO")) {
            p.setLayout(new BorderLayout());
            p.setOpaque(false);
            p.setLayout(new GridLayout(10, 4, 2, 10));
            int c=0;
            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j <= 2; j++) {
                    c = c + 1;
                    Object elemento = subLista.get(c);
                    if (elemento instanceof Asientos) {
                        Asientos boton = (Asientos) elemento;
                        p.add(boton);
                    }

                }
                for (int j = 3; j <= 3; j++) {
                    JLabel M = new JLabel("");
                    p.add(M);
                }
                for (int j = 4; j <= 5; j++) {
                    c = c + 1;
                    Object elemento = subLista.get(c);
                    if (elemento instanceof Asientos) {
                        Asientos boton = (Asientos) elemento;
                        p.add(boton);
                    }
                }
            }

        } else if (Objects.equals(asignacionFinal.getTipoBus().toString(), "DOS_PISOS")) {
            JPanel cc = new JPanel();
            JPanel q = new JPanel();
            cc.setOpaque(false);
            q.setOpaque(false);
            cc.setLayout(new GridLayout(10, 4, 2, 10));
            int c = 0;

            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j <= 2; j++) {
                    c = c + 1;
                    Object elemento = subLista.get(c);
                    if (elemento instanceof Asientos) {
                        Asientos boton = (Asientos) elemento;
                        cc.add(boton);
                    }

                }
                for (int j = 3; j <= 3; j++) {
                    JLabel M = new JLabel("");
                    cc.add(M);
                }
                for (int j = 4; j <= 5; j++) {
                    c = c + 1;
                    Object elemento = subLista.get(c);
                    if (elemento instanceof Asientos) {
                        Asientos boton = (Asientos) elemento;
                        cc.add(boton);
                    }
                }
            }

            q.setLayout(new GridLayout(10, 5, 2, 10));
            int a = 40;

            for (int b = 1; b <= 10; b++) {
                for (int j = 1; j <= 2; j++) {
                    a = a + 1;
                    Object elemento = subLista.get(a);
                    if (elemento instanceof Asientos) {
                        Asientos boton = (Asientos) elemento;
                        q.add(boton);
                    }

                }
                for (int j = 3; j <= 3; j++) {
                    JLabel M = new JLabel("");
                    q.add(M);
                }
                for (int j = 4; j <= 5; j++) {
                    a = a + 1;
                    Object elemento = subLista.get(a);
                    if (elemento instanceof Asientos) {
                        Asientos boton = (Asientos) elemento;
                        q.add(boton);
                    }
                }
                cc.setBackground(new Color(0, 0, 0, 0));
                q.setBackground(new Color(0, 0, 0, 0));
                p.setBackground(new Color(0, 0, 0, 0));

                p.add(cc);
                p.add(q);

            }
        }

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelInferior.setBackground(new Color(0, 0, 0, 0));


        JButton backButton = new JButton("atras");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retroPanel();
            }
        });
        panelInferior.add(backButton);

        panelInferior.add(new Reservador(subLista, asignacionFinal));

        setLayout(new BorderLayout());

        // Configurar un BoxLayout para el panel del sur
        //panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.Y_AXIS));

        // Configurar el tamaño preferido para el panel del norte
        p.setPreferredSize(new Dimension(getWidth(), getHeight() / 2));

        add(boleto, BorderLayout.NORTH);
        add(p, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);


        revalidate();
        repaint();
    }


    /**
     * avanza un panel.
     */
    @Override
    public void avanPanel () {
        cardLayout.next(cardPanel);
    }

    /**
     * retrocede un panel.
     */
    public void retroPanel () {
        cardLayout.previous(cardPanel);
    }

    /**
     * Modifica el fondo del panel con una imagen.
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
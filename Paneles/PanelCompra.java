package Paneles;

import AsignacionDeHorarios.AsignacionFinal;
import Botones.Asientos;
import Enums.Recorrido;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class PanelCompra extends JPanel implements PanelChangeListener{
    CardLayout cardLayout;
    JPanel cardPanel;
    public PanelCompra(CardLayout cardLayout, JPanel cardPanel){
        this.cardPanel=cardPanel;
        this.cardLayout=cardLayout;
        //this.setBackground(ImageIcon());
    }
    public void mostrarBotones(ArrayList<Object> subLista, AsignacionFinal asignacionFinal) {
        this.removeAll();
        this.setLayout(new GridLayout(3,1));


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

                p.add(cc);
                p.add(q);

            }
        }

        JPanel r=new JPanel();

        String identificador = (String) subLista.get(0);
        JLabel datos = new JLabel("Identificador: " + identificador);
        r.add(datos);

        JButton backButton = new JButton("atras");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retroPanel();
            }
        });
        r.add(backButton);

        r.add(new Reservador(subLista, asignacionFinal));

        setLayout(new BorderLayout());

        // Configurar un BoxLayout para el panel del sur
        r.setLayout(new BoxLayout(r, BoxLayout.Y_AXIS));

        // Configurar el tamaño preferido para el panel del norte
        p.setPreferredSize(new Dimension(getWidth(), getHeight() / 2));


        add(p, BorderLayout.NORTH);
        add(r, BorderLayout.SOUTH);


        revalidate();
        repaint();
    }


    /**
     * Este boton finaliza la reserva de los pasajes
     */

    public class Reservador extends JButton {
        public Reservador(ArrayList<Object> subLista, AsignacionFinal asignacionFinal) {
            setText("Reservar");
            int precioPorBoleto = asignacionFinal.getRecorrido().getPresio() + asignacionFinal.getTipoBus().getPresio() + asignacionFinal.getTipoAsiento().getPresio();
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int precioTotal = 0;
                    for (Object elemento : subLista) {
                        if (elemento instanceof Asientos) {
                            Asientos bot = (Asientos) elemento;
                            if (bot.getBackground() == Color.GREEN) {
                                bot.Desactivacion();
                                precioTotal = precioTotal + precioPorBoleto;
                            }

                        } else if (elemento instanceof String) {
                            System.out.println(elemento);
                        }

                    }
                    System.out.println("El precio total de la compra es: $" + precioTotal);

                }
            });

        }
    }

    @Override
    public void avanPanel () {
        cardLayout.next(cardPanel);
    }
    public void retroPanel () {
        cardLayout.previous(cardPanel);
    }

}
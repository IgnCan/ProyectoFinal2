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
    public void mostrarBotones(ArrayList<Object> subLista, AsignacionFinal asignacionFinal) {
        this.removeAll();
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
            } else if (Objects.equals(asignacionFinal.getTipoBus().toString(), "DOS_PISOS")){
            JPanel cc=new JPanel();
            JPanel q=new JPanel();
            cc.setOpaque(false);
            q.setOpaque(false);
            cc.setLayout(new GridLayout(10, 4, 2, 10));
            int c=0;
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

        String identificador = (String) subLista.get(0);
        add(new JLabel("Identificador: " + identificador));

        add(p);

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


        add(new Reservador(subLista, asignacionFinal));
        revalidate();
        repaint();
    }


            /**
             * Este boton finaliza la reserva de los pasajes
             */

            public class Reservador extends JButton {
                public Reservador(ArrayList<Object> subLista, AsignacionFinal asignacionFinal) {
                    setText("Reservar");
                    int precioPorBoleto = asignacionFinal.getTipoBus().getPresio() + asignacionFinal.getTipoBus().getPresio() + asignacionFinal.getTipoAsiento().getPresio();
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
                                System.out.println("El precio total de la compra es: $" + precioTotal);
                            }

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
package Paneles;

import AsignacionDeHorarios.AsignacionFinal;
import Botones.Asientos;
import Enums.Recorrido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelCompra extends JPanel implements PanelChangeListener{
    CardLayout cardLayout;
    JPanel cardPanel;
    public PanelCompra(CardLayout cardLayout, JPanel cardPanel){
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

    public void mostrarBotones(ArrayList<Object> subLista, AsignacionFinal asignacionFinal) {
        this.removeAll();
        JPanel p=new JPanel();
        if("Un piso"==subLista.get(0).toString() ){
            p.setLayout(new GridLayout(10, 5, 10, 10));
            int c=0;
            if(c<=40) {
                for (int i = 1; i <= 10; i++) {
                    for (int j = 1; j <= 2; j++) {
                        c = c + 1;
                        Object elemento = subLista.get(c);
                        if (elemento instanceof Asientos) {
                            Asientos boton = (Asientos) elemento;
                            p.add(boton);
                        }
                        ;
                    }
                    for (int j = 3; j <= 3; j++) {
                        JLabel M = new JLabel("");
                        p.add(M);
                    }
                    for (int j = 4; j <= 5; j++) {
                        c = c +1;
                        Object elemento = subLista.get(c);
                        if (elemento instanceof Asientos) {
                            Asientos boton = (Asientos) elemento;
                            p.add(boton);
                        }
                    }
            }
        }}
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

    public class Reservador extends JButton{
        public Reservador(ArrayList<Object> subLista, AsignacionFinal asignacionFinal){
            setText("Reservar");
            int precioPorBoleto = asignacionFinal.getTipoBus().getPresio()+asignacionFinal.getTipoBus().getPresio()+asignacionFinal.getTipoAsiento().getPresio();
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int precioTotal=0;
                    for (Object elemento : subLista) {
                        if(elemento instanceof Asientos){
                            Asientos bot = (Asientos) elemento;
                            if (bot.getBackground() == Color.GREEN) {
                                bot.Desactivacion();
                                precioTotal=precioTotal+precioPorBoleto;
                            }
                        }else if(elemento instanceof String){
                            System.out.println(elemento);
                        }
                    }
                    System.out.println("El precio total de la compra es: $" + precioTotal);
                }
            });

        }
    }

    @Override
    public void avanPanel() {
        cardLayout.next(cardPanel);
    }
    public void retroPanel() {
        cardLayout.previous(cardPanel);
    }
}

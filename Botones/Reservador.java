package Botones;

import AsignacionDeHorarios.AsignacionFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Este boton finaliza la reserva de los pasajes, al ser presionado llamara a un panel emergente que pedira confirmar si has recibido el
 * pago por la reserva mostrando el valor total de la compra, si se confirma el pago efectua la reserva, si no, la cancela
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
                            precioTotal = precioTotal + precioPorBoleto;
                        }

                    } else if (elemento instanceof String) {
                        System.out.println(elemento);
                    }
                }



                int opcion = JOptionPane.showConfirmDialog(null, "Precio total: $" + precioTotal, "¿Has recibido el pago por la reserva?", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {

                    for (Object elemento : subLista) {
                        if (elemento instanceof Asientos) {
                            Asientos bot = (Asientos) elemento;
                            if (bot.getBackground() == Color.GREEN) {
                                bot.Desactivacion();
                                //precioTotal = precioTotal + precioPorBoleto;
                            }

                        } else if (elemento instanceof String) {
                            System.out.println(elemento);
                        }

                    }
                    System.out.println("El precio total de la compra es: $" + precioTotal);
                } else {
                    // Aquí colocas el código que se ejecutará si el usuario selecciona "No"
                    System.out.println("Reserva cancelada");
                }

            }
        });

    }
}
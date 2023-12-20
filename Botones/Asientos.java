package Botones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Extencion de JButton que se usara como los asientos del bus
 */

public class Asientos extends JButton {

    /**
     * Constructor, crea un boton que es de color blanco, al presionarlo se volverá verde y viceversa
     * @param text es el String nombre del boton.
     */
    public Asientos(String text) {
        super(text);
        setBackground(Color.WHITE);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(getBackground() == Color.WHITE ? Color.GREEN : Color.WHITE);
            }
        });
    }

    /**
     * Este método se encarga de desactivar el botón, y volverlo de color rojo simulando que el asiento esta reservado.
     */
    public void Desactivacion(){
        setEnabled(false);
        setBackground(Color.RED);
    }
}
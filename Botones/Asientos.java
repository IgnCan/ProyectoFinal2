package Botones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Asientos extends JButton {
    /**
     * si es 1 desactiva el boton y lo deja en rojo
     */
    int apagado=0;
    public Asientos(String text) {
        super(text);
        setBackground(Color.WHITE);
        if (apagado==1){
            setBackground(Color.RED);
            setEnabled(false);
        }
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(getBackground() == Color.WHITE ? Color.GREEN : Color.WHITE);
            }
        });
    }

    /**
     * Este metodo se encarga de desactivar el boton, y modificar el valor de apagado a 1, esto permite mantener
     * el boton desactivado en compras multiples y guardar su estado al cambiar de bus, recorrido, etc.
     */
    public void Desactivacion(){
        this.apagado=1;
        setEnabled(false);
        setBackground(Color.RED);
    }
}
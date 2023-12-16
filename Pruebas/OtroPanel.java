package Pruebas;

import Paneles.IdentificadorCallback;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OtroPanel extends JPanel {

    private IdentificadorCallback identificadorCallback;

    public OtroPanel(IdentificadorCallback callback) {
        identificadorCallback = callback;

        JButton botonEnviarIdentificador = new JButton("Enviar Identificador");
        botonEnviarIdentificador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Puedes obtener el identificador de alguna manera (puede ser un JTextField, por ejemplo)
                String identificador = "IdentificadorDesdeOtroPanel";
                //identificadorCallback.onIdentificadorSelected(identificador);
            }
        });

        add(botonEnviarIdentificador);
    }
}

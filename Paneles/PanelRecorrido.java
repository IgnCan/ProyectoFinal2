package Paneles;

import Enums.Recorrido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRecorrido extends JPanel implements PanelChangeListener {
    private Recorrido rec;
    CardLayout cardLayout;
    JPanel cardPanel;
    public PanelRecorrido(CardLayout cardLayout, JPanel cardPanel){
        this.cardPanel=cardPanel;
        this.cardLayout=cardLayout;
        this.setBackground(Color.RED);
        this.add(new JLabel("Seleccion de Recorrido"));

        Recorrido[] recorridos = Recorrido.values();
        this.setLayout(new GridLayout(0, 1));
        for (Recorrido reco : recorridos) {
            JButton button = new JButton(reco.getRecorrido());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Impresion De prueba
                    System.out.println(reco.getRecorrido());
                    rec=reco;
                    avanPanel();
                }
            });
            this.add(button);
        }
    }

    @Override
    public void avanPanel() {
        cardLayout.next(cardPanel);
    }

    @Override
    public void retroPanel() {

    }
}

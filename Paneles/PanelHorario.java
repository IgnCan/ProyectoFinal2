package Paneles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelHorario extends JPanel implements PanelChangeListener {
    CardLayout cardLayout;
    JPanel cardPanel;
    public PanelHorario(CardLayout cardLayout, JPanel cardPanel){
        this.cardPanel=cardPanel;
        this.cardLayout=cardLayout;
        this.setBackground(Color.PINK);

        JButton nextButton = new JButton("Siguiente");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarPanel();
            }
        });

        add(new JLabel("Contenido del panel"));
        add(nextButton);

    }
    @Override
    public void cambiarPanel() {
        cardLayout.next(cardPanel);
    }
}

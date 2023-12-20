package Paneles;

import Enums.Recorrido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Crea un Jpanel con los botones para seleccionr el recorrido.
 */
public class PanelRecorrido extends JPanel implements PanelChangeListener {

    private APpanel2 clickListener;
    private Recorrido rec;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    private Image imagenFondo;
    private String rutaImagen = "Visuales/OIG.jpg";

    /**
     * Crea los botones con los recorridos y los agrega al JPanel.
     * @param cardLayout CardLayout
     * @param cardPanel JPanel
     * @param clickListener APpanel2
     */
    public PanelRecorrido(CardLayout cardLayout, JPanel cardPanel, APpanel2 clickListener){
        this.clickListener=clickListener;
        this.cardPanel=cardPanel;
        this.cardLayout=cardLayout;
        this.imagenFondo = new ImageIcon(rutaImagen).getImage();
        //setBackground(Color.RED);


        Recorrido[] recorridos = Recorrido.values();

        setLayout(new GridLayout(0, 1));

        JLabel seleccion = new JLabel("Seleccion de Recorrido:");
        //seleccion.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(seleccion);

        for (Recorrido reco : recorridos) {
            JButton button = new JButton(reco.getRecorrido());

            // Configurar la transparencia del color de fondo
            Color fondoTransparente = new Color(255, 255, 255, 150); // R, G, B, Alfa
            button.setBackground(fondoTransparente);
            button.setRolloverEnabled(false);
            button.setForeground(Color.BLACK);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Impresion De prueba
                    System.out.println(reco.getRecorrido());
                    rec=reco;
                    clickListener.pasarPanelHorario(rec);
                    //avanPanel();
                }
            });
            add(button);
        }
    }

    /**
     * avanza un panel
     */
    @Override
    public void avanPanel() {
        cardLayout.next(cardPanel);
    }

    /**
     * retocede un panel
     */
    @Override
    public void retroPanel() {
    }

    /**
     * getter de rec
     * @return  Recorrido rec
     */
    public Recorrido getRec() {
        return rec;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

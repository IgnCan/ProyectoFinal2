import Enums.Recorrido;
import Paneles.APpanel2;
import Paneles.PanelCompra;
import Paneles.PanelHorario;
import Paneles.PanelRecorrido;

import javax.swing.*;
import java.awt.*;

public class Frame  extends JFrame implements APpanel2 {




    CardLayout cardLayout = new CardLayout();
    JPanel cardPanel = new JPanel(cardLayout);

    PanelRecorrido panelRecorrido = new PanelRecorrido(cardLayout,cardPanel,this);
    PanelHorario panelHorario = new PanelHorario(cardLayout,cardPanel);
    PanelCompra panelCompra = new PanelCompra(cardLayout,cardPanel);

    public Frame(){



        this.setSize(1000, 800);//Ancho y largo respectivamente
        setBackground(Color.CYAN);//Color de fondo
        setTitle("Coso de buses"); //Titulo
        setLocationRelativeTo(null); //Centra el programa al abrirlo
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Cierra el programa al cerrar la ventana
        setLayout(new BorderLayout());//Permite organizar los JPanel

        cardPanel.setLayout(cardLayout);

        cardPanel.add(panelRecorrido,"Panel1");
        cardPanel.add(panelHorario, "Panel2");
        cardPanel.add(panelCompra, "Panel3");

        this.add(cardPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void pasarPanelHorario(Recorrido rec) {
        panelHorario.mostrarPanelHorario(rec);
        cardLayout.next(cardPanel);
    }


}

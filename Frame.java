import Paneles.PanelCompra;
import Paneles.PanelHorario;
import Paneles.PanelRecorrido;

import javax.swing.*;
import java.awt.*;

public class Frame  extends JFrame {

    PanelRecorrido panelRecorrido;
    PanelHorario panelHorario;
    PanelCompra panelCompra;

    public Frame(){

        this.setSize(1000, 800);//Ancho y largo respectivamente
        setBackground(Color.CYAN);//Color de fondo
        setTitle("Coso de buses"); //Titulo
        setLocationRelativeTo(null); //Centra el programa al abrirlo
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Cierra el programa al cerrar la ventana
        setLayout(new BorderLayout());//Permite organizar los JPanel

    }


}

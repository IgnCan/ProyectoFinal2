import Enums.Recorrido;
import Paneles.*;
import Pruebas.IdentificadorCallback;
import Pruebas.SubListPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Frame  extends JFrame implements APpanel2, IdentificadorCallback {
    private ArrayList<ArrayList<Object>> listaPrincipal;

    CardLayout cardLayout = new CardLayout();
    JPanel cardPanel = new JPanel(cardLayout);

    PanelRecorrido panelRecorrido = new PanelRecorrido(cardLayout,cardPanel,this);
    PanelHorario panelHorario = new PanelHorario(cardLayout,cardPanel, this );
    Paneles.PanelCompra panelCompra = new Paneles.PanelCompra(cardLayout,cardPanel, this.listaPrincipal);

    public Frame(){

        listaPrincipal = new ArrayList<>();

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


    private void agregarNuevaSubLista(String nuevoIdentificador) {
        boolean existeIdentificador = existeIdentificador(nuevoIdentificador);

        if (!existeIdentificador) {
            ArrayList<Object> nuevaSubLista = new ArrayList<>();
            nuevaSubLista.add(nuevoIdentificador);

            JButton boton1 = new JButton("Botón 1");
            JButton boton2 = new JButton("Botón 2");
            nuevaSubLista.add(boton1);
            nuevaSubLista.add(boton2);

            listaPrincipal.add(nuevaSubLista);

            System.out.println("Nueva sub-lista creada con identificador " + nuevoIdentificador);
            mostrarBotonesDeSubLista(nuevoIdentificador);
            cardLayout.next(cardPanel);
        } else {
            System.out.println("Ya existe una sub-lista con el identificador " + nuevoIdentificador);
            mostrarBotonesDeSubLista(nuevoIdentificador);
            cardLayout.next(cardPanel);
        }
    }

    private boolean mostrarBotonesDeSubLista(String identificador) {
        for (ArrayList<Object> subLista : listaPrincipal) {
            String subListaIdentificador = (String) subLista.get(0);
            if (subListaIdentificador.equals(identificador)) {
                panelCompra.mostrarBotones(subLista);
                return true;
            }
        }
        return false;
    }

    private boolean existeIdentificador(String identificador) {
        for (ArrayList<Object> subLista : listaPrincipal) {
            String subListaIdentificador = (String) subLista.get(0);
            if (subListaIdentificador.equals(identificador)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onIdentificadorSelected(String identificador) {
        agregarNuevaSubLista(identificador);
        // Cambiar a la tarjeta del panel de mostrar botones después de agregar una nueva sublista
        cardLayout.show(cardPanel, "panel3");
    }


}

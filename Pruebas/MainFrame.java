package Pruebas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private ArrayList<ArrayList<Object>> listaPrincipal;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public MainFrame() {
        listaPrincipal = new ArrayList<>();

        // Configurar el JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Agregar Sub-Lista");
        setSize(400, 300);

        // Crear el panel con CardLayout
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Crear las tarjetas
        String nuevaSubListaCard = "NuevaSubLista";
        String mostrarBotonesCard = "MostrarBotones";

        SubListPanel nuevaSubListaPanel = new SubListPanel(this::agregarNuevaSubLista, listaPrincipal);
        cardPanel.add(nuevaSubListaPanel, nuevaSubListaCard);

        SubListPanel mostrarBotonesPanel = new SubListPanel(this::mostrarBotonesDeSubLista, listaPrincipal);
        cardPanel.add(mostrarBotonesPanel, mostrarBotonesCard);

        // Configurar el CardLayout
        cardLayout.show(cardPanel, nuevaSubListaCard);

        // Agregar el panel al JFrame
        add(cardPanel);

        // Mostrar el JFrame
        setVisible(true);
    }

    private void agregarNuevaSubLista(String nuevoIdentificador) {
        boolean existeIdentificador = existeIdentificador(nuevoIdentificador);

        // Si el identificador no existe, o si existe pero ya se mostró, crear una nueva sub-lista
        if (!existeIdentificador || mostrarBotonesDeSubLista(nuevoIdentificador)) {
            // Crear una nueva sub-lista
            ArrayList<Object> nuevaSubLista = new ArrayList<>();
            nuevaSubLista.add(nuevoIdentificador);

            // Agregar dos JButton como elementos a la sublista
            JButton boton1 = new JButton("Botón 1");
            JButton boton2 = new JButton("Botón 2");
            nuevaSubLista.add(boton1);
            nuevaSubLista.add(boton2);

            // Puedes agregar más elementos a la sublista si es necesario
            listaPrincipal.add(nuevaSubLista);

            JOptionPane.showMessageDialog(this, "Nueva sub-lista creada con identificador " + nuevoIdentificador);

            // Mostrar los botones de la nueva sublista
            mostrarBotonesDeSubLista(nuevoIdentificador);

            // Cambiar a la tarjeta de mostrar botones
            //cardLayout.show(cardPanel, "MostrarBotones");
        } else {
            JOptionPane.showMessageDialog(this, "Ya existe una sub-lista con el identificador " + nuevoIdentificador);
            mostrarBotonesDeSubLista(nuevoIdentificador);
        }
    }

    private boolean mostrarBotonesDeSubLista(String identificador) {
        for (ArrayList<Object> subLista : listaPrincipal) {
            String subListaIdentificador = (String) subLista.get(0);
            if (subListaIdentificador.equals(identificador)) {
                // Mostrar los botones de la sublista
                SubListPanel mostrarBotonesPanel = (SubListPanel) cardPanel.getComponent(1);
                mostrarBotonesPanel.mostrarBotones(subLista);

                return true;
            }
        }
        return false;
    }

    private boolean existeIdentificador(String identificador) {
        for (ArrayList<Object> subLista : listaPrincipal) {
            String subListaIdentificador = (String) subLista.get(0); // Suponiendo que el identificador está en la posición 0
            if (subListaIdentificador.equals(identificador)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}

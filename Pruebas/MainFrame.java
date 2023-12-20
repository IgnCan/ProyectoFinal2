package Pruebas;

import AsignacionDeHorarios.AsignacionFinal;
import Paneles.IdentificadorCallback;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame implements IdentificadorCallback {

    private ArrayList<ArrayList<Object>> listaPrincipal;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private SubListPanel subListPanel;
    private OtroPanel otroPanel;

    public MainFrame() {
        listaPrincipal = new ArrayList<>();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Agregar Sub-Lista");
        setSize(400, 300);

        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Crear un solo SubListPanel y reutilizarlo en diferentes tarjetas
        subListPanel = new SubListPanel();

        cardPanel.add(subListPanel, "NuevaSubLista");
        //cardPanel.add(subListPanel, "MostrarBotones");

        // Crear un solo OtroPanel y reutilizarlo en diferentes tarjetas
        otroPanel = new OtroPanel(this);
        cardPanel.add(otroPanel, "OtroPanel");

        cardLayout.show(cardPanel, "OtroPanel");

        add(cardPanel);

        setVisible(true);

    }

    private void agregarNuevaSubLista(String nuevoIdentificador) {
        boolean existeIdentificador = existeIdentificador(nuevoIdentificador);

        if (!existeIdentificador || mostrarBotonesDeSubLista(nuevoIdentificador)) {
            ArrayList<Object> nuevaSubLista = new ArrayList<>();
            nuevaSubLista.add(nuevoIdentificador);

            JButton boton1 = new JButton("Botón 1");
            JButton boton2 = new JButton("Botón 2");
            nuevaSubLista.add(boton1);
            nuevaSubLista.add(boton2);

            listaPrincipal.add(nuevaSubLista);

            JOptionPane.showMessageDialog(this, "Nueva sub-lista creada con identificador " + nuevoIdentificador);

            mostrarBotonesDeSubLista(nuevoIdentificador);
            cardLayout.show(cardPanel, "NuevaSubLista");
        } else {
            JOptionPane.showMessageDialog(this, "Ya existe una sub-lista con el identificador " + nuevoIdentificador);
        }
    }

    private boolean mostrarBotonesDeSubLista(String identificador) {
        for (ArrayList<Object> subLista : listaPrincipal) {
            String subListaIdentificador = (String) subLista.get(0);
            if (subListaIdentificador.equals(identificador)) {
                subListPanel.mostrarBotones(subLista);
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
    public void onIdentificadorSelected(AsignacionFinal asignacionFinal) {
        agregarNuevaSubLista(asignacionFinal.toString());
        // Cambiar a la tarjeta del panel de mostrar botones después de agregar una nueva sublista
        cardLayout.show(cardPanel, "NuevaSubLista");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}



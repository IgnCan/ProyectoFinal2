import AsignacionDeHorarios.AsignacionFinal;
import Botones.Asientos;
import Enums.Recorrido;
import Enums.TipoAsiento;
import Enums.TipoBus;
import Paneles.*;
import Paneles.IdentificadorCallback;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Frame  extends JFrame implements APpanel2, IdentificadorCallback {
    private ArrayList<ArrayList<Object>> listaPrincipal;

    CardLayout cardLayout = new CardLayout();
    JPanel cardPanel = new JPanel(cardLayout);

    PanelRecorrido panelRecorrido = new PanelRecorrido(cardLayout,cardPanel,this);
    PanelHorario panelHorario = new PanelHorario(cardLayout,cardPanel, this );
    Paneles.PanelCompra panelCompra = new Paneles.PanelCompra(cardLayout,cardPanel);

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

    @Override
    public void onIdentificadorSelected(AsignacionFinal asignacionFinal) {
        agregarNuevaSubLista(asignacionFinal);
        // Cambiar a la tarjeta del panel de mostrar botones después de agregar una nueva sublista
        cardLayout.show(cardPanel, "panel3");
    }



    private void agregarNuevaSubLista(AsignacionFinal asignacionFinal) {
        TipoBus tipoBus = asignacionFinal.getTipoBus();
        
        boolean existeIdentificador = existeIdentificador(asignacionFinal.toString());

        if (!existeIdentificador) {
            ArrayList<Object> nuevaSubLista = new ArrayList<>();
            nuevaSubLista.add(asignacionFinal.toString());

            if(tipoBus == TipoBus.UNO_PISO){
                for (int i = 1;i<=40;i=i+1){
                    Asientos boton1 = new Asientos("Asiento "+i);
                    nuevaSubLista.add(boton1);
                }
            } else{
                for (int i = 1;i<=80;i=i+1){
                    Asientos boton1 = new Asientos("Asiento "+i);
                    nuevaSubLista.add(boton1);
                }
            }




//            Asientos boton2 = new Asientos("Botón 2");
//
//            nuevaSubLista.add(boton2);

            listaPrincipal.add(nuevaSubLista);

            System.out.println("Nueva sub-lista creada con identificador " + asignacionFinal.toString());
            mostrarBotonesDeSubLista(asignacionFinal.toString());
            cardLayout.next(cardPanel);

        } else {
            System.out.println("Ya existe una sub-lista con el identificador " + asignacionFinal.toString());
            mostrarBotonesDeSubLista(asignacionFinal.toString());
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



}

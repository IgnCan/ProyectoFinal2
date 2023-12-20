import AsignacionDeHorarios.AsignacionFinal;
import Botones.Asientos;
import Enums.Recorrido;
import Enums.TipoBus;
import Interfaces.APpanel2;
import Paneles.*;
import Interfaces.APpanel3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Crea el JFrame es el gestor principal este crea e muestra los jpanles dependiendo del paso del momento de compra en el que te encuentras.
 */
public class Frame  extends JFrame implements APpanel2, APpanel3 {
    private ArrayList<ArrayList<Object>> listaPrincipal;

    CardLayout cardLayout = new CardLayout();
    JPanel cardPanel = new JPanel(cardLayout);
    PanelRecorrido panelRecorrido = new PanelRecorrido(cardLayout,cardPanel,this);
    PanelHorario panelHorario = new PanelHorario(cardLayout,cardPanel, this );
    PanelCompra panelCompra = new PanelCompra(cardLayout,cardPanel);

    /**
     * Metodo constructor, agrega paneles y modifica cualidades de JFrame.
     */
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

    /**
     *Muestra panelHorario una vez recibido el recorrido desde panelRecorrido
     * @param rec recorrido
     */
    public void pasarPanelHorario(Recorrido rec) {
        panelHorario.mostrarPanelHorario(rec);
        cardLayout.next(cardPanel);
    }

    /**
     * recibe la asignacionFinal desde panelHorario y ejecuta los metodos para crear la lista o llamarla usando el string identificador.
     * @param asignacionFinal
     */
    @Override
    public void pasarPanelCompra(AsignacionFinal asignacionFinal) {
        agregarNuevaSubLista(asignacionFinal);
        // Cambiar a la tarjeta del panel de mostrar botones después de agregar una nueva sublista
        cardLayout.show(cardPanel, "panel3");
    }

    /**
     * Crea una nueva sublista dependiendo de si ya existe una asociada con el recorrido selecionado y agraga los botones de los asientos.
     * @param asignacionFinal AsignacioGinal Arraylist con los datos del recorrido.
     */
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
            } else if (tipoBus == TipoBus.DOS_PISOS) {
                for (int i = 1;i<=80;i=i+1){
                    Asientos boton1 = new Asientos("Asiento "+i);
                    nuevaSubLista.add(boton1);
                }
            }

            listaPrincipal.add(nuevaSubLista);

            System.out.println("Nueva sub-lista creada con identificador " + asignacionFinal.toString());
            mostrarBotonesDeSubLista(asignacionFinal.toString(), asignacionFinal);
            cardLayout.next(cardPanel);

        } else {
            System.out.println("Ya existe una sub-lista con el identificador " + asignacionFinal.toString());
            mostrarBotonesDeSubLista(asignacionFinal.toString(), asignacionFinal);
            cardLayout.next(cardPanel);
        }
    }

    /**
     *llama a panelComrador y muestra los botones de los asientos.
     * @param identificador String
     * @param asignacionFinal AsignacioFinal
     * @return boolean
     */
    private boolean mostrarBotonesDeSubLista(String identificador, AsignacionFinal asignacionFinal) {
        for (ArrayList<Object> subLista : listaPrincipal) {
            String subListaIdentificador = (String) subLista.get(0);
            if (subListaIdentificador.equals(identificador)) {
                panelCompra.mostrarBotones(subLista, asignacionFinal);
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica que exista el identificador
     * @param identificador String identificador del recorrido
     * @return boolean verdadero o falso dependiendo si encontro o no dicho identificador
     */

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

package Interfaces;

/**
 * Se encarga de hacer la transición entre los paneles,
 * avanPanel avanza un panel
 * retroPanel retocede un panel
 */
public interface PanelChangeListener {
    void avanPanel();
    /**
     * Metodo encargado de hacer retroceder entre paneles, usado en panelHorario y panelCompra
     */
    void retroPanel();
}

package Interfaces;

import AsignacionDeHorarios.AsignacionFinal;

/**
 * Se encarga de enviar la asignacion final para crear la lista y mostrar los botones en panelCompra.
 */
public interface APpanel3 {
    /**
     * Tomando la asinacion final seleccionada lo pasa a Frame y de ahi genera el panelCompra
     * @param asignacionFinal
     */
    void pasarPanelCompra(AsignacionFinal asignacionFinal);
}

package Interfaces;

import Enums.Recorrido;

/**
 *  Se encarga de mostrar el panel de horario con el recorrido seleccionado.
 */
public interface APpanel2 {
    /**
     * Se encarga de recibir un Recorrido y en base a este genera los botones de horarios necesarios en panelHorario
     * @param rec
     */
    void pasarPanelHorario(Recorrido rec);
}

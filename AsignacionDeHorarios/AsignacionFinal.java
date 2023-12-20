package AsignacionDeHorarios;

import Enums.Horario;
import Enums.Recorrido;
import Enums.TipoAsiento;
import Enums.TipoBus;

/**
 * clase AsignacionFinal
 */
public class AsignacionFinal {
    private Horario horario;
    private TipoAsiento tipoAsiento;
    private TipoBus tipoBus;

    private Recorrido recorrido;
    private int presioTotal;

    /**
     * Método Constructor de recorrido, horario, tipo de asiento y tipo bus
     * @param recorrido
     * @param horario
     * @param tipoAsiento
     * @param tipoBus
     */
    public AsignacionFinal(Recorrido recorrido, Horario horario, TipoAsiento tipoAsiento, TipoBus tipoBus) {
        this.horario = horario;
        this.tipoAsiento = tipoAsiento;
        this.tipoBus = tipoBus;
        this.recorrido= recorrido;
        this.presioTotal = tipoAsiento.getPresio()+tipoBus.getPresio()+recorrido.getPresio();
    }

    /**
     * getter de horario
     * @return Horario horario
     */
    public Horario getHorario() {
        return horario;
    }

    /**
     * getter de tipoAsiento
     * @return TipoAsiento tipoAsiento
     */
    public TipoAsiento getTipoAsiento() {
        return tipoAsiento;
    }

    /**
     * getter de tipoBus
     * @return TipoBus tipoBus
     */
    public TipoBus getTipoBus() {
        return tipoBus;
    }

    public Recorrido getRecorrido(){
        return recorrido;
    }
    public int getPresioTotal(){
        return presioTotal;
    }

    /**
     * override de Método toString
     * @return String horario, tipo de asiento, tipo de bus y precio del pasaje
     */
    @Override
    public String toString() {
        return "Horario: " + horario.getHora() + ", Tipo de Asiento: " + tipoAsiento.getNombre() + ", Tipo de Bus: " + tipoBus.getNombre() + "; Precio del pasaje: "+ presioTotal;
    }
}
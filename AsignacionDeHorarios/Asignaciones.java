package AsignacionDeHorarios;

import Enums.Horario;
import Enums.Recorrido;
import Enums.TipoAsiento;
import Enums.TipoBus;

import java.util.Collections;
import java.util.List;

/**
 * Clase Asignaciones se encarga de asignar los horarios, tipo de bus y tipo de asientos diponibles para cada recorrido
 */

public class Asignaciones {

    /**
     * asing es una lista que almacena las características de cada recorrido
     */

    private AsignacionHorarios asing = new AsignacionHorarios();

    /**
     * Método constructor que a una lista de asignaciones le agrega los recorridos que estime el usuario
     * usando el formato asign.add(Recorrido, Horario, TipoAsiento, TipoBus, noRecorrido);
     * el int noRecorrido tiene la utilidad de que cada recorrido completo para cada recorrido normal tenga un identificador distinto
     * asi evitando que colapsen las listas con AsignacionFinal exactamente iguales (ver los ultimos casos para Recorrido5)
     * estos recorridos son agregados automáticamente al sistema al iniciarlo, por lo que una vez listos solo quedaria ejecutar.
     */

    public Asignaciones(){
        // Asignacion a RECORRIDO1
        asing.AsingnacionFinal(Recorrido.RECORRIDO1, Horario.HORARIO_2, TipoAsiento.EJECUTIVO, TipoBus.DOS_PISOS,1);
        asing.AsingnacionFinal(Recorrido.RECORRIDO1, Horario.HORARIO_2, TipoAsiento.SEMI_CAMA, TipoBus.UNO_PISO,2);
        // Asignacion a RECORRIDO2
        asing.AsingnacionFinal(Recorrido.RECORRIDO2,Horario.HORARIO_1,TipoAsiento.NORMAL,TipoBus.DOS_PISOS,1);
        // Asignacion a RECORRIDO3
        asing.AsingnacionFinal(Recorrido.RECORRIDO3, Horario.HORARIO_1, TipoAsiento.SEMI_CAMA, TipoBus.UNO_PISO,1);
        asing.AsingnacionFinal(Recorrido.RECORRIDO3, Horario.HORARIO_1, TipoAsiento.EJECUTIVO, TipoBus.UNO_PISO,2);
        // Asignacion a RECORRIDO4
        asing.AsingnacionFinal(Recorrido.RECORRIDO4, Horario.HORARIO_1, TipoAsiento.NORMAL, TipoBus.UNO_PISO,1);
        asing.AsingnacionFinal(Recorrido.RECORRIDO4, Horario.HORARIO_2, TipoAsiento.SEMI_CAMA, TipoBus.UNO_PISO,2);
        // Asignacion a RECORRIDO5
        asing.AsingnacionFinal(Recorrido.RECORRIDO5, Horario.HORARIO_1, TipoAsiento.SEMI_CAMA, TipoBus.UNO_PISO,1);

        asing.AsingnacionFinal(Recorrido.RECORRIDO5, Horario.HORARIO_2, TipoAsiento.NORMAL, TipoBus.DOS_PISOS,1);
        asing.AsingnacionFinal(Recorrido.RECORRIDO5, Horario.HORARIO_3, TipoAsiento.EJECUTIVO, TipoBus.UNO_PISO,2);
        asing.AsingnacionFinal(Recorrido.RECORRIDO5, Horario.HORARIO_1, TipoAsiento.NORMAL, TipoBus.UNO_PISO,3);
        asing.AsingnacionFinal(Recorrido.RECORRIDO5, Horario.HORARIO_2, TipoAsiento.SEMI_CAMA, TipoBus.UNO_PISO,4);
        asing.AsingnacionFinal(Recorrido.RECORRIDO5, Horario.HORARIO_2, TipoAsiento.SEMI_CAMA, TipoBus.UNO_PISO,5);
    }

    /**
     * Método público que retorna todas las listas que tengan asignado el recorrido solicitado
     * @param rec obtiene la lista de asignaciones finales usando este recorrido
     * @return List<AsignacionFinal> asing.obtenerAsignacionFinal(rec) es la lista con horarios pedida
     */
    public List<AsignacionFinal> obtenerAAsignacionFinal(Recorrido rec) {
        return asing.obtenerAsignacionFinal(rec);
    }

//    public Recorrido obtenerRecorrido(){
//        return asing.AsingnacionFinal();
//    }
}

package AsignacionDeHorarios;

import AsignacionDeHorarios.AsignacionFinal;
import Enums.Horario;
import Enums.Recorrido;
import Enums.TipoAsiento;
import Enums.TipoBus;
import java.util.*;

/**
 * Clase AsignacionHorarios que crea un HashMap con los recorridos y sus respectivas caracteristicas
 */
public class AsignacionHorarios {
    private Map<Recorrido, List<AsignacionFinal>> asignaciones = new HashMap<>();


    /**
     *Método público que agrega listas con las asignaciones de cada bus a una lista más grande que las va a contener
     * @param recorrido
     * @param horario
     * @param tipoAsiento
     * @param tipoBus
     */
    public void AsingnacionFinal(Recorrido recorrido, Horario horario, TipoAsiento tipoAsiento, TipoBus tipoBus) {
        List<AsignacionFinal> asignacionFinal = asignaciones.getOrDefault(recorrido, new ArrayList<>());
        asignacionFinal.add(new AsignacionFinal(recorrido, horario, tipoAsiento, tipoBus));
        asignaciones.put(recorrido, asignacionFinal);
    }

    /**
     * Metodo público que retorna una lista con las sublistas con los datos del recorrido solicitdo
     * @param recorrido
     * @return lista con sublistas de las caracteristicas del recorrido
     */
    public List<AsignacionFinal> obtenerAsignacionFinal(Recorrido recorrido) {
        return asignaciones.getOrDefault(recorrido, Collections.emptyList());
    }

}
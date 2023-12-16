package Enums;

/**
 *Enum con los horarios disponibles, que se le asignara a cada recorrido
 */
public enum Horario {
    HORARIO_1("8:00 AM"),
    HORARIO_2("10:00 AM"),
    HORARIO_3("13:30 PM");

    private String hora;
    /**
     * Constructor de hora que asigna las variables
     */
    Horario(String hora) {
        this.hora = hora;
    }

    /**
     * Método publicó que retorna un String
     * @return la hora en la que se realiza el recorrido
     */
    public String getHora() {
        return hora;
    }
}
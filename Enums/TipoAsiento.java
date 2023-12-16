package Enums;

/**
 * Enum con los tipos de asiento y el valor adicional por el tipo de asiento
 * este valor se sumará al del precio de recorrido y al del tipo de bus
 */

public enum TipoAsiento {
    SEMI_CAMA("Semi-cama",500),
    NORMAL("Normal",200),
    EJECUTIVO("Pudiente",1000);

    private String nombre;
    private int presio;

    /**
     * Metodo Constructor de nombre y precio
     * @param nombre
     * @param presio
     */

    TipoAsiento(String nombre, int presio){
        this.nombre=nombre;
        this.presio=presio;
    }

    /**
     * Metodo público que retorna un String con el tipo de asiento
     * @return String nombre
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Metodo público que retorna un entero con el valor adicional por el tipo de asiento
     * @return int presio
     */

    public int getPresio(){
        return presio;
    }

    /**
     * Método público que recibe un String del tipo de asiento y retorna el precio en caso de existir
     * y 0 en el caso contrario
     * @param id String por el cual se buscará el asiento
     * @return int presio o 0 si no encuentra el asiento
     */

    public static int getPresioPorNombre(String id) {
        for (TipoAsiento asiento : values()) {
            if (asiento.getNombre() == id) {
                return asiento.getPresio();
            }
        }
        return 0;
    }
}
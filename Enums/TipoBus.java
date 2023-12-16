package Enums;
/**
 * Enum con el tipo de bus y el precio adicional por el tipo de bus
 *  este valor se sumará al del precio de recorrido y al del tipo de asiento
 */
public enum TipoBus {
    UNO_PISO("Un piso", 50),
    DOS_PISOS("Dos pisos",100);

    private String nombre;
    private int presio;

    /**
     * Mótodo contructor de presio y nombre
     * @param nombre
     * @param presio
     */
    TipoBus(String nombre, int presio){
        this.nombre=nombre;
        this.presio=presio;
    }
    /**
     * Método público que retorna el String del nombre pedido.
     * @return String nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Método público que retorna un entero con el precio 
     * @return int presio
     */
    public int getPresio() {
        return presio;
    }

    /**
     * Método público que retorna un entero con el precio adicional
     * dependiendo del tipo de bus y 0 en el caso de no encontrarlo
     * @param id
     * @return int presio o 0 en caso de no encontrar
     */
    public static int getPresioPorNombre(String id) {
        for (TipoBus bus : values()) {
            if (bus.getNombre() == id) {
                return bus.getPresio();
            }
        }
        return 0;
    }
}
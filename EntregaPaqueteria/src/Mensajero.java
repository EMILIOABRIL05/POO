/**
 * Clase que representa al mensajero encargado de entregar el paquete
 */
public class Mensajero {
    private String nombre, identificacion;

    /**3
     * Constructor del mensajero
     * @param nombre Nombre del mensajero
     * @param identificacion Identificación o número de empleado del mensajero
     */
    public Mensajero(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    /**
     * @return Nombre del mensajero
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del mensajero
     * @param nombre Nuevo nombre del mensajero
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return Identificación del mensajero
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * Establece la identificación del mensajero
     * @param identificacion Nueva identificación del mensajero
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
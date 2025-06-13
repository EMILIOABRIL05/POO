package reservasHotel;


public abstract class Habitacion {

    protected final int numeroHabitacion;
    protected final double precioNoche;


    public Habitacion(int numeroHabitacion, double precioNoche) {
        if(numeroHabitacion <= 0) {
            throw new IllegalArgumentException("El número de habitación debe ser positivo.");
        }
        if(precioNoche <=0){
            throw new IllegalArgumentException("El precio por noche debe ser positivo.");
        }
        this.numeroHabitacion = numeroHabitacion;
        this.precioNoche=precioNoche;
    }
    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }
    public double getPrecioNoche() {
        return precioNoche;
    }

    public abstract String getDescripcion();

    @Override
    public String toString() {
        return String.format("Habitación #%d - Precio por noche: %.2f - Descripcion: %s", numeroHabitacion, precioNoche);
    }


}

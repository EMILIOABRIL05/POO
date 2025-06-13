package reservasHotel;


public class Suite extends Habitacion {
    private boolean tieneJacuzzi;

    public Suite(int numeroHabitacion, double precioPorNoche, boolean tieneJacuzzi) {
        super(numeroHabitacion, precioPorNoche);
        this.tieneJacuzzi = tieneJacuzzi;
    }

    public boolean tieneJacuzzi() {
        return tieneJacuzzi;
    }

    @Override
    public String getDescripcion() {
        return tieneJacuzzi ? "Suite con jacuzzi" : "Suite estándar";

    }
}

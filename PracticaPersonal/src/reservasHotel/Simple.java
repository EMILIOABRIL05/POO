package reservasHotel;

public class Simple extends Habitacion {

    public Simple(int numeroHabitacion, double precioPorNoche) {
        super(numeroHabitacion, precioPorNoche);
    }

    @Override
    public String getDescripcion() {
        return "Habitación simple";
    }

}

package reservasHotel;

public class Reserva {

    private final Huesped huesped;
    private final Habitacion habitacion;
    private final String fecha;

    public Reserva(String fecha, Huesped huesped, Habitacion habitacion) {

        if (fecha == null || huesped == null || habitacion == null) {
            throw new IllegalArgumentException("Fecha, huesped y habitacion no pueden ser nulos");
        }
        if(fecha.isEmpty()) {
            throw new IllegalArgumentException("La fecha no puede estar vacía");
        }
        this.fecha = fecha;
        this.huesped = huesped;
        this.habitacion = habitacion;
    }

    public String getFecha() {
        return fecha;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Reserva reserva = (Reserva) obj;
        return huesped.equals(reserva.huesped) && habitacion.equals(reserva.habitacion) && fecha.equals(reserva.fecha);

    }
    @Override
    public int hashCode() {
        return fecha.hashCode();
    }
    @Override
    public String toString() {
        return String.format("Reserva: %s, Huesped: %s, Habitacion: %s", fecha, huesped, habitacion.getDescripcion());
    }
}

package reservasHotel;

public interface Reservable {
    void realizarReserva(Huesped huesped,Habitacion habitacion,String fecha) throws ReservaExcepcion;
}

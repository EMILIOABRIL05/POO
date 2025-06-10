import java.time.LocalDate;

public class Reserva {
    private Lector lector;
    private Libro libro;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Reserva(Lector lector, Libro libro, LocalDate fechaInicio, LocalDate fechaFin) {
        this.lector = lector;
        this.libro = libro;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public boolean fechasValidas() {
        return !fechaFin.isBefore(fechaInicio);
    }

    public void mostrarResumen() {
        System.out.println("\n----- RESUMEN DE RESERVA -----");
        System.out.printf("Lector: %s%n", lector);
        System.out.printf("Libro: %s%n", libro);
        System.out.printf("Fecha de inicio: %s%n", fechaInicio);
        System.out.printf("Fecha de fin:    %s%n", fechaFin);
        System.out.printf("Estado: %s%n", fechasValidas() ? "RESERVA VÁLIDA" : "FECHAS INVÁLIDAS");
        System.out.println("------------------------------");
    }
}

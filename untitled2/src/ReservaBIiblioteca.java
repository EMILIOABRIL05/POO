import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ReservaBIiblioteca {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Registro de Reserva de Libro ===");

        // Datos del lector
        System.out.print("Nombre del lector: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("Cédula: ");
        String cedula = scanner.nextLine().trim();

        Lector lector = new Lector(nombre, cedula);

        // Datos del libro
        System.out.print("Título del libro: ");
        String titulo = scanner.nextLine().trim();

        System.out.print("Autor del libro: ");
        String autor = scanner.nextLine().trim();
        System.out.println("codigo del libro");
        String codigo = scanner.nextLine().trim();

        Libro libro = new Libro(titulo, autor, codigo);

        // Fechas con validación
        LocalDate fechaInicio = leerFecha("Fecha de inicio (AAAA-MM-DD): ");
        LocalDate fechaFin = leerFecha("Fecha de fin (AAAA-MM-DD): ");

        // Crear reserva
        Reserva reserva = new Reserva(lector, libro, fechaInicio, fechaFin);
        reserva.mostrarResumen();

        scanner.close();
    }

    private static LocalDate leerFecha(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return LocalDate.parse(scanner.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Usa AAAA-MM-DD.");
            }
        }
    }
}

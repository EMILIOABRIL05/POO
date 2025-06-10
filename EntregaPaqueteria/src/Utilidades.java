import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

public class Utilidades {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Método para leer texto no vacío
     * @param mensaje Mensaje de solicitud al usuario
     * @return Texto ingresado por el usuario
     */
    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        String texto = scanner.nextLine().trim();
        if (texto.isEmpty()) {
            System.out.println("Error: el campo no puede estar vacío.");
            return leerTexto(mensaje);
        }
        return texto;
    }

    /**
     * Método para leer peso numérico y mayor a cero
     * @param mensaje Mensaje de solicitud al usuario
     * @return Peso válido ingresado por el usuario
     */
    public static double leerPeso(String mensaje) {
        System.out.print(mensaje);
        try {
            double peso = Double.parseDouble(scanner.nextLine());
            if (peso <= 0) {
                System.out.println("Error: el peso debe ser mayor a cero.");
                return leerPeso(mensaje);
            }
            return peso;
        } catch (NumberFormatException e) {
            System.out.println("Error: ingrese un número válido.");
            return leerPeso(mensaje);
        }
    }

    /**
     * Método para leer fechas con validación de formato
     * @param mensaje Mensaje de solicitud al usuario
     * @return Fecha válida ingresada por el usuario
     */
    public static LocalDate leerFecha(String mensaje) {
        System.out.print(mensaje);
        try {
            return LocalDate.parse(scanner.nextLine());
        } catch (DateTimeParseException e) {
            System.out.println("Error: ingrese la fecha en formato AAAA-MM-DD.");
            return leerFecha(mensaje);
        }
    }

    /**
     * Cierra el scanner al finalizar el programa
     */
    public static void cerrarScanner() {
        scanner.close();
    }

}

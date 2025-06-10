import java.time.LocalDate;
public class EntregaPaqueteria {
    /**
     /**
     * Método principal del programa
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        try {
            // Registro del emisor
            System.out.println("Registro del Cliente Emisor:");
            Cliente emisor = new Cliente(
                    Utilidades.leerTexto("Nombre: "),
                    Utilidades.leerTexto("Dirección: "),
                    Utilidades.leerTexto("Teléfono: ")
            );

            // Registro del receptor
            System.out.println("\nRegistro del Cliente Receptor:");
            Cliente receptor = new Cliente(
                    Utilidades.leerTexto("Nombre: "),
                    Utilidades.leerTexto("Dirección: "),
                    Utilidades.leerTexto("Teléfono: ")
            );

            // Registro del mensajero
            System.out.println("\nRegistro del Mensajero:");
            Mensajero mensajero = new Mensajero(
                    Utilidades.leerTexto("Nombre: "),
                    Utilidades.leerTexto("Identificación: ")
            );

            // Ingreso de datos del paquete
            System.out.println("\nDatos del Paquete:");
            double peso = Utilidades.leerPeso("Peso en kilogramos: ");
            LocalDate fechaEnvio = Utilidades.leerFecha("Fecha de envío (AAAA-MM-DD): ");
            LocalDate fechaEntrega = Utilidades.leerFecha("Fecha de entrega (AAAA-MM-DD): ");

            // Creación del objeto Paquete
            Paquete paquete = new Paquete(emisor, receptor, mensajero, peso, fechaEnvio, fechaEntrega);

            // Validación de fechas
            if (!paquete.validarFechas()) {
                System.out.println("Error: la fecha de entrega no puede ser anterior a la fecha de envío.");
                return;
            }

            // Procesamiento final del paquete
            paquete.marcarEntregado();   // Se marca como entregado
            paquete.imprimirRecibo();    // Se imprime el recibo

        } catch (Exception e) {
            // Captura errores no esperados
            System.out.println("Error inesperado: " + e.getMessage());
        } finally {
            // Cierre del scanner
            Utilidades.cerrarScanner();
        }
    }
}

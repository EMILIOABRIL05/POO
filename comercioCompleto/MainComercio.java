package comercioCompleto;

import java.util.Scanner;

public class MainComercio {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE COMERCIO COMPLETO ===\n");

        try {
            // Crear productos de ejemplo
            Producto[] productos = crearProductosEjemplo();

            // Crear cliente y vendedor
            Cliente cliente = crearCliente();
            Vendedor vendedor = crearVendedor();

            // Crear orden
            Orden orden = new Orden(cliente, vendedor);

            // Solicitar número de items a agregar
            System.out.print("¿Cuántos items desea agregar a la orden? (máximo 3): ");
            int numItems = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer después de nextInt()

            if (numItems < 1 || numItems > 3) {
                System.out.println("Error: El número de items debe estar entre 1 y 3");
                return;
            }

            // Mostrar productos disponibles
            mostrarProductosDisponibles(productos);

            // Agregar items a la orden
            for (int i = 0; i < numItems; i++) {
                System.out.println("\n--- ITEM " + (i + 1) + " ---");
                agregarItemAOrden(orden, productos);
            }

            // Mostrar resumen de la orden
            mostrarResumenOrden(orden);

            // Procesar pago
            procesarPago(orden);

            // Mostrar factura final
            mostrarFacturaFinal(orden);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static Producto[] crearProductosEjemplo() {
        return new Producto[] {
                new Producto("P001", "Laptop Dell", 800.0, 800.0, 5),
                new Producto("P002", "Mouse Inalámbrico", 25.0, 25.0, 15),
                new Producto("P003", "Teclado Mecánico", 120.0, 120.0, 8),
                new Producto("P004", "Monitor 24''", 300.0, 300.0, 10),
                new Producto("P005", "Auriculares Bluetooth", 80.0, 80.0, 12)
        };
    }

    private static Cliente crearCliente() {
        System.out.println("=== DATOS DEL CLIENTE ===");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer después de nextInt()

        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();

        System.out.print("ID Cliente: ");
        String idCliente = scanner.nextLine();

        return new Cliente(nombre, email, edad, cedula, idCliente);
    }

    private static Vendedor crearVendedor() {
        System.out.println("\n=== DATOS DEL VENDEDOR ===");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer después de nextInt()

        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();

        System.out.print("ID Vendedor: ");
        String idVendedor = scanner.nextLine();

        return new Vendedor(nombre, email, edad, cedula, idVendedor);
    }

    private static void mostrarProductosDisponibles(Producto[] productos) {
        System.out.println("\n=== PRODUCTOS DISPONIBLES ===");
        for (int i = 0; i < productos.length; i++) {
            System.out.println((i + 1) + ". " + productos[i]);
        }
    }

    private static void agregarItemAOrden(Orden orden, Producto[] productos) {
        try {
            System.out.print("Seleccione el número del producto (1-" + productos.length + "): ");
            int seleccion = scanner.nextInt();

            if (seleccion < 1 || seleccion > productos.length) {
                System.out.println("Selección inválida. Saltando este item.");
                return;
            }

            Producto productoSeleccionado = productos[seleccion - 1];

            System.out.print("Cantidad (Stock disponible: " + productoSeleccionado.getStock() + "): ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer después de nextInt()

            orden.agregarItem(productoSeleccionado, cantidad);
            System.out.println("✓ Item agregado exitosamente");

        } catch (ExCantidadInvalida e) {
            System.err.println("Error al agregar item: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

    private static void mostrarResumenOrden(Orden orden) {
        System.out.println("\n=== RESUMEN DE LA ORDEN ===");
        System.out.println("ID Orden: " + orden.getIdOrden());
        System.out.println("Cliente: " + orden.getCliente().getNombre());
        System.out.println("Vendedor: " + orden.getVendedor().getNombre());

        System.out.println("\nItems en la orden:");
        ItemOrden[] items = orden.getItems();
        for (ItemOrden item : items) {
            System.out.println("- " + item);
        }

        System.out.printf("Total: $%.2f", orden.calculoTotal());
        if (orden.isDescuentoAplicado()) {
            System.out.println(" (Descuento del 10% aplicado)");
        } else {
            System.out.println();
        }
    }

    private static void procesarPago(Orden orden) {
        try {
            double total = orden.calculoTotal();
            System.out.printf("\nTotal a pagar: $%.2f\n", total);
            System.out.print("Ingrese el monto del pago: $");
            double montoPago = scanner.nextDouble();

            orden.pago(montoPago);

            double cambio = montoPago - total;
            if (cambio > 0) {
                System.out.printf("Cambio a entregar: $%.2f\n", cambio);
            }

            System.out.println("✓ Pago procesado exitosamente");

        } catch (ExPagos e) {
            System.err.println("Error en el pago: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado en el pago: " + e.getMessage());
        }
    }

    private static void mostrarFacturaFinal(Orden orden) {
        StringBuilder lineaIgual = new StringBuilder();
        for(int i = 0; i < 50; i++) {
            lineaIgual.append("=");
        }

        System.out.println("\n" + lineaIgual.toString());
        System.out.println("               FACTURA FINAL");
        System.out.println(lineaIgual.toString());

        System.out.println("ID Orden: " + orden.getIdOrden());
        System.out.println("Cliente: " + orden.getCliente().getNombre() +
                " (ID: " + orden.getCliente().getIdCliente() + ")");
        System.out.println("Vendedor: " + orden.getVendedor().getNombre() +
                " (ID: " + orden.getVendedor().getIdVendedor() + ")");

        System.out.println("\nDetalle de productos:");
        StringBuilder lineaGuion = new StringBuilder();
        for(int i = 0; i < 50; i++) {
            lineaGuion.append("-");
        }
        System.out.println(lineaGuion.toString());

        ItemOrden[] items = orden.getItems();
        for (ItemOrden item : items) {
            System.out.println(item);
        }

        System.out.println(lineaGuion.toString());

        if (orden.isDescuentoAplicado()) {
            System.out.println("Descuento aplicado: 10%");
        }

        System.out.printf("TOTAL: $%.2f\n", orden.calculoTotal());
        System.out.printf("PAGADO: $%.2f\n", orden.getMontoPagado());

        double cambio = orden.getMontoPagado() - orden.calculoTotal();
        if (cambio > 0) {
            System.out.printf("CAMBIO: $%.2f\n", cambio);
        }

        System.out.println(lineaIgual.toString());
        System.out.println("        ¡Gracias por su compra!");
        System.out.println(lineaIgual.toString());
    }
}
package comercio;

import java.util.Scanner;
import java.util.Locale;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppComercio {
    private static Scanner sc;
    private static final String SEPARADOR = "====================";
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        inicializarScanner();
        GestorOrden gestor = new GestorOrden();
        Producto[] productos = inicializarProductos();
        ejecutarMenuPrincipal(gestor, productos);
        finalizarPrograma();
    }

    private static void inicializarScanner() {
        Locale.setDefault(new Locale("en", "US"));
        sc = new Scanner(System.in).useLocale(Locale.US);
    }

    private static Producto[] inicializarProductos() {
        return new Producto[] {
                new Producto("P001", "Arroz", 1.0, 1.2, 100),
                new Producto("P002", "Papas", 1.0, 1.5, 50),
                new Producto("P003", "Avena", 0.5, 0.6, 40),
                new Producto("P004", "Frejol", 0.5, 1.2, 50)
        };
    }

    private static void ejecutarMenuPrincipal(GestorOrden gestor, Producto[] productos) {
        boolean salir = false;
        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = leerEntero("Seleccione una opción: ", 1, 4);
            salir = procesarOpcionMenu(opcion, gestor, productos);
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n=== Menú de Ventas ===");
        System.out.println("1. Crear pedido");
        System.out.println("2. Ver pedidos");
        System.out.println("3. Imprimir factura");
        System.out.println("4. Salir");
        System.out.println(SEPARADOR);
    }

    private static boolean procesarOpcionMenu(int opcion, GestorOrden gestor, Producto[] productos) {
        switch (opcion) {
            case 1:
                crearOrden(productos, gestor);
                return false;
            case 2:
                mostrarPedidos(gestor);
                return false;
            case 3:
                imprimirFactura(gestor);
                return false;
            case 4:
                return true;
            default:
                return false;
        }
    }

    private static void imprimirFactura(GestorOrden gestor) {
        if (!gestor.tieneOrdenes()) {
            System.out.println("\nNo hay pedidos registrados para generar facturas");
            return;
        }

        System.out.println("\n¿Desea imprimir la factura? (S/N):");
        String respuesta = sc.nextLine().trim().toUpperCase();

        if (respuesta.equals("S")) {
            // Mostrar información actual
            System.out.println("Current Date and Time (UTC - YYYY-MM-DD HH:MM:SS formatted): " +
                    LocalDateTime.now().format(FORMATO_FECHA));
            System.out.println("Current User's Login: " + System.getProperty("user.name").toUpperCase());
            System.out.println(SEPARADOR);

            // Obtener la última orden y mostrar su factura
            Orden ultimaOrden = gestor.getUltimaOrden();
            if (ultimaOrden != null) {
                Factura factura = new Factura(ultimaOrden);
                System.out.println("\n" + factura.generarFactura());
            }
        }
    }

    private static void crearOrden(Producto[] productos, GestorOrden gestor) {
        try {
            Cliente cliente = leerCliente();
            Vendedor vendedor = leerVendedor();
            Orden orden = new Orden(cliente, vendedor);
            procesarProductos(orden, productos);
            procesarPago(orden);
            finalizarOrden(orden, gestor);
        } catch (Exception e) {
            System.out.println("Error al crear la orden: " + e.getMessage());
        }
    }

    private static void procesarProductos(Orden orden, Producto[] productos) throws ExCantidadInvalida {
        int numItems = leerEntero("Ingrese la cantidad de productos (1-3): ", 1, 3);

        for (int i = 0; i < numItems; i++) {
            try {
                Producto seleccionado = seleccionarProducto(productos);
                System.out.printf("Stock disponible: %d%n", seleccionado.getStock());
                int cantidad = leerEntero("Unidades del producto: ", 1, seleccionado.getStock());
                orden.agregarItem(seleccionado, cantidad);
            } catch (ExCantidadInvalida e) {
                System.out.println("Error: " + e.getMessage());
                i--; // Permite reintentar
            }
        }
    }

    private static void procesarPago(Orden orden) throws ExPagos {
        double subtotal = orden.calculoTotal();
        double totalConDescuento = orden.aplicarDescuento(subtotal);
        mostrarResumenCompra(subtotal, totalConDescuento);
        double pago = leerPago(totalConDescuento);
        orden.pago(pago);
        mostrarCambio(pago, totalConDescuento);
    }

    private static void mostrarResumenCompra(double subtotal, double totalConDescuento) {
        System.out.println("\nResumen de la compra:");
        System.out.printf("Subtotal: $%.2f%n", subtotal);
        System.out.printf("Descuento (10%%): $%.2f%n", subtotal - totalConDescuento);
        System.out.printf("Total a pagar: $%.2f%n", totalConDescuento);
    }

    private static void mostrarCambio(double pago, double total) {
        if (pago > total) {
            System.out.printf("Su cambio es: $%.2f%n", pago - total);
        }
    }

    private static void finalizarOrden(Orden orden, GestorOrden gestor) {
        gestor.encolarOrden(orden);
        System.out.println("\n¡Pedido creado exitosamente!");
    }

    private static void mostrarPedidos(GestorOrden gestor) {
        if (gestor.tieneOrdenes()) {
            System.out.println("\n=== Pedidos Registrados ===");
            System.out.println(gestor.toString());
        } else {
            System.out.println("\nNo hay pedidos registrados aún");
        }
    }

    private static int leerEntero(String prompt, int min, int max) {
        while (true) {
            System.out.println(prompt);
            try {
                String input = sc.nextLine().trim();
                int valor = Integer.parseInt(input);
                if (valor >= min && valor <= max) {
                    return valor;
                }
                System.out.printf("Error: El valor debe estar entre %d y %d. Intente nuevamente:%n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido. Intente nuevamente:");
            }
        }
    }

    private static double leerPago(double totalAPagar) {
        while (true) {
            try {
                System.out.println("Ingrese el monto del pago:");
                String input = sc.nextLine().trim().replace(",", ".");
                double pago = Double.parseDouble(input);

                if (pago < totalAPagar) {
                    System.out.printf("Error: Pago insuficiente. Debe pagar al menos: $%.2f%n", totalAPagar);
                    continue;
                }
                return pago;
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un monto válido");
            }
        }
    }

    private static String leerString(String prompt) {
        while (true) {
            System.out.println(prompt);
            String valor = sc.nextLine().trim();
            if (!valor.isEmpty()) {
                return valor;
            }
            System.out.println("Error: Este campo no puede estar vacío. Intente nuevamente:");
        }
    }

    private static Cliente leerCliente() {
        System.out.println("\nDatos del cliente:");
        String nombre = leerString("Nombre: ");
        String email = leerString("Correo Electrónico: ");
        String cedula = leerString("Cédula sin guión: ");
        String id = leerString("ID de cliente: ");
        int edad = leerEntero("Edad en años: ", 18, 90);
        return new Cliente(nombre, email, edad, cedula, id);
    }

    private static Vendedor leerVendedor() {
        System.out.println("\nDatos del vendedor:");
        String nombre = leerString("Nombre: ");
        String email = leerString("Correo Electrónico: ");
        String cedula = leerString("Cédula sin guión: ");
        String id = leerString("ID de vendedor: ");
        int edad = leerEntero("Edad en años: ", 25, 65);
        return new Vendedor(nombre, email, edad, cedula, id);
    }

    private static Producto seleccionarProducto(Producto[] productos) {
        System.out.println("\nCatálogo de productos:");
        for (int i = 0; i < productos.length; i++) {
            System.out.printf("%d. %s%n", i + 1, productos[i].toString());
        }
        int opcion = leerEntero("Opción(1-" + productos.length + "): ", 1, productos.length);
        return productos[opcion - 1];
    }

    private static void finalizarPrograma() {
        System.out.println("\n¡Gracias por usar el sistema!");
        if (sc != null) {
            sc.close();
        }
    }
}
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

            // Solicitar numero de items a agregar
            int numItems = solicitarNumeroItems();

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

    // Metodo para solicitar numero de items con validacion
    private static int solicitarNumeroItems() {
        int numItems = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("¿Cuántos items desea agregar a la orden? (máximo 3): ");
                String entrada = scanner.nextLine().trim();

                if (entrada.isEmpty()) {
                    System.out.println("Error: Debe ingresar un número.");
                    continue;
                }

                numItems = Integer.parseInt(entrada);

                if (numItems < 1 || numItems > 3) {
                    System.out.println("Error: El número de items debe estar entre 1 y 3");
                    continue;
                }

                entradaValida = true;

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido (1, 2 o 3).");
            }
        }

        return numItems;
    }

    // Metodo para leer enteros con validacion
    private static int leerEntero(String mensaje) {
        int numero = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print(mensaje);
                String entrada = scanner.nextLine().trim();

                if (entrada.isEmpty()) {
                    System.out.println("Error: Debe ingresar un número.");
                    continue;
                }

                numero = Integer.parseInt(entrada);
                entradaValida = true;

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.");
            }
        }

        return numero;
    }

    // Método para leer números decimales con validación
    private static double leerDouble(String mensaje) {
        double numero = 0.0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print(mensaje);
                String entrada = scanner.nextLine().trim();

                if (entrada.isEmpty()) {
                    System.out.println("Error: Debe ingresar un número.");
                    continue;
                }

                numero = Double.parseDouble(entrada);

                if (numero < 0) {
                    System.out.println("Error: El número debe ser positivo.");
                    continue;
                }

                entradaValida = true;

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.");
            }
        }

        return numero;
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

        int edad = leerEntero("Edad: ");

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

        int edad = leerEntero("Edad: ");

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
        boolean itemAgregado = false;

        while (!itemAgregado) {
            try {
                // Seleccion del producto
                int seleccion = leerEntero("Seleccione el número del producto (1-" + productos.length + "): ");

                if (seleccion < 1 || seleccion > productos.length) {
                    System.out.println("Selección inválida. Debe seleccionar un número entre 1 y " + productos.length);
                    continue; // Continua el bucle para pedir nueva seleccion
                }

                Producto productoSeleccionado = productos[seleccion - 1];

                // Verificar si el producto ya esta en la orden
                if (productoYaEnOrden(orden, productoSeleccionado)) {
                    System.out.println("Error: Este producto ya está en la orden. Seleccione otro producto.");
                    continue; // Continua el bucle para pedir nueva seleccion
                }

                // Verificar stock disponible
                if (productoSeleccionado.getStock() <= 0) {
                    System.out.println("Error: No hay stock disponible para este producto. Seleccione otro.");
                    continue; // Continua el bucle para pedir nueva seleccion
                }

                // Solicitar cantidad
                boolean cantidadValida = false;
                while (!cantidadValida) {
                    int cantidad = leerEntero("Cantidad (Stock disponible: " + productoSeleccionado.getStock() + "): ");

                    if (cantidad <= 0) {
                        System.out.println("Error: La cantidad debe ser mayor que 0.");
                        continue; // Pide nueva cantidad
                    }

                    if (cantidad > productoSeleccionado.getStock()) {
                        System.out.println("Error: Stock insuficiente. Stock disponible: " + productoSeleccionado.getStock());
                        continue; // Pide nueva cantidad
                    }

                    // Si llegamos aqui, la cantidad es valida
                    try {
                        orden.agregarItem(productoSeleccionado, cantidad);
                        System.out.println("Item agregado exitosamente");
                        itemAgregado = true;
                        cantidadValida = true;
                    } catch (ExCantidadInvalida e) {
                        System.err.println("Error al agregar item: " + e.getMessage());
                        // Si es error de duplicado o limite de items, salir del bucle de cantidad
                        // y permitir seleccionar otro producto
                        if (e.getMessage().contains("duplicado") || e.getMessage().contains("3 items")) {
                            break; // Sale del bucle de cantidad para seleccionar otro producto
                        }
                        // Si es otro tipo de error de cantidad, continua pidiendo cantidad
                        continue;
                    }
                }

            } catch (Exception e) {
                System.err.println("Error inesperado: " + e.getMessage());
                System.out.println("Intente nuevamente.");
            }
        }
    }

    // Metodo para verificar si un producto ya esta en la orden
    private static boolean productoYaEnOrden(Orden orden, Producto producto) {
        ItemOrden[] items = orden.getItems();
        for (ItemOrden item : items) {
            if (item.getProducto().getIdProducto().equals(producto.getIdProducto())) {
                return true;
            }
        }
        return false;
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
        boolean pagoExitoso = false;

        while (!pagoExitoso) {
            try {
                double total = orden.calculoTotal();
                System.out.printf("\nTotal a pagar: $%.2f\n", total);

                double montoPago = leerDouble("Ingrese el monto del pago: $");

                orden.pago(montoPago);

                double cambio = montoPago - total;
                if (cambio > 0) {
                    System.out.printf("Cambio a entregar: $%.2f\n", cambio);
                }

                System.out.println("Pago procesado exitosamente");
                pagoExitoso = true;

            } catch (ExPagos e) {
                System.err.println("Error en el pago: " + e.getMessage());
                System.out.println("Intente nuevamente.");
            } catch (Exception e) {
                System.err.println("Error inesperado en el pago: " + e.getMessage());
                System.out.println("Intente nuevamente.");
            }
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
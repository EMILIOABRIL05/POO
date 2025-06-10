package comercio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Factura {
    private static final String SEPARADOR = "=".repeat(40);
    private final Orden orden;
    private final LocalDateTime fechaEmision;
    private final String numeroFactura;
    private static int consecutivoFactura = 1;

    public Factura(Orden orden) {
        this.orden = orden;
        this.fechaEmision = LocalDateTime.now();
        this.numeroFactura = generarNumeroFactura();
    }

    private String generarNumeroFactura() {
        return String.format("FAC-%s-%04d",
                fechaEmision.format(DateTimeFormatter.BASIC_ISO_DATE),
                consecutivoFactura++);
    }

    public String generarFactura() {
        StringBuilder factura = new StringBuilder();

        // Encabezado
        factura.append(SEPARADOR).append("\n");
        factura.append("            FACTURA DE VENTA\n");
        factura.append(SEPARADOR).append("\n\n");

        // Información de la factura
        factura.append("Nº Factura: ").append(numeroFactura).append("\n");
        factura.append("Fecha: ").append(fechaEmision.format(
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))).append("\n");
        factura.append("Nº Pedido: ").append(orden.getIdOrden()).append("\n\n");

        // Información del cliente
        Cliente cliente = orden.getCliente();
        factura.append("DATOS DEL CLIENTE\n");
        factura.append("-".repeat(20)).append("\n");
        factura.append("Nombre: ").append(cliente.getNombre()).append("\n");
        factura.append("Cédula: ").append(cliente.getCedula()).append("\n");
        factura.append("Email: ").append(cliente.getEmail()).append("\n\n");

        // Detalles de los productos
        factura.append("DETALLE DE PRODUCTOS\n");
        factura.append("-".repeat(20)).append("\n");
        factura.append(String.format("%-20s %8s %10s %10s\n",
                "Producto", "Cantidad", "P.Unit", "Subtotal"));
        factura.append("-".repeat(50)).append("\n");

        // Agregar items
        agregarDetalleItem(factura, orden.getItem1());
        agregarDetalleItem(factura, orden.getItem2());
        agregarDetalleItem(factura, orden.getItem3());

        factura.append("\n");
        factura.append("-".repeat(50)).append("\n");

        // Totales
        double subtotal = orden.calculoTotal();
        double descuento = subtotal - orden.aplicarDescuento(subtotal);
        double total = orden.aplicarDescuento(subtotal);

        factura.append(String.format("Subtotal:%42.2f\n", subtotal));
        factura.append(String.format("Descuento (10%%):%35.2f\n", descuento));
        factura.append(String.format("TOTAL:%45.2f\n", total));

        // Información de pago
        if (orden.getMontoPago() > 0) {
            factura.append(String.format("Pagado:%45.2f\n", orden.getMontoPago()));
            if (orden.getMontoPago() > total) {
                factura.append(String.format("Cambio:%45.2f\n",
                        orden.getMontoPago() - total));
            }
        }

        // Pie de factura
        factura.append("\n").append(SEPARADOR).append("\n");
        factura.append("Vendedor: ").append(orden.getVendedor().getNombre()).append("\n");
        factura.append("¡Gracias por su compra!\n");
        factura.append(SEPARADOR);

        return factura.toString();
    }

    private void agregarDetalleItem(StringBuilder factura, ItemOrden item) {
        if (item != null) {
            Producto producto = item.getProducto();
            factura.append(String.format("%-20s %8d %10.2f %10.2f\n",
                    producto.getNombreProducto(),
                    item.getCantidad(),
                    producto.getPrecioUnitario(),
                    item.subTotalItem()));
        }
    }

    // Getters
    public String getNumeroFactura() {
        return numeroFactura;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public Orden getOrden() {
        return orden;
    }
}
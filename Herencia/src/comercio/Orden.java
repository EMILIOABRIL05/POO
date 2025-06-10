package comercio;

public class Orden implements Descuentos, Pagos {
    private static int consecutivo = 10000;
    private int idOrden;
    private Cliente cliente;
    private Vendedor vendedor;
    private ItemOrden item1;
    private ItemOrden item2;
    private ItemOrden item3;
    private double montoPago;

    public Orden(Cliente cliente, Vendedor vendedor) {
        this.idOrden = ++consecutivo;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.montoPago = 0;
    }

    public void agregarItem(Producto producto, int cantidad) throws ExCantidadInvalida {
        ItemOrden nuevoItem = new ItemOrden(producto, cantidad);

        if (item1 == null) {
            item1 = nuevoItem;
        } else if (item2 == null) {
            item2 = nuevoItem;
        } else if (item3 == null) {
            item3 = nuevoItem;
        } else {
            throw new ExCantidadInvalida("No se pueden agregar más items a la orden");
        }
    }

    public double calculoTotal() {
        double total = 0;
        if (item1 != null) total += item1.subTotalItem();
        if (item2 != null) total += item2.subTotalItem();
        if (item3 != null) total += item3.subTotalItem();
        return total;
    }

    @Override
    public double aplicarDescuento(double monto) {
        return monto * 0.9; // 10% de descuento
    }

    @Override
    public void pago(double monto) throws ExPagos {
        if (monto < aplicarDescuento(calculoTotal())) {
            throw new ExPagos("El monto del pago es insuficiente");
        }
        this.montoPago = monto;
    }

    // Getters
    public int getIdOrden() {
        return idOrden;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public ItemOrden getItem1() {
        return item1;
    }

    public ItemOrden getItem2() {
        return item2;
    }

    public ItemOrden getItem3() {
        return item3;
    }

    public double getMontoPago() {
        return montoPago;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Pedido #%d%n", this.idOrden));
        sb.append(String.format("Cliente: %s%n", this.cliente.getNombre()));
        sb.append(String.format("Vendedor: %s%n", this.vendedor.getNombre()));
        sb.append("Items:%n");

        if (item1 != null) sb.append(String.format("- %s%n", item1.toString()));
        if (item2 != null) sb.append(String.format("- %s%n", item2.toString()));
        if (item3 != null) sb.append(String.format("- %s%n", item3.toString()));

        double subtotal = calculoTotal();
        double total = aplicarDescuento(subtotal);

        sb.append(String.format("Subtotal: $%.2f%n", subtotal));
        sb.append(String.format("Descuento: $%.2f%n", subtotal - total));
        sb.append(String.format("Total: $%.2f%n", total));

        if (montoPago > 0) {
            sb.append(String.format("Pagado: $%.2f%n", montoPago));
            if (montoPago > total) {
                sb.append(String.format("Cambio: $%.2f%n", montoPago - total));
            }
        }

        return sb.toString();
    }
}
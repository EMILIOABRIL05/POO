package comercioCompleto;

public class ItemOrden {
    private Producto producto;
    private int cantidad;

    public ItemOrden(Producto producto, int cantidad) throws ExCantidadInvalida {
        if (cantidad <= 0) {
            throw new ExCantidadInvalida("La cantidad debe ser mayor que 0");
        }
        if (cantidad > producto.getStock()) {
            throw new ExCantidadInvalida("Stock insuficiente");
        }
        this.producto = producto;
        this.cantidad = cantidad;
        this.producto.actualizarStock(cantidad);
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double subTotalItem() {
        return cantidad * producto.getPrecioUnitario();
    }

    @Override
    public String toString() {
        return String.format("%s - Cantidad: %d - Subtotal: %.2f",
                producto.toString(),
                cantidad,
                subTotalItem());
    }
}
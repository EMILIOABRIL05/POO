package comercioCompleto;

import java.util.Arrays;

public class Orden implements Descuentos, Pagos{

    private static int idBase= 10000;
    private final int idOrden;
    private final Cliente cliente;
    private final Vendedor vendedor;
    private final ItemOrden[] items = new ItemOrden[3];
    private int contItems = 0;
    private boolean descuentoAplicado = false;
    private double montoPagado = 0;

    public Orden(Cliente cliente, Vendedor vendedor) {

        idOrden = idBase++;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public ItemOrden[] getItems() {

        return Arrays.copyOf(items, contItems);
    }

    public int getContItems() {
        return contItems;
    }

    public void setContItems(int contItems) {
        this.contItems = contItems;
    }

    public boolean isDescuentoAplicado() {
        return descuentoAplicado;
    }

    public void setDescuentoAplicado(boolean descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(double montoPagado) {
        this.montoPagado = montoPagado;
    }

    public void agregarItem(Producto producto, int cantidad) throws ExCantidadInvalida{

        if(contItems >= items.length){

            throw new ExCantidadInvalida("Solo se pueden agregar 3 items a la orden");
        }

        for(int i = 0; i < contItems; i++){

            if(items[i].getProducto().equals(producto)){

                throw new ExCantidadInvalida("Producto duplicado");
            }
        }
        items[contItems++] = new ItemOrden(producto, cantidad);
    }

    @Override
    public double calculoTotal() {

        double suma = 0;
        for(int i = 0; i < contItems; i++){

            suma = suma + items[i].subTotalItem();
        }
        return aplicarDescuento(suma);
    }

    @Override
    public double aplicarDescuento(double total) {

        if(total > 500){

            this.descuentoAplicado = true;
            return total * 0.9;
        }
        return total;
    }

    @Override
    public void pago(double monto) throws ExPagos{

        double total = calculoTotal();
        if(monto < total){

            throw new ExPagos("El monto ingresado no es suficiente para realizar el pago");
        }
            this.montoPagado = monto;


    }

}
package comercioCompleto;

public interface Pagos {

    double calculoTotal();

    void pago(double montoPago) throws ExPagos;

}

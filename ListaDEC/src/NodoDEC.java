public class NodoDEC {
    Object dato;
    NodoDEC siguiente;
    NodoDEC anterior;

    public NodoDEC(Object dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;

    }

    public NodoDEC(Object dato, NodoDEC siguiente,NodoDEC anterior) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;

    }
}

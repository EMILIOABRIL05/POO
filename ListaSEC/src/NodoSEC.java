public class NodoSEC {
    Object dato;
    NodoSEC siguiente;

    public NodoSEC(Object dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public NodoSEC(Object dato, NodoSEC siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }
}

public class NodoSE {

    Object dato;
    NodoSE siguiente;

    public NodoSE(Object dato) {
        this.dato = dato;
        this.siguiente = null;
    }


    public Object obtenerDato() {
        return dato;
    }

    public void enlazarSiguiente(NodoSE n) {
        siguiente = n;
    }

    public NodoSE obtenerSiguiente() {
        return siguiente;
    }
}
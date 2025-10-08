package ListaDE;

public class NodoDE {
    Object dato;
    NodoDE siguiente,anterior;

    public NodoDE(Object dato, NodoDE siguiente, NodoDE anterior) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }
    public NodoDE(Object dato){
        this.dato = dato;
    }
}

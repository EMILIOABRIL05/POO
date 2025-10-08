package ListasE;

public class ListaE {
    Nodo cabeza;
    int cont;

    public ListaE(){
        this.cabeza = null;
        this.cont = 0;
    }
    public boolean esVacia(){
        return this.cabeza == null;

    }
    public boolean insertarPorUltimo(Object dato){
        if (this.esVacia()){
            this.cabeza = new Nodo(dato);
            this.cont++;
            return true;
        }

        Nodo aux = this.cabeza;
        while (aux.siguiente != null){
            aux = aux.siguiente;
        }
        aux.siguiente = new Nodo(dato);
        this.cont++;
        return true;
    }
}

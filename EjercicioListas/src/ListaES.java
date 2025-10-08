public class ListaES {

    Nodo primero;
    int cantidad;

    public ListaES(){
        this.primero = null;
        this.cantidad =0;

    }

    public boolean esVacia(){
        return this.primero == null;

    }

    public Nodo obtenerUltimo(){

        Nodo ultimo = primero;
        while(ultimo!=null)
            ultimo = ultimo.siguiente;
        return ultimo;


    }

    public boolean insertarPorPrimero(Object dato){

    }
}

package ListaDE;

public class ListaDE {

    NodoDE primero;
    int cant;

    public ListaDE() {
        this.primero = null;
        this.cant = 0;
    }

    public boolean estáVacía() {
        return this.primero == null;
    }


    public boolean insertarPorPrimero(Object o) {
        try {
            this.primero = new NodoDE(o, this.primero, null);
            if (this.primero.siguiente != null)
                this.primero.siguiente.anterior = this.primero;
            this.cant++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean insertarPorÚltimo(Object o) {
        if (this.estáVacía())
            try{
                this.primero = new NodoDE(o,null,null);
                this.cant =1;
                return true;
            } catch (Exception e){
                return false;
            }

        NodoDE último = this.getÚltimo();
        try{
            último.siguiente = new NodoDE(o);
            this.cant ++;
            return true;
        } catch (Exception e){
            return false;
        }
    }


    public boolean boorrarPorDato(Object o) {

        boolean borrado = false;
        if (this.estáVacía())
            return false;
        while (this.primero != null && this.primero.dato.equals(o)) {
            this.primero = this.primero.siguiente;
            this.primero.anterior = null;
            this.cant--;
            borrado = true;


        }
        if(this.estáVacía()) return borrado;
        NodoDE aux = this.primero;
        while (aux.siguiente != null) {
            if (aux.siguiente.dato != null)
                if (aux.siguiente.dato.equals(o)) {
                    aux.siguiente = aux.siguiente.siguiente;
                    this.cant--;
                    borrado = true;
                } else
                    aux = aux.siguiente;
            else
                aux=null;
        }
        return borrado;
    }

    public boolean insertarPorPos(int pos, Object o){
        if (pos < 0 || pos > this.cant)
            return false;
        if (pos == 0)
            return this.insertarPorPrimero(o);
        if (pos == this.cant)
            return this.insertarPorÚltimo(o);
        NodoDE aux = this.primero;
        int posInserción = 1;
        while (posInserción < pos){
            posInserción ++;
            aux = aux.siguiente;
        }
        try{
            aux.siguiente = new NodoDE(o, aux.siguiente, aux);
            this.cant ++;
            return true;
        } catch (Exception e){
            return false;
        }
    }
    public void imprimir() {
        if (this.estáVacía())
            System.out.println("No hay datos que imprimir");
        NodoDE aux = this. primero;
        while (aux != null){
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }

    public boolean borrar(int pos) {
        if (pos < 0 || pos >= this.cant)
            return false;
        if (pos == 0) {
            this.primero = this.primero.siguiente;
            if (this.primero != null)
                this.primero.anterior = null;

        } else {
            NodoDE nodoABorrar = this.primero;
            for (int posActBorrado = 0; posActBorrado != pos; posActBorrado++) {
                nodoABorrar = nodoABorrar.siguiente;
            }
            nodoABorrar.anterior.siguiente = nodoABorrar.siguiente;
            nodoABorrar.siguiente = nodoABorrar.siguiente;
            if (nodoABorrar.siguiente != null)
                nodoABorrar.siguiente.anterior = nodoABorrar.anterior;

        }
        this.cant--;
        return true;
    }
    public boolean borrarPorDato(Object dato){



    }

    private NodoDE getÚltimo() {
        NodoDE ultimo = this.primero;
        while (ultimo.siguiente != null) {
            ultimo = ultimo.siguiente;
        }
        return ultimo;
    }
}

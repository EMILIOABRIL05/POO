public class ListaDEC {
    NodoDEC primero;

    int cant;

    public ListaDEC() {
        this.primero = null;

        this.cant = 0;
    }

    public boolean estáVacía() {
        return this.primero == null;
    }

    public void vaciar() {
        this.primero = null;
        this.cant = 0;
    }

    public void imprimir() {
        if (this.estáVacía()) {
            System.out.println("No hay datos que imprimir");
            return;
        }

        NodoDEC aux = this.primero;
        do {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        } while (aux != this.primero);
    }

    public void imprimirFor() {
        if (this.estáVacía()) {
            System.out.println("No hay datos que imprimir");
            return;
        }

        NodoDEC aux = this.primero;
        for (int i = 0; i < this.cant; i++) {
            System.out.println(aux.dato);
            aux = aux.siguiente;

        }
    }

    public void imprimirUltimoPrimero() {

        NodoDEC aux = this.getÚltimo();
        do {
            System.out.println(aux.dato);
            aux = aux.anterior;
        } while (aux != this.getÚltimo());
        /*
          Nodo aux= primero.anterior;
          for(int i=0; i<
         */
    }

    private NodoDEC getÚltimo() {

        return (this.primero == null) ? null : this.primero;
/*
        if(this.estáVacía()) {
            return null;
        }
        else{
            return this.primero.anterior;
        }

         /*
        NodoDEC ultimo = this.primero;
        while (ultimo.siguiente != this.primero) {
            ultimo = ultimo.siguiente;
        }
        return ultimo;

         */
    }

    public boolean insertarPorPrimero(Object o) {
        if (o == null) return false;

        NodoDEC nuevo = new NodoDEC(o, null, null);

        if (estáVacía()) {
            nuevo.siguiente = nuevo.anterior = nuevo;

            primero = nuevo;


        } else {
            NodoDEC ultimo = getÚltimo();
            nuevo.siguiente = primero;
            nuevo.anterior = ultimo;
            ultimo.siguiente = nuevo;
            primero.anterior = nuevo;
            primero = nuevo;


        }
        cant++;

        return true;

    }


    public boolean insertarPorÚltimo(Object o) {
        if (o == null) return false;

        NodoDEC nuevo = new NodoDEC(o, null, null);

        if (estáVacía()) {
            nuevo.siguiente = nuevo;
            nuevo.anterior = nuevo;
            primero = nuevo;


        } else {
            NodoDEC ultimo = getÚltimo();
            nuevo.anterior = ultimo;
            nuevo.siguiente = primero;
            ultimo.siguiente = nuevo;
            primero.anterior = nuevo;
        }
        cant++;

        return true;
    }


    public boolean insertarPorPosicion(Object o, int pos) {

        if (o == null || pos < 0 || pos > cant) return false;
        if (pos == 0) insertarPorPrimero(o);
        if (pos == cant) insertarPorÚltimo(o);

        NodoDEC aux = primero;

        for (int i = 0; i < pos - 1; i++) {

            aux = aux.siguiente;

        }
        NodoDEC next = aux.siguiente;
        NodoDEC nuevo = new NodoDEC(o, next, aux);
        aux.siguiente = nuevo;
        next.anterior = nuevo;
        cant++;
        return true;
    }

    public boolean borrarPorPrimero() {
        if (estáVacía()) return false;

        if (cant == 1) {
            primero = null;
        } else {
            NodoDEC ultimo = primero.anterior;

            ultimo.siguiente = primero.siguiente;
            primero.siguiente.anterior = ultimo;

            primero = primero.siguiente;
        }

        cant--;
        return true;
    }


    public boolean borrarPorPos(int pos) {
        if (pos < 0 || pos >= this.cant || estáVacía()) return false;

        if (pos == 0) return borrarPorPrimero();

        NodoDEC aux = this.primero;
        for (int i = 0; i < pos; i++) {

            aux = aux.siguiente;
        }

        aux.anterior.siguiente = aux.siguiente;
        aux.siguiente.anterior = aux.anterior;

        this.cant--;
        return true;
    }


    public boolean borrarPorPosicin(int pos) {
        if (pos < 0 || pos >= this.cant) return false;
        if (estáVacía()) return false;
        if (pos == 0) return borrarPorPrimero();

        NodoDEC aux = this.primero;
        for (int i = 0; i < pos; i++) {
            aux = aux.siguiente;
        }

        aux.anterior.siguiente = aux.siguiente;
        aux.siguiente.anterior = aux.anterior;

        this.cant--;
        return true;
    }

}

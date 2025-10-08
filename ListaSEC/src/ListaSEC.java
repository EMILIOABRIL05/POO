public class ListaSEC {
    NodoSEC primero;
    int cant;

    public ListaSEC() {
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

        NodoSEC aux = this.primero;
        do {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        } while (aux != this.primero);
    }

    private NodoSEC getÚltimo() {
        if (this.estáVacía()) return null;

        NodoSEC ultimo = this.primero;
        while (ultimo.siguiente != this.primero) {
            ultimo = ultimo.siguiente;
        }
        return ultimo;
    }

    public boolean insertarPorPrimero(Object o) {

        if (this.estáVacía()) {
            try {
                this.primero = new NodoSEC(o, null);
            } catch (Exception e) {
                return false;
            }
            this.primero.siguiente = this.primero;
            this.cant = 1;
            return true;

        }
        NodoSEC ultimo = this.getÚltimo();
        try {
            ultimo.siguiente = this.primero = new NodoSEC(o, this.primero);

        } catch (Exception e) {
            return false;

        }
        this.cant++;
        return true;
    }


    public boolean borrarPorPosicion(int pos) {
        if (pos < 0 || pos >= this.cant) {
            return false;
        }

        if (pos == 0) {
            NodoSEC ultimo = this.getÚltimo();
            this.primero = this.primero.siguiente;
            ultimo.siguiente = this.primero;
        } else {
            NodoSEC anterior = this.primero;
            for (int posActualBorrado = 0; posActualBorrado < pos - 1; posActualBorrado++) {
                anterior = anterior.siguiente;
            }
            anterior.siguiente = anterior.siguiente.siguiente;
        }
        this.cant--;
        return true;
    }

    public boolean insertarPorÚltimo(Object o) {
        if (this.estáVacía()) {
            try {
                this.primero = new NodoSEC(o);
                this.primero.siguiente = this.primero;
                this.cant = 1;
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        NodoSEC último = this.getÚltimo();
        try {
            último.siguiente = new NodoSEC(o);
            último.siguiente.siguiente = this.primero;
            this.cant++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean insertarPorPos(int pos, Object o) {
        if (pos < 0 || pos > this.cant || o == null)
            return false;
        if (pos == 0)
            return this.insertarPorPrimero(o);
        if (pos == cant)
            return this.insertarPorÚltimo(o);
        NodoSEC aux = this.primero;
        int posInserción = 1;
        while (posInserción < pos) {
            posInserción++;
            aux = aux.siguiente;
        }
        try {
            aux.siguiente = new NodoSEC(o, aux.siguiente);
            this.cant++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean borrarPorDato(Object o) {
        if (this.estáVacía()) return false;
        boolean borrado = false;

        NodoSEC ultimo = this.getÚltimo();

        while (!this.estáVacía() && this.primero.dato.equals(o)) {
            if (this.primero.siguiente == this.primero) {
                this.primero = null;
            } else {

                this.primero = this.primero.siguiente;
                ultimo.siguiente = this.primero;
            }
            this.cant--;
            borrado = true;
        }

        if (this.estáVacía()) return borrado;

        NodoSEC aux = this.primero;
        do {
            if (aux.siguiente.dato.equals(o)) {
                aux.siguiente = aux.siguiente.siguiente;
                this.cant--;
                borrado = true;
            } else {
                aux = aux.siguiente;
            }
        } while (aux != this.primero);

        return borrado;
    }
}

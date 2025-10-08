package ListaLSE;


class ListaSE {
    Nodo primero;
    int cant;

    public ListaSE() {
        this.primero = null;
        this.cant = 0;
    }

    public boolean estáVacía() {

        return this.primero == null;
    }

    public void vaciar(){
        this.primero=null;
        this.cant=0;
    }

    public boolean insertarPorÚltimo(Object o) {
        if (this.estáVacía())
            try {
                this.primero = new Nodo(o);
                this.cant++;
                return true;
            } catch (Exception e) {
                return false;
            }
        Nodo último = this.getÚltimo();
        try {
            último.siguiente = new Nodo(o);
            this.cant++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void imprimir() {
        if (this.estáVacía())
            System.out.println("No hay datos que imprimir");
        Nodo aux = this.primero;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }

    public boolean insertarPorPrimero(Object o) {
        try {
            this.primero = new Nodo(o, this.primero);
            this.cant++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean insertarPorPos(int pos, Object o) {
        if (pos < 0 || pos > this.cant)
            return false;
        if (pos == 0)
            return this.insertarPorPrimero(o);
        if (pos == cant)
            return this.insertarPorÚltimo(o);
        Nodo aux = this.primero;
        int posInserción = 1;
        while (posInserción < pos) {
            posInserción++;
            aux = aux.siguiente;
        }
        try {
            aux.siguiente = new Nodo(o, aux.siguiente);
            this.cant++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean borrar(int pos) {
        if (pos < 0 || pos >= this.cant)
            return false;
        if (pos == 0) {
            this.primero = this.primero.siguiente;
            this.cant--;
            return true;
        }
        Nodo aux = this.primero;
        for (int i = 0; i < pos - 1; i++) {
            aux = aux.siguiente;
        }
        aux.siguiente = aux.siguiente.siguiente;
        this.cant--;
        return true;
    }

    public boolean boorrarPorDato(Object o) {

        boolean borrado = false;
        if (this.estáVacía())
            return false;
        while (this.primero != null && this.primero.dato.equals(o)) {
            this.primero = this.primero.siguiente;
            this.cant--;
            borrado = true;


        }
        if(this.estáVacía()) return borrado;
        Nodo aux = this.primero;
        while (aux.siguiente != null) {
            if (aux.siguiente.dato != null)
                if (aux.siguiente.dato.equals(o)) {
                    aux.siguiente = aux.siguiente.siguiente;
                    this.cant--;
                    borrado = true;
                } else
                    aux = aux.siguiente;

                aux=null;
        }
        return borrado;
    }



    private Nodo getÚltimo() {
        if (this.estáVacía()) return null;
        Nodo último = this.primero;
        while (último.siguiente != null)
            último = último.siguiente;
        return último;
    }

    public boolean cortar(int posicion){
        if(posicion<0 || posicion>=this.cant){
            return false;
        }
        if(posicion==0){
            this.primero=this.primero.siguiente;
            this.cant=0;
            return true;
        }
        Nodo aux=this.primero;
        for(int i=0;i<posicion-1;i++){

            aux=aux.siguiente;
        }
        aux.siguiente = null;
        this.cant=posicion;
        return true;


    }

}

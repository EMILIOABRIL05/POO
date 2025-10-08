public class ListaEnlazada {

    NodoSE cabeza;
    int size;


    public ListaEnlazada() {
        this.cabeza = null;
        size = 0;
    }

    public boolean estaVacia() {
        return this.cabeza == null;

    }

    public Object obtener(int index) {
        if (size == 0) {
            throw new IndexOutOfBoundsException("La lista está vacía.");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        }
        int contador = 0;
        NodoSE temp = cabeza;
        while (contador < index) {
            temp = temp.siguiente;
            contador++;

        }
        return temp.obtenerDato();
    }
    public boolean addPrimero(Object o) {

        try {
            if (estaVacia()) {
                this.cabeza = new NodoSE(o);
            } else {
                NodoSE temp = cabeza;
                NodoSE nuevo = new NodoSE(o);
                nuevo.siguiente = temp;
                cabeza = nuevo;
            }
            size++;
            return true;
        } catch (Exception e) {
        return false;
        }
    }

        public boolean addUltimo(Object o) {

            if (estaVacia())
                try {
                    this.cabeza = new NodoSE(o);
                    this.size++;
                    return true;
                } catch (Exception e) {
                    return false;
                }
                NodoSE ultimo = getUltimo();
                try{
                    ultimo.siguiente= new NodoSE(o);
                    size++;
                    return true;
                } catch (Exception e) {
                return false;
                }

            }

        public int size(){
            return size;
        }

        public NodoSE getUltimo() {
            if (estaVacia()) return null;

            NodoSE ultimo = cabeza;
            while (ultimo.siguiente != null)
                ultimo = ultimo.siguiente;
                return ultimo;
            }

        public void eliminarPrimero(){

            cabeza =cabeza.siguiente;
            size--;
        }

        public void cortar(int index){
            int contador=0;
            NodoSE temp = cabeza;
            while(contador<index-1){
                temp = temp.siguiente;
                contador++;
            }
            temp.siguiente=null;
            size = index;

        }
        public void limpiar(){
            cabeza=null;
            size=0;
        }


        public void eliminar(int index) {


        if(index==0){

            cabeza=cabeza.siguiente;
        }else {
            int contador = 0;
            NodoSE temp = cabeza;
            while (contador < index - 1) {
                temp = temp.siguiente;
                contador++;

            }
            temp.siguiente = temp.siguiente.siguiente;
        }
        size--;
        }


    }






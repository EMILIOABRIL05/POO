public class ListaSE {
    NodoSE primero;
    int cantidad;

    public ListaSE(){
        this.primero= null;
        this.cantidad=0;
    }

    public boolean estaVacia(){
        return  this.primero== null;
    }

    public boolean InsertarPrimero(Object o){
    try {
        if (estaVacia()) {
        this.primero = new NodoSE(o);
        }else{
            NodoSE temp = primero;
            NodoSE nuevo = new NodoSE(o);
            nuevo.siguiente= temp;
            this.primero= nuevo;
        }
        cantidad++;
        return true;

    } catch (Exception e) {
        return false;
    }

    }

    public NodoSE getUltimo() {
       if(estaVacia()) return null;

       NodoSE ultimo = primero;
       while(ultimo.siguiente!=null)
           ultimo = ultimo.siguiente;
       return ultimo;
    }

    public Object obtenerDato(int posicion){
        if(estaVacia()) throw new IndexOutOfBoundsException();
        if(posicion<0 || posicion>=cantidad) throw new IndexOutOfBoundsException();
        int contador=0;
        NodoSE temp = primero;
        while(contador<posicion){
            temp = temp.siguiente;
            contador++;
        }
        return temp.obtenerDato();
    }

    public boolean addUltimo(Object o){

        if(estaVacia())
            try {
                this.primero = new NodoSE(o);
                this.cantidad++;
                return true;
            }catch(Exception e){
                return false;
            }
            NodoSE ultimo= getUltimo();
            try{
                ultimo.siguiente = new NodoSE(o);
                cantidad++;
                return true;
            } catch (RuntimeException e) {
                return false;
            }

    }

    public int size(){
        return cantidad;
    }

     public boolean borrar(int posicion){
            if(posicion == 0) primero = primero.siguiente;
            int contador = 0;
            NodoSE temp = primero;
            while(contador<posicion-1){
                temp = temp.siguiente;
                contador++;
            }
            temp.siguiente = temp.siguiente.siguiente;
     }
     
}

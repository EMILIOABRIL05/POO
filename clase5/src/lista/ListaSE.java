package lista;

public class ListaSE {

     Nodo primero;
     int cant;
    public ListaSE() {
        this.primero = null;
        this.cant = 0;
    }

    public boolean estaVacia() {
        return this.primero == null;

    }

    public boolean insertarPorUltimo(Object o) {
        if (this.estaVacia())
            try {
                this.primero = new Nodo(o, null);
                return true;

            }catch (Exception e) {

                return false;
            }

        //referencia auxiliar
/*
        Nodo ultimo = this.primero;

        while (ultimo.siguiente != null)
            ultimo = ultimo.siguiente;

 */
        Nodo ultimo = this.getUltimo();
    try {
            ultimo.siguiente = new Nodo(o, null);
            this.cant++;
            return true;
        }catch (Exception e) {
            return false;
        }

    }


    public void imprimir() {
        if (this.estaVacia()) {
            System.out.println("Lista vacia");
            return;
        }
        Nodo aux = this.primero;
        while (aux != null) {
            System.out.print(aux.dato + " -> ");
            aux = aux.siguiente;
        }
        System.out.println("null");
    }


    public boolean otroInsertarPorPrimero(Object o){

       try{
        this.primero = new Nodo(o,this.primero);
        return true;
       }catch (Exception e){
        return false;
       }

    }


    public boolean insertarPorPos(int pos,Object o) {

        if (pos < 0|| pos> this.cant) return false;

        if (pos == 0) return otroInsertarPorPrimero(o);

        if (pos == cant) return insertarPorUltimo(o);

        Nodo aux = this.primero;
        int posInsercion= 1;
        while (posInsercion < pos) {
            posInsercion ++;
            aux = aux.siguiente;

        }
        try{
        aux.siguiente = new Nodo(o,aux.siguiente);
        return true;
         }catch (Exception e){
            return false;
        }
    }
    /*
    public boolean borrar(int pos){


    }

    */


    public void imprimirSaltandoUno(){

        if (this.primero == null)  return;
        Nodo aux = this.primero;
        while (aux != null){
            System.out.println(aux.dato.toString());
            if(aux.siguiente == null)
            aux= null;
            else
                aux = aux.siguiente.siguiente;
        }

    }
    private Nodo  getUltimo(){
        if (this.primero == null) return null;
        Nodo ultimo = this.primero;
        while (ultimo.siguiente != null)
            ultimo = ultimo.siguiente;
        return ultimo;
    }



}

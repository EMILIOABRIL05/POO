package ejemplo;

import org.w3c.dom.ls.LSOutput;

//Este es un comentario en linea , una vez que presione enter, se termina.
/*
 *comentario de bloque
 * sirve para comentar mas de una linea y esta limitada por el asterisco y el slash
 * permite agregar mas informacion
 */
//Clase que define una direccion para un usuario
public class Direccion {

 //String define el nombre de la calle donde esta la direccion
    private String calle;
    //String que identifica cual es la ubicacioon de la direccion en la calle
    private String numero;

    //Constructor por defecto riguroso puede no existir
    // y la clase aun puede ser instanciada con valores nulos.Puede ser omitido y genera mismo resultado
    public Direccion() {//constructor por defecto con definiciones generricas

        this.calle = "Principal";
        this.numero = "Numero";



    }
    //constructores por parametros
    public Direccion(String numero) {
        this.calle = "Principal";
        this.numero = numero;
    }
    public Direccion(String calle, String numero) {
        this.calle = calle;
        this.numero = numero;

    }
    public String getNumero() {
        return numero;

    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void ImprimeDireccion() {
        System.out.println(this.calle+" "+this.numero);
    }
}

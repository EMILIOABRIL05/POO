package calculadoraClase;

public class Dividir {
    public double calcular(double x, double y) {

       if(y==0) {
           throw new ArithmeticException("No se peude dividir para cero");//genera una excepcion , lo trata como excepcion

       }

       return x/y;
    }

}

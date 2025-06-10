package ejemplos;
import java.util.ArrayList;

public class PromedioNotasList {
    
    
    private static ArrayList<Double> notas = new ArrayList<>();
    
    //Recibe una cantidad variable de parametros de tipo definido y que se invocan en cada ejecucion 
    private static double promedio(double...numeros){
        
        if(numeros.length==0) {
            
         throw new IllegalArgumentException("Se reeuieres al menos una calificacion para poder realizar el promedio");         
        }
        
        for(double i:numeros) {
            
            notas.add(i);
        }
        double suma = 0;
        
        for(double i: notas) {
            
            suma =suma + i;
        }
        return suma/notas.size();
    }
    
    private static ArrayList<Double> getRegistro(){
        return notas;
    }
    public static void main(String[] args) {


        double a = 5.6;
        double b = 5.7;
        double c = 5.8;
        double d = 5.9;
        double e = 6.0;
        double f = 6.1;
        double g = 6.2;
        double h = 6.3;
        double i = 6.4;


        System.out.printf("Promedio 1: %.2f%n",promedio(a,b,c,h,i));
        System.out.printf("Promedio 2: %.2f%n",promedio(a,b,e,f,i));
        System.out.printf("Promedio 3: %.2f%n",promedio(g,c,e,h,i));
        System.out.println(getRegistro().toString());
    }
}

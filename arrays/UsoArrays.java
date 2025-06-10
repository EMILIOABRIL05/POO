package arrays;
import java.util.Arrays;
// es una biblioteca estatica


public class UsoArrays {

    private static void mostrarArreglo(int[] arreglo,String desc) {

        System.out.printf("%n%s: %n",desc);

        for(int jum: arreglo){

            System.out.printf("%d ",jum);
        }
    }
    public static void main(String[] args) {

        int [] numeros = new int[]{1,2,3,4,5,6,7,8,9,8,8,7,7,7,7,5};
        mostrarArreglo(numeros,"Numeros");
        System.out.println();

        System.out.println(Arrays.toString(numeros));//

        Arrays.sort(numeros);//ordena el arreglo
        System.out.println(Arrays.toString(numeros));

        int a= Arrays.binarySearch(numeros,9);// siempre debe estar ordenado el arreglo, me da un numero negativo
        System.out.println(a);

        int[] contantes =new int[10];
        Arrays.fill(contantes,8);
        System.out.println(Arrays.toString(contantes));

        int[] numeros2 = new int[]{1,2,3,4,5,6,7,8,9};
        int [] numeros3 = new int[numeros2.length];

        System.arraycopy(numeros2,0,numeros3,0,numeros2.length-1);

        mostrarArreglo(numeros2,"Origen");
        mostrarArreglo(numeros3,"Destino");

        int []positivos = new int[]{0,10,20,30,40,50,60,70,80,90};
        int []negativos = new int[]{-90,-80,-70,-60,-50,-40,-30,-20,-10};

        mostrarArreglo(positivos,"Positivo");
        mostrarArreglo(negativos,"Negativo");

        System.out.println(Arrays.toString(positivos));
        System.out.println(Arrays.toString(negativos));

        int[] todos = new int[positivos.length+negativos.length];
        System.arraycopy(negativos,0,todos,0,negativos.length);
        System.out.println(Arrays.toString(todos));
        System.arraycopy(positivos,0,todos,negativos.length,positivos.length); // copia directamente los contenidos de un arreglo
        System.out.println(Arrays.toString(todos));
    }

}

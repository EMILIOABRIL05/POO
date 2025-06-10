package control;
import java.util.Scanner;
public class ForEjercicios {
    public static void main(String[] args) {

        /*
        //sumar los cuadrados de todos los numeros dentro del lazo
        int n=0;
        int suma=0;
   Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        n=sc.nextInt();
        sc.nextInt();
         for(int i=1; i<=n; i++){

        int cuadrado=i*i;
        suma=suma + cuadrado;


         }
        System.out.printf("la suma de los cuadrados de los numeros del 1 al %d es %d.%n",n,suma);
         */
        //programa que calcula todos los numeros  de fibonacci  hata un limite

        int a=0,b=1,limite,temp;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un limite: ");

        limite=sc.nextInt();
        sc.nextLine();

        System.out.printf("Serie de fibonacci hasta el limite  de %d.%n",limite);
        System.out.printf("%d %d",a,b);

        /*for(;;){
            temp=a +b;
             if (temp >limite){
                 break;
             }
            System.out.printf(" %d",temp);
             a=b;
             b=temp;


        }*/
        for(temp=a+b; temp<limite; temp=a+b){

            System.out.printf(" %d",temp);
            a=b;
            b=temp;


        }
        sc.close();
    }
}

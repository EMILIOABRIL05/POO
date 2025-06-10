package control;

import java.util.Scanner;
import java.util.Locale;
import java.security.SecureRandom;

public class DoWhile {
    public static void main(String[] args) {

        //Juego de adivinar el numero. Si luego de tres intentos de adivinar no se logra, se pierde el juergo

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        /*
        SecureRandom sec = new SecureRandom();

        int numeroSecretos = sec.nextInt(10);
        int intento = 0;
        int contador = 0;
        int maxIntentos= 3;

        do{

            contador++;
            System.out.printf("Intento: %d de %d - Ingrese un numero entre 1 y 10: ", contador,maxIntentos);
            intento = sc.nextInt();
            sc.nextLine();

            if(intento < numeroSecretos){

                System.out.println("El numero es mayor.");
            } else if (intento > numeroSecretos) {

                System.out.println("El numero es menor.");
            }else {
                System.out.println("Felicitaciones, usted ha adivinado.");
                break;
            }
        }while(contador < maxIntentos);
        if(intento != numeroSecretos){

            System.out.printf("Intentos agotados, el numero a adivinar era: %d", numeroSecretos);
        }

        sc.close();

*/
     //programa que me permite sumar numerros consecutivos hasta un limite.
     int  suma=0;
      int numero=0;
      do {
          System.out.print("Ingrese un numero positivo a ser sumado: ");
          numero = sc.nextInt();
          sc.nextLine();

         if (numero<0){
             System.out.println("el numero no puede ser negativo, intente nuevamente");
             continue;
         }
         suma=suma+numero;
          System.out.printf("La suma actual es: %d.%n",suma);

      }while (numero<=100);

        System.out.printf("Se ha llegado  al limite , la ultima suma es: %d.%n",suma);


    }
}

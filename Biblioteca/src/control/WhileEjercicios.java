package control;
import java.util.Scanner;
import java.util.Locale;
public class WhileEjercicios {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        /*//programa el primer numero divisible para 4 y 9 , a partir de un numero dado
         int numero;
         int resultado=0;
         boolean salida = true;
        System.out.println("Ingrese un numero: ");
        numero = sc.nextInt();
        sc.nextLine();

        resultado = numero;
        //while true es un bucle infinito
        while (salida) {//salida es lo mismo qeu salida== true ; !salida es lo mismo  que salida == false
            if(resultado%4==0 || resultado%9==0){
                System.out.printf("El primero numero mayor que %d que cumple  el requerimiento es %d%n",numero,resultado);
                salida = false;
            }
            resultado ++;
        }
*/

        // programa que permite el calculo de una potencia
int base ,exponente, contador;
long resultado;
base=0;
contador=0;
exponente=0;
resultado=1;

        System.out.println("Ingrese la base: ");
        base= sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el exponente: ");
        exponente = sc.nextInt();
        sc.nextLine();

        while(contador < exponente){
            resultado =resultado*base;//esto es igual a escribir  resultado *=base
           contador++;

        }
        System.out.printf("El resultado de elevar %d a %d es : %d.%n ",base,exponente,resultado);
        }
    }
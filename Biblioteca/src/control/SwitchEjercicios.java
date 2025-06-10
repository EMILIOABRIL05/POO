package control;

import org.w3c.dom.ls.LSOutput;

import java.util.Locale;
import java.util.Scanner;

public class SwitchEjercicios {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        /*

        // Definir una calculadora sencilla que haga una operacion (+,-,*,/) y termine.

        double oper1, oper2;
        double resultado = 0;
        char operacion;

        System.out.print("Ingrese el primer operando: ");
        oper1 = sc.nextDouble();
        sc.nextLine();
        System.out.print("Ingrese el segundo operando: ");
        oper2 = sc.nextDouble();
        sc.nextLine();
        System.out.print("Ingrese la operacion (+,-,*,/): ");
        operacion = sc.next().charAt(0);
        sc.nextLine();

        switch (operacion) {

            case ('+'):
                resultado = oper1 + oper2;
                break;
            case ('-'):
                resultado = oper1 - oper2;
                break;
            case ('*'):
                resultado = oper1 * oper2;
                break;
            case ('/'):
                if (oper2 == 0) {
                    System.out.println("Error: no se puede dividir para 0");
                    return;
                } else {
                    resultado = oper1 / oper2;
                }
                break;
            default:
                System.out.println("Opcion no valida");
                return;
        }
        System.out.printf("El resultado obtenido es %.2f.%n", resultado);

        double estatura, peso;
        double imc = 0;
        System.out.print("Ingrese el peso en kilogramos: ");
        peso = sc.nextDouble();
        sc.nextLine();
        System.out.print("Ingrese la estatura en metros: ");
        estatura = sc.nextDouble();
        sc.nextLine();
        char opcion=' ';

        imc = peso / (estatura * estatura);
        System.out.println("El resultado es: " + imc);

        if (imc < 18.5) {
           opcion='a';

        }else if (imc <= 25) {
          opcion='b';
        }else if (imc <= 30) {
         opcion='c';
        }else if (imc <= 40) {
        opcion='d';
        }
switch (opcion){
            case 'a':
                System.out.println("Calificacion: Bajo peso");
                break;
            case 'b':
                System.out.println("Calificacion: Peso Normal");
                break;
            case 'c':
                System.out.println("Calificacion: Sobrepeso");
                break;
    default:
        System.out.println("Calificacion: Obesidad");
      break;
      */

        //Aplicacion que permite el cambio de notas numericas  a rango americano
        double nota;
        char cambio;
        int opcion;
        System.out.println("Ingrese la nota a convertir: ");
        nota = sc.nextDouble();
        sc.nextLine();
        opcion = 1+(int) ((9.9-nota)/1.5);

       switch (opcion){
           case (0):
               cambio = 'A';
               break;
               case (1):
               cambio = 'B';
               break;
               case (2):
               cambio = 'C';
               break;
               case (3):
               cambio = 'D';
               break;
           case (4):
               cambio = 'E';
               break;
               default:
                   cambio = 'F';
       }
        System.out.println("La calificacion final es del tipo: " + cambio + ".");


       int numero =0;
       int otroNumero =0;
        System.out.println("Ingrese un numero: ");
        numero = sc.nextInt();
        sc.nextLine();
        switch (numero){
            case(1):
            case(3):
                case (5):
                case (7):
                case (9):
                otroNumero = 1;

                break;
            case(2):
                case (4):
                case (6):
                case (8):
                case (10):
                otroNumero = 2;
                break;
            default:
                System.out.println("Numero no valido");
        }
        System.out.println("El numero es: " + otroNumero);
      }

}



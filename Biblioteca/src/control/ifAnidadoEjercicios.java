package control;

import java.util.Scanner;
import java.util.Locale;

public class ifAnidadoEjercicios {

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

        //System.out.println(oper1 + " " + oper2 + " " + operacion); para comprobacion

        //variable que se llama operacion

        if (operacion == '+'){
            resultado = oper1+oper2;
        } else if (operacion == '-') {
            resultado = oper1-oper2;
        }else if (operacion == '*'){
            resultado = oper1*oper2;
        } else if (operacion == '/') {
            if (oper2 == 0){
                System.out.println("Error: no se puede dividir entre 0");
            } else{
                resultado = oper1/oper2;
            }
        } else {
            System.out.println("Operación no valida.");
            return; //significa que es la ultima linea de codigo
        }

        System.out.printf("El resultado obtenido es %.2f.%n",resultado);

         */
        // Aplicacion que calcule el índice de masa corporal en una persona
/*
        double estatura, peso;
        double imc = 0;
        System.out.print("Ingrese el peso en kilogramos: ");
        peso = sc.nextDouble();
        sc.nextLine();
        System.out.print("Ingrese la estatura en metros: ");
        estatura = sc.nextDouble();
        sc.nextLine();

        imc = peso / (estatura * estatura);
        System.out.println("El resultado es: " + imc);

        if (imc < 18.5) {
            System.out.println("Calificacion: Bajo peso");

        }else if (imc <= 25) {
            System.out.println("Calificacion: Peso Normal");
        }else if (imc <= 30) {
            System.out.println("Calificacion: Sobrepeso");
        }else if (imc <= 40) {
            System.out.println("Calificacion: Obesidad");
        }
*/
        //Aplicacion que permite el cambio de notas numericas  a rango americano
        double nota;
        char cambio;
        System.out.println("Ingrese la nota a convertir: ");
        nota = sc.nextDouble();
        sc.nextLine();
        if (nota == 10) {
            cambio = 'A';

        } else if (nota >= 8.5) {
            cambio = 'B';
        } else if (nota >= 7) {
            cambio = 'C';
        } else if (nota >= 5.5) {
            cambio = 'D';
        } else if (nota >= 4) {
            cambio = 'E';
        } else {
            cambio = 'F';

        }
        System.out.println("La calificacion final es del tipo: " + cambio + ".");
    }
}
package calculadoraMain;

import java.util.Scanner;
import java.util.Locale;
import java.lang.Math;

public class Calculadora {

    private static double sumar(double x, double y) {

        return x + y;
    }

    private static double restar(double x, double y) {

        return x - y;
    }

    private static double multiplicar(double x, double y) {

        return x * y;
    }

    private static double dividir(double x, double y) {

        if (y == 0) {

            System.out.println("No se puede dividir para cero.");
            return Double.NaN;//not a nan

        }

        return x / y;
    }

    private static double potencia(double x, double y) {

        return Math.pow(x, y);
    }

    private static double modulo(double x, double y) {

        return x % y;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        int opcion;
        double x,y, resultado;

        System.out.println("Calculadora: ");
        System.out.print("Ingrese el primer numero: ");
        x = sc.nextDouble();
        sc.nextLine();
        System.out.print("Ingrese el segundo numero: ");
        y = sc.nextDouble();
        sc.nextLine();


        opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {

            case (1):
                resultado = sumar(x, y);
                break;
            case (2):
                resultado = restar(x, y);
                break;
            case (3):
                resultado = multiplicar(x, y);
                break;
            case (4):
                resultado = dividir(x, y);
                break;
            case (5):
                resultado = potencia(x, y);
                break;
            case (6):
                resultado = modulo(x, y);
                break;
            default:
                System.out.println("Operacion invalida.");
                sc.close();
                return;
        }

        System.out.printf("Resultado: %.2f.%n", resultado);
        sc.close();

    }
}
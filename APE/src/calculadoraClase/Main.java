package calculadoraClase;
import java.util.Scanner;
import java.util.Locale;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int numOper;

        // Validacion para saber si un numero es valido
        // Ingresar el numero de operaciones a realizar
        do {
            System.out.print("Ingrese el numero de operaciones a realizar: ");
            numOper = sc.nextInt();
            sc.nextLine();
            if (numOper <= 0) {
                System.out.println("No se pueden tener operaciones negativas.");
            }
        } while (numOper <= 0);

        lazo1:
        // Es una etiqueta / lazos solamente con for, do-while, while
        for (int i = 1; i <= numOper; i++) {

            System.out.printf("Operacion #%d.%n", i);

            int opcion;
            lazo2:
            do {
                System.out.print(
                        "1. Sumar.\n2. Restar.\n3. Multiplicar.\n4. Dividir.\n5. Potencia.\n6. Modulo.\n7. Salir.\nSeleccione una opcion: "
                ); // \n para enter
                opcion = sc.nextInt();
                sc.nextLine();

                if (opcion < 1 || opcion > 7) {
                    System.out.println("Opcion invalida, intentelo de nuevo.");
                }

            } while (opcion < 1 || opcion > 7);

            if(opcion==7){

            System.out.println("Saliendo de la calculatora.");
            break lazo1;//solo rompe a los lazos que tiene dentro
        }
            System.out.print("Ingrese el primer numero: ");
            double x = sc.nextDouble();
            sc.nextLine();
            System.out.print("Ingrese el segundo numero: ");
            double y = sc.nextDouble();
            sc.nextLine();

            double resultado = 0;
            switch (opcion) {

                case (1):
                    resultado = new Sumar(x, y).calcular();
                    break;

                case (2):
                    resultado = new Restar().calcular(x, y);
                    break;

                case (3):
                    resultado = new Multiplicar().multiplicar(x, y);
                    break;

                case (4):
                    try {
                        resultado = new Dividir().calcular(x, y);
                    } catch (ArithmeticException e) {
                        System.out.println("Error de la operacion: " + e.getMessage());
                    }
                    break;

                case (5):
                    resultado = new Potencia().calcular(x, y);
                    break;

                case (6):
                    resultado = new Modulo().calcular(x, y);
                    break;
            }
            System.out.printf("El resultado es: %.2f.%n", resultado);
        }
        sc.close();
        System.out.println("Saliendo de la calculadora.");


    }
}

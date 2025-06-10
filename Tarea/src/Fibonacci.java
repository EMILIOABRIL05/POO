import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        int a = 0, b = 1, limite, temp = 0;

        Scanner sc = new Scanner(System.in);

        // Solicita al usuario ingresar el límite final para la serie
        System.out.println("Ingrese el limite final: ");
        limite = sc.nextInt();
        sc.nextLine();

        System.out.printf("Serie de Fibonacci hasta el limite de %d.%n", limite);
        // Imprime los dos primeros números de la serie de Fibonacci
        System.out.printf("%d %d ", a, b);

        do {
            // Calcula el siguiente número en la serie
            temp = a + b;

            // Verifica si el siguiente número supera el límite ingresado por el usuario
            if (temp > limite) {
                break; // Sale del ciclo si supera el límite
            }

            // Imprime el número calculado
            System.out.printf("%d ", temp);
            // Actualiza los valores de a y b para avanzar en la serie
            a = b;
            b = temp;

        } while (limite > temp); // Repite mientras el límite no sea superado

        sc.close(); 
    }
}

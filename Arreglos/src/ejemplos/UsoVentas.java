package ejemplos;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Locale;

public class UsoVentas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        double[] ventas = new double[10];
        System.out.println("Las mejores ventas del mes: ");
        for(int i = 0; i< ventas.length;i++) {

            System.out.printf("Nueva venta declarada numero %d: ",i+1);

            try {

                ventas[i] = sc.nextDouble();

            }catch(InputMismatchException e) {

                System.out.printf("%s: Valor mal ingresado.",e.getMessage());
                --i;
            }catch(Exception e) {

                System.out.printf("%s: Excepcion capturada.",e.getMessage());
            } finally {

                sc.nextLine();
            }
        }

        for(double venta: ventas) {

            System.out.printf("- %.2f%n",venta);
        }
    }
}

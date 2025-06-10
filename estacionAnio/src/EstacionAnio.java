import java.util.Scanner;
import java.util.Locale;

public class EstacionAnio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        // Solicitar día y mes con mensajes previos
        System.out.println("Ingrese el dia: ");
        int dia = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese el mes del 1 al 12: ");
        int mes = sc.nextInt();

        sc.nextLine();

        // Variable para almacenar la estación
        String estacion = "";

    sc.nextLine();
        // Verificación de rango de mes
        if (mes >= 1 && mes <= 12) {
            // Lógica para determinar la estación
            if ((mes == 3 && dia >= 18) || mes == 4 || mes == 5 || (mes == 6 && dia <= 18)) {
                estacion = "Otoño";
            } else if ((mes == 6 && dia >= 18) || mes == 7 || mes == 8 || (mes == 9 && dia <= 18)) {
                estacion = "Invierno";
            } else if ((mes == 9 && dia >= 18) || mes == 10 || mes == 11 || (mes == 12 && dia <= 18)) {
                estacion = "Primavera";
            } else {
                estacion = "Verano";
            }

            // Imprimir la estación
            System.out.println("La estación es: " + estacion);
        } else {
            // Mensaje de error para mes inválido
            System.out.println("Mes inválido. Debe ser un número entre 1 y 12.");
        }


        sc.close();
    }
}
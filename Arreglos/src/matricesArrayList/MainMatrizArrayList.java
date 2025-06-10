package matricesArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMatrizArrayList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("=== MULTIPLICACIÓN DE MATRICES CON ARRAYLIST ===");

            // Solicita las dimensiones de ambas matrices (filas y columnas)
            int filasA    = leerEntero(scanner, "Ingrese el número de filas de la primera matriz: ");
            int columnasA = leerEntero(scanner, "Ingrese el número de columnas de la primera matriz: ");
            int filasB    = leerEntero(scanner, "Ingrese el número de filas de la segunda matriz: ");
            int columnasB = leerEntero(scanner, "Ingrese el número de columnas de la segunda matriz: ");

            // Valida si las matrices son compatibles para multiplicación:
            // El número de columnas de A debe ser igual al número de filas de B
            if (columnasA != filasB) {
                System.out.println("\nError: No se pueden multiplicar.");
                System.out.println("Las columnas de la primera matriz deben coincidir con las filas de la segunda.");
                return; // termina el programa si no son compatibles
            }

            // Crea ambas matrices con sus dimensiones respectivas
            MatrizArrayList m1 = new MatrizArrayList(filasA, columnasA);
            MatrizArrayList m2 = new MatrizArrayList(filasB, columnasB);

            // Llenado manual de los valores de la primera matriz
            System.out.println("\nIngrese los valores para la primera matriz:");
            llenarMatriz(scanner, m1);
            System.out.println("\nMatriz 1 ingresada:");
            System.out.print(m1.toFormattedString());

            // Llenado manual de los valores de la segunda matriz
            System.out.println("\nIngrese los valores para la segunda matriz:");
            llenarMatriz(scanner, m2);
            System.out.println("\nMatriz 2 ingresada:");
            System.out.print(m2.toFormattedString());

            // Multiplicación de matrices y visualización del resultado
            System.out.println("\nResultado de la multiplicación:");
            MatrizArrayList r = OperacionesArrayList.multiplicar(m1, m2);
            System.out.print(r.toFormattedString());

        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        } finally {
            scanner.close(); // siempre cerrar el scanner al final del uso
        }
    }

    /**
     * Método auxiliar para leer un número entero mayor que cero.
     * Muestra un mensaje personalizado y valida entrada del usuario.
     */
    private static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int v = scanner.nextInt();
                if (v > 0) return v;
                System.out.println("Error: Debe ser mayor que cero.");
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un entero válido.");
                scanner.nextLine(); // limpia el buffer del scanner
            }
        }
    }

    /**
     * Llenado de valores en la matriz especificada, elemento por elemento.
     * Valida que cada valor ingresado sea un número entero.
     */
    private static void llenarMatriz(Scanner scanner, MatrizArrayList m) {
        for (int i = 0; i < m.getFilas(); i++) {
            for (int j = 0; j < m.getColumnas(); j++) {
                while (true) {
                    try {
                        System.out.print("Elemento[" + i + "][" + j + "]: ");
                        m.setValor(i, j, scanner.nextInt());
                        break; // sale del while si el valor fue válido
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Ingrese un entero.");
                        scanner.nextLine(); // limpia el buffer del scanner
                    }
                }
            }
        }
    }
}

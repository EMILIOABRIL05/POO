package matrices;

import java.util.Scanner;
import java.util.Locale;
import java.util.InputMismatchException;

public class MainMatriz {

    private static Scanner sc = new Scanner(System.in);
    private static Operacion op = new Operacion();


    /*
     * Metodo que llena una matriz solicitando valores al usuario.
     * Recorre cada posición de la matriz y solicita un valor entero válido.
     * Si se ingresa un valor no válido, muestra un mensaje de error y vuelve a solicitar el valor.
     */
    private static void llenarMatriz(Matriz a) {
        for (int i = 0; i < a.getFilas(); i++) {
            for (int j = 0; j < a.getColumnas(); j++) {
                boolean valorValido = false;
                while (!valorValido) {
                    try {
                        System.out.printf("Elemento[%d][%d]: ", i, j);
                        a.getMatriz()[i][j] = sc.nextInt();
                        sc.nextLine();
                        valorValido = true; // Si llegamos aquí, el valor es válido
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Debe ingresar un número entero válido.");
                        sc.nextLine(); // Limpiar el buffer del scanner
                        // El ciclo continuará pidiendo el mismo elemento
                    }
                }
            }
        }
    }

    /*
     * Metodo que lee desde el teclado las dimensiones de una matriz y crea una nueva matriz.
     * Maneja la validación de entrada para asegurar que se ingresen números enteros válidos
     * y que las dimensiones sean apropiadas para una matriz.
     */
    private static Matriz leerMatriz() {
        while (true) {
            try {
                System.out.println("Ingrese los valores para la matriz: ");
                System.out.print("Filas: ");

                // Validar entrada de enteros
                while (!sc.hasNextInt()) {
                    System.out.println("Error: Debe ingresar un número entero válido");
                    sc.nextLine(); // Descartar entrada inválida
                    System.out.print("Filas: ");
                }
                int a = sc.nextInt();
                sc.nextLine();

                System.out.print("Columnas: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Error: Debe ingresar un número entero válido");
                    sc.next(); // Descartar entrada inválida
                    System.out.print("Columnas: ");
                }
                int b = sc.nextInt();
                sc.nextLine();

                // Crear matriz, lo que lanzará una excepción si los valores son inválidos
                return new Matriz(a, b);
            } catch (IllegalArgumentException e) {
                // Capturar y mostrar el mensaje de error específico
                System.out.println("Error: " + e.getMessage());
                System.out.println("Por favor, intente de nuevo.");
                // El ciclo continuará pidiendo nuevas matrices
            }
        }
    }

    public static void main(String[] args) {
        sc.useLocale(Locale.US);

        // Ciclo para validar las matrices
        while (true) {
            try {
                Matriz m = leerMatriz();
                Matriz n = leerMatriz();

                // Validación de dimensiones para multiplicación
                if (m.getColumnas() == n.getFilas()) {
                    System.out.println("Ingrese los valores de la primera matriz: ");
                    llenarMatriz(m);
                    System.out.println(m.toString());

                    System.out.println("Ingrese los valores de la segunda matriz: ");
                    llenarMatriz(n);
                    System.out.println(n.toString());

                    Matriz p = op.multiplicar(m, n);
                    System.out.println("El resultado es: ");
                    System.out.println(p.toString());

                    // Salir del ciclo después de una multiplicación exitosa
                    break;
                } else {
                    System.out.println("Error: Las dimensiones de las matrices no son compatibles para multiplicación.");
                    System.out.println("Por favor, ingrese nuevamente las matrices.");
                }
            } catch (IllegalArgumentException e) {
                // Capturar específicamente las excepciones de dimensiones inválidas
                System.out.println("Error: " + e.getMessage());
                System.out.println("Por favor, intente de nuevo.");
            } catch (InputMismatchException e) {
                // Capturar excepciones de entrada inválida
                System.out.println("Error: Entrada inválida detectada.");
                System.out.println("Por favor, intente de nuevo.");
                sc.nextLine(); // Limpiar el buffer del scanner
            }
        }
    }

}
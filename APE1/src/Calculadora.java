import java.util.Scanner;

public class Calculadora {
    // Scanner para leer entrada del usuario
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        boolean continuar = true;

        System.out.println("CALCULADORA BÁSICA");

        while (continuar) {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: // Suma
                    realizarSuma();
                    break;
                case 2: // Resta
                    realizarResta();
                    break;
                case 3: // Multiplicación
                    realizarMultiplicacion();
                    break;
                case 4: // División
                    realizarDivision();
                    break;
                case 5: // Salir
                    continuar = false;
                    System.out.println("¡Gracias por usar la calculadora!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

            System.out.println(); // Línea en blanco para separar operaciones
        }

        scanner.close();
    }

    // Método para mostrar el menú
    public static void mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Salir");
    }

    // Método para leer un entero
    public static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            System.out.print(mensaje);
            scanner.next(); // Limpiar el scanner
        }
        return scanner.nextInt();
    }

    // Método para leer un double
    public static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor, ingrese un número válido.");
            System.out.print(mensaje);
            scanner.next(); // Limpiar el scanner
        }
        return scanner.nextDouble();
    }

    // Método para realizar la suma
    public static void realizarSuma() {
        System.out.println("\n--- SUMA ---");
        double num1 = leerDouble("Ingrese el primer número: ");
        double num2 = leerDouble("Ingrese el segundo número: ");
        double resultado = suma(num1, num2);
        System.out.println("El resultado de " + num1 + " + " + num2 + " es: " + resultado);
    }

    // Método para calcular la suma
    public static double suma(double a, double b) {
        return a + b;
    }

    // Método para realizar la resta
    public static void realizarResta() {
        System.out.println("\n--- RESTA ---");
        double num1 = leerDouble("Ingrese el primer número: ");
        double num2 = leerDouble("Ingrese el segundo número: ");
        double resultado = resta(num1, num2);
        System.out.println("El resultado de " + num1 + " - " + num2 + " es: " + resultado);
    }

    // Método para calcular la resta
    public static double resta(double a, double b) {
        return a - b;
    }

    // Método para realizar la multiplicación
    public static void realizarMultiplicacion() {
        System.out.println("\n--- MULTIPLICACIÓN ---");
        double num1 = leerDouble("Ingrese el primer número: ");
        double num2 = leerDouble("Ingrese el segundo número: ");
        double resultado = multiplicacion(num1, num2);
        System.out.println("El resultado de " + num1 + " * " + num2 + " es: " + resultado);
    }

    // Método para calcular la multiplicación
    public static double multiplicacion(double a, double b) {
        return a * b;
    }

    // Método para realizar la división
    public static void realizarDivision() {
        System.out.println("\n--- DIVISIÓN ---");
        double num1 = leerDouble("Ingrese el numerador: ");
        double num2 = leerDouble("Ingrese el denominador: ");

        if (num2 == 0) {
            System.out.println("Error: No se puede dividir por cero.");
            return;
        }

        double resultado = division(num1, num2);
        System.out.println("El resultado de " + num1 + " / " + num2 + " es: " + resultado);
    }

    // Método para calcular la división
    public static double division(double a, double b) {
        return a / b;
    }
}

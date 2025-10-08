package figuras;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GestorFiguras gestor = new GestorFiguras();

    public static void main(String[] args) {
        boolean salir = false;

        System.out.println("Bienvenido al Gestor de Figuras Geométricas");

        while (!salir) {
            mostrarMenu();
            int opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    registrarFigura();
                    break;
                case 2:
                    eliminarFigura();
                    break;
                case 3:
                    mostrarAreaTotal();
                    break;
                case 4:
                    mostrarAreaPromedio();
                    break;
                case 5:
                    gestor.listarFiguras();
                    break;
                case 6:
                    ordenarPorArea();
                    break;
                case 7:
                    salir = true;
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===== MENÚ PRINCIPAL =====");
        System.out.println("1. Registrar figura");
        System.out.println("2. Eliminar figura");
        System.out.println("3. Calcular área total");
        System.out.println("4. Calcular área promedio");
        System.out.println("5. Listar figuras");
        System.out.println("6. Ordenar por área");
        System.out.println("7. Salir");
        System.out.println("=========================");
    }

    private static void registrarFigura() {
        if (gestor.getCantidadFiguras() >= 40) {
            System.out.println("Error: Límite de 40 figuras alcanzado.");
            return;
        }

        System.out.println("\n-- Registrar Figura --");
        System.out.println("1. Círculo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Rectángulo");

        int tipo = leerEntero("Tipo: ");

        switch (tipo) {
            case 1:
                double radio = leerDouble("Radio: ");
                if (radio <= 0) {
                    System.out.println("Error: El radio debe ser positivo.");
                    return;
                }
                gestor.insertarFigura(new Circulo(radio));
                break;
            case 2:
                double lado = leerDouble("Lado: ");
                if (lado <= 0) {
                    System.out.println("Error: El lado debe ser positivo.");
                    return;
                }
                gestor.insertarFigura(new Cuadrado(lado));
                break;
            case 3:
                double base = leerDouble("Base: ");
                double altura = leerDouble("Altura: ");
                if (base <= 0 || altura <= 0) {
                    System.out.println("Error: Base y altura deben ser positivas.");
                    return;
                }
                gestor.insertarFigura(new Rectangulo(base, altura));
                break;
            default:
                System.out.println("Tipo de figura no válido.");
                return;
        }
        System.out.println("Figura registrada con éxito.");
    }

    private static void eliminarFigura() {
        if (gestor.getCantidadFiguras() == 0) {
            System.out.println("No hay figuras para eliminar.");
            return;
        }

        gestor.listarFiguras();
        int indice = leerEntero("Número de figura a eliminar: ") - 1;

        if (gestor.eliminarFigura(indice)) {
            System.out.println("Figura eliminada con éxito.");
        } else {
            System.out.println("Error: Número de figura inválido.");
        }
    }

    private static void mostrarAreaTotal() {
        System.out.printf("Área total: %.2f\n", gestor.calcularAreaTotal());
    }

    private static void mostrarAreaPromedio() {
        System.out.printf("Área promedio: %.2f\n", gestor.calcularAreaPromedio());
    }

    private static void ordenarPorArea() {
        gestor.ordenarPorArea();
        System.out.println("Figuras ordenadas por área:");
        gestor.listarFiguras();
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Error: Debe ingresar un número entero.");
            scanner.next();
            System.out.print(mensaje);
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    private static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.println("Error: Debe ingresar un número válido.");
            scanner.next();
            System.out.print(mensaje);
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }
}

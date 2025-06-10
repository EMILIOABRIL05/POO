import java.util.Scanner;
 class Utilidades {
    public static int pedirRondas(Scanner sc) throws Exception {
        System.out.print("Ingrese el número de rondas: ");
        if (!sc.hasNextInt()) {
            throw new Exception("Debe ingresar un número entero.");
        }
        int rondas = sc.nextInt();
        if (rondas <= 0) {
            throw new Exception("El número de rondas debe ser mayor que cero.");
        }
        return rondas;
    }

    public static int jugar(int rondas) {
        Dados dado1 = new Dados();
        Dados dado2 = new Dados();
        int puntosTotales = 0;

        for (int i = 1; i <= rondas; i++) {
            dado1.lanzar();
            dado2.lanzar();

            int val1 = dado1.getValor();
            int val2 = dado2.getValor();
            int sumaDados = val1 + val2;

            System.out.printf("Ronda %d: Dado1 = %d, Dado2 = %d → ", i, val1, val2);

            if (val1 == 1 && val2 == 1) {
                puntosTotales = 0;
                System.out.println("¡Barbuja! Pierdes todo el puntaje acumulado.");
            } else if (val1 == 1 || val2 == 1) {
                System.out.println("Uno de los dados es 1. No sumas puntos esta ronda.");
            } else {
                puntosTotales += sumaDados;
                if (sumaDados == 6) {
                    puntosTotales *= 2;
                    System.out.println("Suma 6: ¡Duplicas tu total acumulado!");
                } else if (sumaDados == 12) {
                    puntosTotales += 1;
                    System.out.println("Suma 12: ¡Ganas 1 punto extra!");
                } else {
                    System.out.println("Sumas " + sumaDados + " puntos.");
                }
            }

            System.out.println("Total acumulado: " + puntosTotales + "\n");
        }

        return puntosTotales;
    }





}

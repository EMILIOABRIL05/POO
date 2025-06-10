import java.util.Scanner;

public class JuegoBarbuja {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el número de rondas: ");
        int rondas;

        // Validación básica de entrada
        while (true) {
            if (sc.hasNextInt()) {
                rondas = sc.nextInt();
                if (rondas > 0) break;
            } else {
                sc.next(); // limpia entrada no numérica
            }
            System.out.print("Número inválido. Ingrese un número positivo: ");
        }

        SumaDados juego = new SumaDados();
        int resultado = juego.jugarRondas(rondas);

        System.out.println("\n--- RESULTADO FINAL ---");
        System.out.println("Puntaje final del jugador: " + resultado);
    }
}

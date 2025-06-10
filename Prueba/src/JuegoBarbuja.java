import java.util.Scanner;
    public class JuegoBarbuja {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            try {
                int rondas = Utilidades.pedirRondas(sc);
                int puntajeFinal = Utilidades.jugar(rondas);

                System.out.println("----- RESULTADO FINAL -----");
                System.out.println("Puntaje total del jugador: " + puntajeFinal);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Programa terminado.");
            }
        }
    }






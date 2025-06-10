public class SumaDados {
    private final Dado1 dado1 = new Dado1();
    private final Dado1 dado2 = new Dado1(); // usamos 2 dados, aunque sean de misma clase

    // Método que ejecuta las rondas del juego
    public int jugarRondas(int rondas) {
        int totalPuntos = 0;

        for (int i = 1; i <= rondas; i++) {
            dado1.lanzar();
            dado2.lanzar();

            int val1 = dado1.getValor();
            int val2 = dado2.getValor();
            int suma = val1 + val2;

            System.out.printf("Ronda %d: Dado1 = %d, Dado2 = %d -> ", i, val1, val2);

            if (val1 == 1 && val2 == 1) {
                totalPuntos = 0;
                System.out.println("¡Barbuja! Pierdes todo.");
            } else if (val1 == 1 || val2 == 1) {
                // no suma nada en esta ronda
                System.out.println("Uno de los dados es 1. No sumas puntos.");
            } else {
                totalPuntos += suma;
                if (suma == 6) {
                    totalPuntos *= 2;
                    System.out.println("Suma = 6. Se DUPLICA el total acumulado.");
                } else if (suma == 12) {
                    totalPuntos += 1;
                    System.out.println("Suma = 12. Ganas 1 punto extra.");
                } else {
                    System.out.println("Sumas " + suma + " puntos.");
                }
            }

            System.out.println("Total acumulado: " + totalPuntos);
        }

        return totalPuntos;
    }
}

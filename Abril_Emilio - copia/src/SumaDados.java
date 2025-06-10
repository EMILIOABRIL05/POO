public class SumaDados {
    private final Dado1 dado1 = new Dado1();
    private final Dado1 dado2 = new Dado1();

    public int jugarRondas(int rondas) {
        int sumdados = 0;

        for (int i = 1; i <= rondas; i++) {
            dado1.lanzar();
            dado2.lanzar();

            int val1 = dado1.getValor();
            int val2 = dado2.getValor();

            System.out.println("Ronda " + i + ": Dado1 = " + val1 + ", Dado2 = " + val2);

            if (val1 == 1 && val2 == 1) {
                sumdados = 0; // pierde todo si ambos son 1
            } else if (val1 == 1 || val2 == 1) {
                // no suma nada si al menos uno es 1
            } else {
                sumdados += val1 + val2;
            }

            if (sumdados == 6) {
                sumdados *= 2;
            } else if (sumdados == 12) {
                sumdados += 1;
            }
        }

        return sumdados;
    }
}

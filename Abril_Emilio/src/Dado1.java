import java.util.Random;
public class Dado1 {
    private int valor;
    private static final Random aleatorio = new Random();

    public void lanzar() {
        valor = aleatorio.nextInt(6) + 1;
    }

    public int getValor() {
        return valor;
    }
}

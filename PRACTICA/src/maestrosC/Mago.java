package maestrosC;

public class Mago extends Personaje {
    private int magia;

    public Mago(String nombre, int vidaMaxima, int defensa, int magia) {
        super(nombre, vidaMaxima, defensa);
        this.magia = magia;

        // Cartas predefinidas para el Mago con valores más altos
        agregarCarta(new CartaDePoder("Bola de Fuego", "Lanza una esfera de fuego", CartaDePoder.TIPO_ATAQUE, 45));
        agregarCarta(new CartaDePoder("Barrera Mágica", "Crea una barrera protectora", CartaDePoder.TIPO_DEFENSA, 10));
        agregarCarta(new CartaDePoder("Curación Mística", "Restaura puntos de vida", CartaDePoder.TIPO_VIDA, 25));
        agregarCarta(new CartaDePoder("Rayo Arcano", "Dispara un rayo de energía pura", CartaDePoder.TIPO_ATAQUE, 40));
    }

    @Override
    protected int calcularDañoBase() {
        return magia + 8;
    }

    @Override
    public String getTipo() {
        return "Mago";
    }
}
package maestrosC;

public class Arquero extends Personaje {
    private int punteria;

    public Arquero(String nombre, int vidaMaxima, int defensa, int punteria) {
        super(nombre, vidaMaxima, defensa);
        this.punteria = punteria;

        // Cartas predefinidas para el Arquero con valores más altos
        agregarCarta(new CartaDePoder("Flecha Precisa", "Dispara una flecha con alta precisión", CartaDePoder.TIPO_ATAQUE, 35));
        agregarCarta(new CartaDePoder("Salto Ágil", "Aumenta la defensa esquivando", CartaDePoder.TIPO_DEFENSA, 8));
        agregarCarta(new CartaDePoder("Vendaje Rápido", "Cura heridas menores", CartaDePoder.TIPO_VIDA, 20));
        agregarCarta(new CartaDePoder("Lluvia de Flechas", "Dispara múltiples flechas a la vez", CartaDePoder.TIPO_ATAQUE, 38));
    }

    @Override
    protected int calcularDañoBase() {
        return punteria + 9;
    }

    @Override
    public String getTipo() {
        return "Arquero";
    }
}
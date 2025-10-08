package maestrosC;

public class Guerrero extends Personaje {
    private int fuerza;

    public Guerrero(String nombre, int vidaMaxima, int defensa, int fuerza) {
        super(nombre, vidaMaxima, defensa);
        this.fuerza = fuerza;

        // Cartas predefinidas para el Guerrero con valores más altos
        agregarCarta(new CartaDePoder("Golpe Poderoso", "Un golpe con toda la fuerza", CartaDePoder.TIPO_ATAQUE, 40));
        agregarCarta(new CartaDePoder("Escudo de Acero", "Aumenta la defensa temporalmente", CartaDePoder.TIPO_DEFENSA, 10));
        agregarCarta(new CartaDePoder("Grito de Guerra", "Recupera algo de vida", CartaDePoder.TIPO_VIDA, 20));
        agregarCarta(new CartaDePoder("Hacha Giratoria", "Ataque de área efectivo", CartaDePoder.TIPO_ATAQUE, 35));
    }

    @Override
    protected int calcularDañoBase() {
        return fuerza + 10;
    }

    @Override
    public String getTipo() {
        return "Guerrero";
    }
}
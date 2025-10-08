package maestrosC;

import java.util.ArrayList;
import java.util.List;

public abstract class Personaje {
    private String nombre;
    private int vida;
    private int vidaMaxima;
    private int defensa;
    private List<CartaDePoder> cartas;
    private List<CartaDePoder> ordenCartas;

    public Personaje(String nombre, int vidaMaxima, int defensa) {
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;
        this.defensa = defensa;
        this.cartas = new ArrayList<>();
        this.ordenCartas = new ArrayList<>();
    }

    public void agregarCarta(CartaDePoder carta) {
        cartas.add(carta);
    }

    public void definirOrdenCartas(List<CartaDePoder> orden) {
        this.ordenCartas = new ArrayList<>(orden);
    }

    public CartaDePoder obtenerSiguienteCarta(int turno) {
        if (ordenCartas.isEmpty()) {
            return null;
        }
        return ordenCartas.get(turno % ordenCartas.size());
    }

    public void usarCarta(CartaDePoder carta, Personaje objetivo) {
        if (carta != null) {
            carta.aplicarEfecto(this, objetivo);
        } else {
            atacar(objetivo);
        }
    }

    public void atacar(Personaje objetivo) {
        // Daño significativamente alto
        int daño = calcularDañoBase();
        int reduccion = Math.min(objetivo.getDefensa(), daño / 2);
        daño -= reduccion;

        // Garantizar daño mínimo de 10
        daño = Math.max(10, daño);

        objetivo.recibirDaño(daño);
        System.out.println(nombre + " ataca a " + objetivo.getNombre() + " y causa " + daño + " de daño");
    }

    public void recibirDaño(int cantidad) {
        vida = Math.max(0, vida - cantidad);
        System.out.println(nombre + " tiene ahora " + vida + " puntos de vida");
    }

    public void recuperarVida(int cantidad) {
        int vidaAnterior = vida;
        vida = Math.min(vidaMaxima, vida + cantidad);
        System.out.println(nombre + " recupera " + (vida - vidaAnterior) + " puntos de vida (Total: " + vida + ")");
    }

    public void aumentarDefensa(int cantidad) {
        defensa += cantidad;
        // Limitar defensa a un máximo bajo
        if (defensa > 15) {
            defensa = 15;
            System.out.println(nombre + " alcanza el máximo de defensa (15)");
        }
    }

    public boolean estaVencido() {
        return vida <= 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getDefensa() {
        return defensa;
    }

    public List<CartaDePoder> getCartas() {
        return new ArrayList<>(cartas);
    }

    protected abstract int calcularDañoBase();

    public abstract String getTipo();

    @Override
    public String toString() {
        return getTipo() + " " + nombre + " [Vida: " + vida + "/" + vidaMaxima + ", Defensa: " + defensa + "]";
    }
}
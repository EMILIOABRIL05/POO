package naipe;

public class Carta {

    private final String palo;
    private final String numero;

    public Carta(String numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public String getNumero() {
        return numero;
    }

    public String getPalo() {
        return palo;
    }
}

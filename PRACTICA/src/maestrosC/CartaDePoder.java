package maestrosC;

public class CartaDePoder {
    // Constantes para tipos de carta
    public static final String TIPO_ATAQUE = "ATAQUE";
    public static final String TIPO_DEFENSA = "DEFENSA";
    public static final String TIPO_VIDA = "VIDA";

    private String nombre;
    private String descripcion;
    private String tipo;
    private int valor;

    public CartaDePoder(String nombre, String descripcion, String tipo, int valor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.valor = valor;
    }

    public void aplicarEfecto(Personaje usuario, Personaje objetivo) {
        switch (tipo) {
            case TIPO_ATAQUE:
                // Daño significativamente alto para terminar batallas rápido
                int daño = valor;
                // La defensa solo reduce un máximo del 50% del daño
                int reduccion = Math.min(objetivo.getDefensa(), valor / 2);
                daño -= reduccion;

                // Garantizar daño mínimo de 15
                daño = Math.max(15, daño);

                objetivo.recibirDaño(daño);
                System.out.println(usuario.getNombre() + " usa " + nombre + " y causa " + daño + " de daño a " + objetivo.getNombre());
                break;

            case TIPO_DEFENSA:
                // Limitamos severamente los aumentos de defensa
                int defensaAumentada = Math.min(5, valor);
                usuario.aumentarDefensa(defensaAumentada);
                System.out.println(usuario.getNombre() + " usa " + nombre + " y aumenta su defensa en " + defensaAumentada);
                break;

            case TIPO_VIDA:
                // Recuperación de vida limitada al 30% de la vida máxima
                int recuperacion = Math.min(valor, usuario.getVidaMaxima() * 30 / 100);
                usuario.recuperarVida(recuperacion);
                System.out.println(usuario.getNombre() + " usa " + nombre + " y recupera " + recuperacion + " puntos de vida");
                break;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return nombre + " (" + descripcion + ", " + tipo + ": " + valor + ")";
    }
}
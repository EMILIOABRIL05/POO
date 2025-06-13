import java.security.SecureRandom;

public abstract class Vehiculo {
    private static final SecureRandom random = new SecureRandom();

    protected final String tipo;
    protected Piloto piloto;
    protected double velocidadBase;
    protected double distanciaRecorrida;
    protected String marca;

    public Vehiculo(String tipo, Piloto piloto, double velocidadBase) {
        this.tipo = tipo;
        this.piloto = piloto;
        this.velocidadBase = velocidadBase;
        this.distanciaRecorrida = 0.0;
        this.marca = "Genérica";
    }

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(double distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public String getTipo() {
        return tipo;
    }

    public double getVelocidadBase() {
        return velocidadBase;
    }

    public void setVelocidadBase(double velocidadBase) {
        this.velocidadBase = velocidadBase;
    }

    public void recorrer() {
        double tiempoAleatorio = 20 + random.nextDouble() * 40; // Tiempo aleatorio entre 10 y 50 segundos
        double distancia = velocidadBase * tiempoAleatorio;
        distanciaRecorrida += distancia;
    }

    @Override
    public String toString() {

        return String.format("%s %s pilotado por : %s",tipo , marca, piloto.getNombre());
    }

}

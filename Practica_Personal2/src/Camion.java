public class Camion extends Vehiculo {

    public Camion(String marca, Piloto piloto, double velocidadBase) {
        super("Camion", piloto, velocidadBase);
        this.marca = marca;
    }
}

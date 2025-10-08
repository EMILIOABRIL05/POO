package figuras;

public class Cuadrado extends Figura {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    public double getLado() {
        return lado;
    }

    @Override
    public String toString() {
        return String.format("Cuadrado [lado=%.2f, área=%.2f]", lado, calcularArea());
    }
}

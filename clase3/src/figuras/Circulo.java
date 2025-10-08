package figuras;

public class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    public double getRadio() {
        return radio;
    }

    @Override
    public String toString() {
        return String.format("Círculo [radio=%.2f, área=%.2f]", radio, calcularArea());
    }
}

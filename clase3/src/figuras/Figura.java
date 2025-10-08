package figuras;

public abstract class Figura implements Comparable<Figura> {

    public abstract double calcularArea();

    @Override
    public abstract String toString();

    @Override
    public int compareTo(Figura otraFigura) {
        double diferencia = this.calcularArea() - otraFigura.calcularArea();
        if (diferencia < 0) return -1;
        if (diferencia > 0) return 1;
        return 0;
    }
}

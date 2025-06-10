package calculadoraClase;

public class Sumar {
    private double x;
    private double y;


    public Sumar(double x, double y) {

        this.x = x;
        this.y = y;


    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double calcular() {
    return x+y;
    }
}

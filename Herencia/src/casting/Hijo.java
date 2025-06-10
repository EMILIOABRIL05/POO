package casting;

public class Hijo extends Progenitor{

    private int id;

    public Hijo(String nombre, int id) {
        super(nombre);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override // para que encuentre mas rapido porque ayuda a la maquina virtual , funciona igual si no se implementa
    public String toString() {

        return String.format("%sEl identificador  es: %d.%n",super.toString(), this.id);
    }
    @Override
    public void metodo() {

        System.out.println("Este es el metodo del hijo");
    }
}

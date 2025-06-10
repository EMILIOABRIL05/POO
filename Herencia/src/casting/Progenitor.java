package casting;

public class Progenitor extends Object {// asi se ve siempre las clases que no tienen
    protected String nombre;

    public Progenitor(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return String.format("El nombre es %s.%n", this.nombre);
    }
    public void metodo() {
        System.out.println("Este es el metodo del progenitor");
    }
}

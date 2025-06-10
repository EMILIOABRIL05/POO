package pasoValor;

public class Persona {

    private String nombre;
    private Direccion direccion;

    public Persona(String nombre, Direccion direccion) {

        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return this.direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void imprimirPersona() {

        System.out.printf("Nombre: %s. Direccion: %s.%n", this.nombre, this.direccion.imprimirDireccion());
    }


}
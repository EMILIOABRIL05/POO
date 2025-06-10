public class Persona {

    protected final String nombre;
    protected int edad;
    protected final String id ;


    public Persona(String nombre, String id, int edad) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
    }


    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }


@Override
    public String toString() {

        return String.format("Nombre: %s Edad: %d", nombre, edad);

}
}



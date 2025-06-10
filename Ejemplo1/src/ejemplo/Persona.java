package ejemplo;

public class Persona {
    private String nombre;
    private String edad;
    private String direccion; //se genera por relacion por composicion, la
    //persona si puede existir si no tiene una direccion

    public Persona(String nombre, String edad, String direccion) {


        this.nombre = nombre;
        this.edad = edad;
        this.direccion = new Direccion(calle, numero);
    }

    public Persona(String nombre, String edad,Direccion direccion) {
         this.nombre = nombre;
         this.edad = edad;
         this.direccion=direccion;
    }
}
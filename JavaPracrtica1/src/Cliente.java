public class Cliente extends Persona{
 private String  direccion ;

    public Cliente(String nombre, String id, int edad, String direccion) {
        super(nombre, id, edad);
        this.direccion = direccion;
    }


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    @Override
    public String toString() {

return String.format("Nombre: %s Edad: %d Direccion: %s", this.nombre, this.edad, direccion);

    }

}

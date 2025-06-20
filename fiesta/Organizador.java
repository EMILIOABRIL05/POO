package fiesta;

public class Organizador extends Object {

    private final String nombre;
    private final String cedula;
    private final String promotora;
    private final String telefono;

    public Organizador(String nombre, String cedula, String promotora, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.promotora = promotora;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getPromotora() {
        return promotora;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {

        return String.format("%s(%s).Trabaja en %s. Telefono: %s.%n",this.nombre,this.cedula,this.promotora, this.telefono);
    }
}

package pasoValor;

public class Direccion {

    private String ciudad;

    public Direccion(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String imprimirDireccion() {

        return String.format("%s", this.ciudad);
    }
}

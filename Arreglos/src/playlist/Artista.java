package playlist;

public class Artista {

    private final String nombre;
    private String disquera;

    public Artista(String nombre, String disquera) {
        this.nombre = nombre;
        this.disquera = disquera;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDisquera() {
        return disquera;
    }

    public void setDisquera(String disquera) {
        this.disquera = disquera;
    }

    @Override
    public String toString() {
        return String.format("%s(%s)", this.nombre, this.disquera);
    }
}
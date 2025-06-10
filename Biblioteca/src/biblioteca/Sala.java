package biblioteca;

public class Sala {

    private int numeroSala;
    private String estado;
    private Libro libroLeer;
    private int capacidadSala;
    private int numeroSillas;

    public Sala() {
    }

    public Sala(int numeroSala, String estado, Libro libroLeer, int capacidadSala, int numeroSillas) {
        this.numeroSala = numeroSala;
        this.estado = estado;
        this.libroLeer = libroLeer;
        this.capacidadSala = capacidadSala;
        this.numeroSillas = numeroSillas;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Libro getLibroLeer() {
        return libroLeer;
    }

    public void setLibroLeer(Libro libroLeer) {
        this.libroLeer = libroLeer;
    }

    public int getCapacidadSala() {
        return capacidadSala;
    }

    public void setCapacidadSala(int capacidadSala) {
        this.capacidadSala = capacidadSala;
    }

    public int getNumeroSillas() {
        return numeroSillas;
    }

    public void setNumeroSillas(int numeroSillas) {
        this.numeroSillas = numeroSillas;
    }
    public void mostrarSala() {
        System.out.println("Número de Sala: " + numeroSala);
        System.out.println("Estado: " + estado);
        System.out.println("Libro a Leer: " + libroLeer);
        System.out.println("Capacidad de la Sala: " + capacidadSala);
        System.out.println("Número de Sillas: " + numeroSillas);
    }

}

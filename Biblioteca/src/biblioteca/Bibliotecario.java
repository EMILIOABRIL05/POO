package biblioteca;

public class Bibliotecario {

    private String nombre;
    private Hora horaInicio;
    private Hora horaFin;
    private int idBibliotecario;

    public Bibliotecario() {
    }

    public Bibliotecario(String nombre, Hora horaInicio, Hora horaFin, int idBibliotecario) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.idBibliotecario = idBibliotecario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Hora getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Hora horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Hora getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Hora horaFin) {
        this.horaFin = horaFin;
    }

    public int getIdBibliotecario() {
        return idBibliotecario;
    }

    public void setIdBibliotecario(int idBibliotecario) {
        this.idBibliotecario = idBibliotecario;
    }
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Hora de Inicio: " + horaInicio);
        System.out.println("Hora de Fin: " + horaFin);
        System.out.println("ID del Bibliotecario: " + idBibliotecario);
    }

}

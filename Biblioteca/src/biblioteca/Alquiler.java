package biblioteca;

public class Alquiler {

    private int idAlquiler;
    private Lector lector;
    private Bibliotecario bibliotecario;
    private Sala sala;
    private Fecha fechaAlquiler;
    private Hora horaInicio;
    private Hora horaFin;

    public Alquiler() {
    }

    public Alquiler(int idAlquiler, Lector lector, Bibliotecario bibliotecario, Sala sala,
                    Fecha fechaAlquiler, Hora horaInicio, Hora horaFin) {
        this.idAlquiler = idAlquiler;
        this.lector = lector;
        this.bibliotecario = bibliotecario;
        this.sala = sala;
        this.fechaAlquiler = fechaAlquiler;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Fecha getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(Fecha fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
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
    public void mostrarDatos() {
        System.out.println("ID Alquiler: " + idAlquiler);
        System.out.println("Lector: " + lector);
        System.out.println("Bibliotecario: " + bibliotecario);
        System.out.println("Sala: " + sala);
        System.out.println("Fecha de Alquiler: " + fechaAlquiler);
        System.out.println("Hora de Inicio: " + horaInicio);
        System.out.println("Hora de Fin: " + horaFin);
    }

}

package biblioteca;

public class Lector {

    private int idLector;
    private String nombre;
    private String correoElectronico;
    private String telefono;
    private String formaPago;
    private int edad;
    private String cedula;
    private Fecha fechaInscripcion;

    public Lector() {
    }

    public Lector(int idLector, String nombre, String correoElectronico, String telefono,
                  String formaPago, int edad, String cedula, Fecha fechaInscripcion) {
        this.idLector = idLector;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.formaPago = formaPago;
        this.edad = edad;
        this.cedula = cedula;
        this.fechaInscripcion = fechaInscripcion;
    }

    public int getIdLector() {
        return idLector;
    }

    public void setIdLector(int idLector) {
        this.idLector = idLector;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Fecha getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Fecha fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
    public void mostrarLector() {
        System.out.println("ID Lector: " + idLector);
        System.out.println("Nombre: " + nombre);
        System.out.println("Correo Electrónico: " + correoElectronico);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Forma de Pago: " + formaPago);
        System.out.println("Edad: " + edad);
        System.out.println("Cédula: " + cedula);
        System.out.println("Fecha de Inscripción: " + fechaInscripcion);
    }

}

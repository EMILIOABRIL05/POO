public class Persona {
    protected String numeroCedula;
    protected String nombres;
    protected String apellidos;
    protected String direccion;
    protected String correoElectronico;
    protected String telefono;

    public Persona(String numeroCedula, String nombres, String apellidos,
                   String direccion, String correoElectronico, String telefono) {
        this.numeroCedula = numeroCedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
    }

    public String getNumeroCedula() { return numeroCedula; }
    public void setNumeroCedula(String numeroCedula) { this.numeroCedula = numeroCedula; }
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getNombreCompleto() { return nombres + " " + apellidos; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String obtenerRol() {
        return "Participante";
    }

    @Override
    public String toString() {
        return obtenerRol() + ": " + getNombreCompleto() +
                " (Cédula: " + numeroCedula + ")" +
                "\nDirección: " + direccion +
                "\nCorreo: " + correoElectronico +
                "\nTeléfono: " + telefono;
    }
}


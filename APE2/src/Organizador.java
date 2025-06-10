public class Organizador extends Persona {
    private String lugarTrabajo;

    public Organizador(String numeroCedula, String nombres, String apellidos,
                       String direccion, String correoElectronico, String telefono,
                       String lugarTrabajo) {
        super(numeroCedula, nombres, apellidos, direccion, correoElectronico, telefono);
        this.lugarTrabajo = lugarTrabajo;
    }

    public String getLugarTrabajo() { return lugarTrabajo; }
    public void setLugarTrabajo(String lugarTrabajo) { this.lugarTrabajo = lugarTrabajo; }

    @Override
    public String obtenerRol() {
        return "Organizador";
    }

    @Override
    public String toString() {
        return super.toString() + "\nLugar de trabajo: " + lugarTrabajo;
    }
}

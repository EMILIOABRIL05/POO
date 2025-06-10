package fiesta;

public class Participante {

    private final String nombre;
    private final String cedula;
    private final String telefono;
    private final int edad;
    private Evento evento1;
    private Evento evento2;

    public Participante(String nombre, String cedula, String telefono, int edad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.edad = edad;
        this.evento1 = null;
        this.evento2 = null;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getEdad() {
        return edad;
    }

    public Evento getEvento1() {
        return evento1;
    }

    public void setEvento1(Evento evento1) {
        this.evento1 = evento1;
    }

    public Evento getEvento2() {
        return evento2;
    }

    public void setEvento2(Evento evento2) {
        this.evento2 = evento2;
    }

    public void inscribir(Evento e) throws Exception {

        if(this.evento1 == null) {

            this.evento1 = e;
        } else if(this.evento2 == null) {

            this.evento2 = e;
        }else {

            throw new Exception("No se puede inscribir en mas eventos");
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s(%s). Edad: %d. Telefono: %s.%n",this.nombre,this.cedula,this.edad, this.telefono));
        sb.append("\n Eventos a los que asiste: \n");
        if(evento1 != null) {

            sb.append(String.format("- %s.%n",evento1.getNombre()));
        }
        if(evento2 != null) {

            sb.append(String.format("- %s.%n",evento2.getNombre()));
        }

        return sb.toString();
    }
}

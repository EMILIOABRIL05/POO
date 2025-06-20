package fiesta;

import java.util.ArrayList;

public class Participante {

    private final String cedula;
    private final String nombre;
    private final String apellido;
    private final String ciudad;
    private final String email;
    private final String telefono;
    private ArrayList<Evento> eventos;

    public Participante(String cedula, String nombre, String apellido, 
                        String ciudad, String email, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.email = email;
        this.telefono = telefono;
        this.eventos = new ArrayList<>();
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

    public String getApellido() {
        return apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void inscribir(Evento e) throws Exception {
        if (this.eventos.size() < 2) {
            this.eventos.add(e);
        } else {
            throw new Exception("No se puede inscribir en mas eventos");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s(%s). Ciudad: %s. Email: %s. Telefono: %s.%n",
                this.nombre, this.apellido, this.cedula, this.ciudad, this.email, this.telefono));
        sb.append("\n Eventos a los que asiste: \n");

        for (Evento evento : eventos) {
            sb.append(String.format("- %s.%n", evento.getNombre()));
        }

        return sb.toString();
    }
}

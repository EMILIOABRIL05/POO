package reservasHotel;

public class Huesped {

    private String nombre;
    private final String cedula;

    public Huesped(String nombre, String cedula) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        if (cedula == null || cedula.isEmpty()) {
            throw new IllegalArgumentException("La cédula no puede ser nula o vacía");
        }
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Huesped otro = (Huesped) obj;
        return cedula.equals(otro.cedula);

    }

    @Override
    public int hashCode() {
        return cedula.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Huesped: %s, Cédula: %s", nombre, cedula);
    }
}
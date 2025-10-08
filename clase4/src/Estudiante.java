import java.time.LocalDate;
import java.time.Period;

/**
 * Clase que representa a un estudiante con sus datos personales y calificaciones
 */
public class Estudiante {
    private String cedula;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private double[] notas;
    private int contadorNotas;

    /**
     * Constructor para la clase Estudiante
     * @param cedula Número de cédula del estudiante
     * @param nombres Nombres del estudiante
     * @param apellidos Apellidos del estudiante
     * @param fechaNacimiento Fecha de nacimiento del estudiante
     */
    public Estudiante(String cedula, String nombres, String apellidos, LocalDate fechaNacimiento) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.notas = new double[7]; // Máximo 7 notas
        this.contadorNotas = 0;
    }

    /**
     * Calcula el promedio de las notas del estudiante
     * @return Promedio de notas o 0 si no hay notas registradas
     */
    public double calcularPromedio() {
        if (contadorNotas == 0) {
            return 0;
        }

        double suma = 0;
        for (int i = 0; i < contadorNotas; i++) {
            suma += notas[i];
        }
        return suma / contadorNotas;
    }

    /**
     * Calcula la edad del estudiante basada en su fecha de nacimiento
     * @return Edad en años
     */
    public int getEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    /**
     * Devuelve una representación en texto del estudiante
     * @return String con la información del estudiante
     */
    @Override
    public String toString() {
        return "Estudiante{" +
                "cédula='" + cedula + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + getEdad() + " años" +
                ", promedio=" + String.format("%.2f", calcularPromedio()) +
                '}';
    }

    // Getters y Setters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public int getContadorNotas() {
        return contadorNotas;
    }

    /**
     * Agrega una nota al estudiante si hay espacio disponible
     * @param nota Nota a agregar
     * @return true si se agregó correctamente, false si no hay espacio
     */
    public boolean agregarNota(double nota) {
        if (contadorNotas < 7) {
            notas[contadorNotas] = nota;
            contadorNotas++;
            return true;
        }
        return false;
    }

    /**
     * Modifica una nota existente del estudiante
     * @param indice Índice de la nota a modificar
     * @param nuevaNota Nuevo valor de la nota
     * @return true si se modificó correctamente, false si el índice es inválido
     */
    public boolean modificarNota(int indice, double nuevaNota) {
        if (indice >= 0 && indice < contadorNotas) {
            notas[indice] = nuevaNota;
            return true;
        }
        return false;
    }

    /**
     * Elimina una nota existente del estudiante
     * @param indice Índice de la nota a eliminar
     * @return true si se eliminó correctamente, false si el índice es inválido
     */
    public boolean eliminarNota(int indice) {
        if (indice >= 0 && indice < contadorNotas) {
            // Desplaza las notas para cubrir el espacio de la nota eliminada
            for (int i = indice; i < contadorNotas - 1; i++) {
                notas[i] = notas[i + 1];
            }
            contadorNotas--;
            return true;
        }
        return false;
    }

    /**
     * Muestra las notas del estudiante
     * @return String con la lista de notas
     */
    public String mostrarNotas() {
        if (contadorNotas == 0) {
            return "No hay notas registradas";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contadorNotas; i++) {
            sb.append(i + 1).append(". ").append(String.format("%.2f", notas[i])).append("\n");
        }
        return sb.toString();
    }
}

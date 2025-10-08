/**
 * Clase que gestiona un conjunto de estudiantes utilizando un vector
 */
public class GestorEstudiantes {
    private Estudiante[] estudiantes;
    private int contadorEstudiantes;
    private static final int CAPACIDAD_MAXIMA = 20;

    /**
     * Constructor que inicializa el gestor con capacidad para 20 estudiantes
     */
    public GestorEstudiantes() {
        estudiantes = new Estudiante[CAPACIDAD_MAXIMA];
        contadorEstudiantes = 0;
    }

    /**
     * Inserta un nuevo estudiante en el gestor
     * @param estudiante El estudiante a insertar
     * @return true si se insertó correctamente, false si no hay espacio
     */
    public boolean insertarEstudiante(Estudiante estudiante) {
        if (contadorEstudiantes >= CAPACIDAD_MAXIMA) {
            return false;
        }

        // Verificar que no exista otro estudiante con la misma cédula
        if (buscar(estudiante.getCedula()) != null) {
            return false;
        }

        estudiantes[contadorEstudiantes] = estudiante;
        contadorEstudiantes++;
        return true;
    }

    /**
     * Modifica un estudiante existente
     * @param id El índice del estudiante a modificar
     * @param estudiante El nuevo estudiante con los datos actualizados
     * @return true si se modificó correctamente, false si el índice es inválido
     */
    public boolean modificarEstudiante(int id, Estudiante estudiante) {
        if (id < 0 || id >= contadorEstudiantes) {
            return false;
        }

        // Verificar que la nueva cédula no exista en otro estudiante
        Estudiante existente = buscar(estudiante.getCedula());
        if (existente != null && existente != estudiantes[id]) {
            return false;
        }

        // Conservamos las notas originales para no perderlas
        double[] notasOriginales = estudiantes[id].getNotas();
        int contadorNotasOriginales = estudiantes[id].getContadorNotas();

        estudiantes[id] = estudiante;

        // Restauramos las notas
        estudiantes[id].setNotas(notasOriginales);
        for (int i = 0; i < contadorNotasOriginales; i++) {
            estudiantes[id].agregarNota(notasOriginales[i]);
        }

        return true;
    }

    /**
     * Elimina un estudiante del gestor
     * @param id El índice del estudiante a eliminar
     * @return true si se eliminó correctamente, false si el índice es inválido
     */
    public boolean eliminarEstudiante(int id) {
        if (id < 0 || id >= contadorEstudiantes) {
            return false;
        }

        // Desplazar todos los estudiantes una posición hacia atrás
        for (int i = id; i < contadorEstudiantes - 1; i++) {
            estudiantes[i] = estudiantes[i + 1];
        }

        estudiantes[contadorEstudiantes - 1] = null;
        contadorEstudiantes--;
        return true;
    }

    /**
     * Busca un estudiante por su número de cédula
     * @param cedula La cédula a buscar
     * @return El estudiante encontrado o null si no existe
     */
    public Estudiante buscar(String cedula) {
        for (int i = 0; i < contadorEstudiantes; i++) {
            if (estudiantes[i].getCedula().equals(cedula)) {
                return estudiantes[i];
            }
        }
        return null;
    }

    /**
     * Busca un estudiante por su índice
     * @param indice El índice a buscar
     * @return El estudiante encontrado o null si no existe
     */
    public Estudiante buscarPorIndice(int indice) {
        if (indice >= 0 && indice < contadorEstudiantes) {
            return estudiantes[indice];
        }
        return null;
    }

    /**
     * Registra nuevas notas para un estudiante
     * @param cedula La cédula del estudiante
     * @param nuevasNotas Vector con las nuevas notas
     * @return true si se registraron correctamente, false si no se encontró el estudiante
     */
    public boolean registrarNotas(String cedula, double[] nuevasNotas) {
        Estudiante estudiante = buscar(cedula);
        if (estudiante == null) {
            return false;
        }

        // Reemplazamos las notas con el nuevo vector
        estudiante.setNotas(nuevasNotas);
        return true;
    }

    /**
     * Calcula el promedio de todos los estudiantes del curso
     * @return El promedio general o 0 si no hay estudiantes con notas
     */
    public double calcularPromedioCurso() {
        if (contadorEstudiantes == 0) {
            return 0;
        }

        double sumaPromedios = 0;
        int estudiantesConNotas = 0;

        for (int i = 0; i < contadorEstudiantes; i++) {
            double promedioEstudiante = estudiantes[i].calcularPromedio();
            if (promedioEstudiante > 0) {  // Solo contamos estudiantes con al menos una nota
                sumaPromedios += promedioEstudiante;
                estudiantesConNotas++;
            }
        }

        if (estudiantesConNotas == 0) {
            return 0;
        }

        return sumaPromedios / estudiantesConNotas;
    }

    /**
     * Obtiene la cantidad actual de estudiantes en el gestor
     * @return Número de estudiantes
     */
    public int getContadorEstudiantes() {
        return contadorEstudiantes;
    }

    /**
     * Verifica si el gestor está lleno
     * @return true si está lleno, false en caso contrario
     */
    public boolean estaLleno() {
        return contadorEstudiantes >= CAPACIDAD_MAXIMA;
    }

    /**
     * Verifica si el gestor está vacío
     * @return true si está vacío, false en caso contrario
     */
    public boolean estaVacio() {
        return contadorEstudiantes == 0;
    }

    /**
     * Obtiene un listado de todos los estudiantes
     * @return String con la lista de estudiantes
     */
    public String listarEstudiantes() {
        if (contadorEstudiantes == 0) {
            return "No hay estudiantes registrados";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contadorEstudiantes; i++) {
            sb.append(i + 1).append(". ")
              .append(estudiantes[i].getCedula()).append(" - ")
              .append(estudiantes[i].getNombres()).append(" ")
              .append(estudiantes[i].getApellidos())
              .append("\n");
        }

        return sb.toString();
    }
}

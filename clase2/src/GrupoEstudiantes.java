public class GrupoEstudiantes {
    private Estudiante[] estudiantes;
    private boolean[] estudiantesRegistrados;
    private static final int MAX_ESTUDIANTES = 42;

    public GrupoEstudiantes() {
        this.estudiantes = new Estudiante[MAX_ESTUDIANTES];
        this.estudiantesRegistrados = new boolean[MAX_ESTUDIANTES];
    }

    public void insertarEstudiante(int posicion, String nombre) {
        if (posicion >= 0 && posicion < MAX_ESTUDIANTES) {
            estudiantes[posicion] = new Estudiante(nombre);
            estudiantesRegistrados[posicion] = true;
        }
    }

    public void modificarEstudiante(int posicion, String nuevoNombre) {
        if (posicion >= 0 && posicion < MAX_ESTUDIANTES && estudiantesRegistrados[posicion]) {
            estudiantes[posicion].setNombre(nuevoNombre);
        }
    }

    public void eliminarEstudiante(int posicion) {
        if (posicion >= 0 && posicion < MAX_ESTUDIANTES) {
            estudiantesRegistrados[posicion] = false;
        }
    }

    public void insertarNotaEstudiante(int posicionEstudiante, int materia, double nota) {
        if (posicionEstudiante >= 0 && posicionEstudiante < MAX_ESTUDIANTES &&
                estudiantesRegistrados[posicionEstudiante]) {
            estudiantes[posicionEstudiante].insertarNota(materia, nota);
        }
    }

    public void modificarNotaEstudiante(int posicionEstudiante, int materia, double nota) {
        if (posicionEstudiante >= 0 && posicionEstudiante < MAX_ESTUDIANTES &&
                estudiantesRegistrados[posicionEstudiante]) {
            estudiantes[posicionEstudiante].modificarNota(materia, nota);
        }
    }

    public void eliminarNotaEstudiante(int posicionEstudiante, int materia) {
        if (posicionEstudiante >= 0 && posicionEstudiante < MAX_ESTUDIANTES &&
                estudiantesRegistrados[posicionEstudiante]) {
            estudiantes[posicionEstudiante].eliminarNota(materia);
        }
    }

    public double calcularPromedioEstudiante(int posicion) {
        if (posicion >= 0 && posicion < MAX_ESTUDIANTES && estudiantesRegistrados[posicion]) {
            return estudiantes[posicion].calcularPromedio();
        }
        return 0;
    }

    public double calcularPromedioGrupo() {
        double sumaPromedios = 0;
        int estudiantesConNotas = 0;

        for (int i = 0; i < MAX_ESTUDIANTES; i++) {
            if (estudiantesRegistrados[i]) {
                double promedio = estudiantes[i].calcularPromedio();
                if (promedio > 0) {
                    sumaPromedios += promedio;
                    estudiantesConNotas++;
                }
            }
        }

        return estudiantesConNotas > 0 ? sumaPromedios / estudiantesConNotas : 0;
    }
}
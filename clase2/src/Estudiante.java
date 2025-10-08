public class Estudiante {
        private String nombre;
        private Float[] notas;
        private static final int MAX_MATERIAS = 5;

        public Estudiante(String nombre) {
            this.nombre = nombre;
            this.notas = new Float[MAX_MATERIAS];
            // No es necesario inicializar los valores, serán null por defecto
        }

        public void insertarNota(int materia, double nota) {
            if (materia >= 0 && materia < MAX_MATERIAS) {
                this.notas[materia] = (float) nota;
            }
        }

        public void modificarNota(int materia, double nota) {
            if (materia >= 0 && materia < MAX_MATERIAS && notas[materia] != null) {
                this.notas[materia] = (float) nota;
            }
        }

        public void eliminarNota(int materia) {
            if (materia >= 0 && materia < MAX_MATERIAS) {
                this.notas[materia] = null;
            }
        }

        public double calcularPromedio() {
            float suma = 0;
            int cantidadNotas = 0;

            for (int i = 0; i < MAX_MATERIAS; i++) {
                if (notas[i] != null) {
                    suma += notas[i];
                    cantidadNotas++;
                }
            }

            return cantidadNotas > 0 ? suma / cantidadNotas : 0;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }

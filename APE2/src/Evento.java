
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

    public class Evento {
        protected String titulo;
        protected LocalDate fechaInicio;
        protected LocalDate fechaFin;
        protected Organizador organizador;
        protected String lugar;
        protected Persona[] inscritos;
        protected int cantidadInscritos;
        protected static final int CAPACIDAD_MAXIMA = 100;

        public Evento(String titulo, LocalDate fechaInicio, LocalDate fechaFin,
                      Organizador organizador, String lugar) {
            this.titulo = titulo;
            this.fechaInicio = fechaInicio;
            this.fechaFin = fechaFin;
            this.organizador = organizador;
            this.lugar = lugar;
            this.inscritos = new Persona[CAPACIDAD_MAXIMA];
            this.cantidadInscritos = 0;
        }

        public void inscribirPersona(Persona persona) {
            if (cantidadInscritos < CAPACIDAD_MAXIMA) {
                inscritos[cantidadInscritos] = persona;
                cantidadInscritos++;
                System.out.println("Se ha inscrito a " + persona.getNombreCompleto() + " en el evento " + titulo);
            } else {
                System.out.println("Error: El evento ha alcanzado su capacidad máxima.");
            }
        }

        public String getTipoEvento() {
            return "Evento general";
        }

        public void mostrarInformacion() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.println("=== INFORMACIÓN DEL EVENTO ===");
            System.out.println("Tipo: " + getTipoEvento());
            System.out.println("Título: " + titulo);
            System.out.println("Fecha de inicio: " + fechaInicio.format(formatter));
            System.out.println("Fecha de fin: " + fechaFin.format(formatter));
            System.out.println("Lugar: " + lugar);
            System.out.println("\nORGANIZADOR:");
            System.out.println(organizador);

            System.out.println("\nPERSONAS INSCRITAS (" + cantidadInscritos + "):");
            if (cantidadInscritos == 0) {
                System.out.println("No hay personas inscritas en este evento.");
            } else {
                for (int i = 0; i < cantidadInscritos; i++) {
                    System.out.println("\nInscrito #" + (i + 1));
                    System.out.println(inscritos[i]);
                }
            }
        }
}

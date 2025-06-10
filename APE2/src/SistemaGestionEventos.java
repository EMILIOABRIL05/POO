import java.time.LocalDate;
public class SistemaGestionEventos {
    public static void main(String[] args) {
        System.out.println("SISTEMA DE GESTIÓN DE EVENTOS");
        System.out.println("Fiesta de las Flores y las Frutas - Ambato");
        System.out.println("==================================\n");

        Organizador organizadorXimena = new Organizador(
                "1723494430", "Ximena", "Carcelén", "Quito",
                "ximena@gmail.com", "",
                "Dirección de Cultura del Municipio de Quito"
        );

        Evento exposicionPintura = new Evento(
                "Exposición de Pintura",
                LocalDate.of(2025, 2, 18),
                LocalDate.of(2025, 2, 23),
                organizadorXimena,
                "Casa de la Cultura"
        );

        Persona jesus = new Persona("1893948587", "Jesús", "Mateo Urbina", "Ambato", "jesus@gmail.com", "0998238344");
        exposicionPintura.inscribirPersona(jesus);

        Persona maria = new Persona("1822403844", "Maria", "Magdalena Quishpe", "Quito", "maria@gmail.com", "0995244382");
        exposicionPintura.inscribirPersona(maria);

        System.out.println("\n--------------------------------------------\n");
        exposicionPintura.mostrarInformacion();
    }
}

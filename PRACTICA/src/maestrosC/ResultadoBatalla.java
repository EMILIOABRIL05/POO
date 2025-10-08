package maestrosC;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ResultadoBatalla {
    private Personaje ganador;
    private Personaje perdedor;
    private int turnos;
    private LocalDateTime fecha;

    public ResultadoBatalla(Personaje ganador, Personaje perdedor, int turnos) {
        this.ganador = ganador;
        this.perdedor = perdedor;
        this.turnos = turnos;
        this.fecha = LocalDateTime.now();
    }

    public Personaje getGanador() {
        return ganador;
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Batalla finalizada el " + fecha.format(formato) + "\n" +
                "Ganador: " + ganador.getNombre() + " (" + ganador.getTipo() + ")\n" +
                "Perdedor: " + perdedor.getNombre() + " (" + perdedor.getTipo() + ")\n" +
                "Duración: " + turnos + " turnos\n";
    }
}
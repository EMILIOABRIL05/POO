package maestrosC;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Batalla {
    private Personaje jugador;
    private Personaje computadora;
    private int turnoActual;
    private static final int LIMITE_TURNOS = 10; // Límite muy bajo de turnos

    public Batalla(Personaje jugador, Personaje computadora) {
        this.jugador = jugador;
        this.computadora = computadora;
        this.turnoActual = 0;
    }

    public ResultadoBatalla iniciar() {
        System.out.println("\n=== INICIO DE BATALLA ===");
        System.out.println(jugador.getNombre() + " VS " + computadora.getNombre());

        // Bucle de batalla con límite estricto
        for (turnoActual = 0; turnoActual < LIMITE_TURNOS; turnoActual++) {
            System.out.println("\n--- Turno " + (turnoActual + 1) + " de " + LIMITE_TURNOS + " ---");

            // Mostrar estado actual
            System.out.println(jugador);
            System.out.println(computadora);

            // Turno del jugador
            System.out.println("\n>> Turno de " + jugador.getNombre());
            CartaDePoder cartaJugador = jugador.obtenerSiguienteCarta(turnoActual);
            jugador.usarCarta(cartaJugador, computadora);

            // Verificar si la computadora ha sido derrotada
            if (computadora.estaVencido()) {
                System.out.println("\n¡" + computadora.getNombre() + " ha sido derrotado!");
                break;
            }

            // Turno de la computadora
            System.out.println("\n>> Turno de " + computadora.getNombre());
            CartaDePoder cartaComputadora = computadora.obtenerSiguienteCarta(turnoActual);
            computadora.usarCarta(cartaComputadora, jugador);

            // Verificar si el jugador ha sido derrotado
            if (jugador.estaVencido()) {
                System.out.println("\n¡" + jugador.getNombre() + " ha sido derrotado!");
                break;
            }

            // Pequeña pausa para mejor visualización
            try {
                Thread.sleep(500); // Reducida a medio segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Determinar ganador
        Personaje ganador, perdedor;

        // Si se alcanzó el límite de turnos sin un ganador claro, gana quien tenga más vida
        if (turnoActual >= LIMITE_TURNOS) {
            System.out.println("\n¡LÍMITE DE TURNOS ALCANZADO!");
            if (jugador.getVida() > computadora.getVida()) {
                ganador = jugador;
                perdedor = computadora;
                System.out.println("¡" + jugador.getNombre() + " gana por tener más vida restante!");
            } else {
                ganador = computadora;
                perdedor = jugador;
                System.out.println("¡" + computadora.getNombre() + " gana por tener más vida restante!");
            }
        } else if (computadora.estaVencido()) {
            ganador = jugador;
            perdedor = computadora;
            System.out.println("\n¡" + jugador.getNombre() + " ha ganado la batalla!");
        } else {
            ganador = computadora;
            perdedor = jugador;
            System.out.println("\n¡" + computadora.getNombre() + " ha ganado la batalla!");
        }

        ResultadoBatalla resultado = new ResultadoBatalla(ganador, perdedor, turnoActual);
        guardarResultado(resultado);
        return resultado;
    }

    private void guardarResultado(ResultadoBatalla resultado) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("resultados_batalla.txt", true))) {
            writer.println(resultado.toString());
            writer.println("------------------------------");
            System.out.println("Resultado guardado en resultados_batalla.txt");
        } catch (IOException e) {
            System.out.println("Error al guardar el resultado: " + e.getMessage());
        }
    }
}
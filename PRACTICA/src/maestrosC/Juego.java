package maestrosC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Juego {
    private List<Personaje> personajes;
    private int victoriasJugador;
    private int victoriasComputadora;

    public Juego() {
        personajes = new ArrayList<>();
        // Personajes con vida reducida para batallas más rápidas
        personajes.add(new Guerrero("Thorgar", 80, 8, 15));
        personajes.add(new Mago("Elindra", 60, 5, 20));
        personajes.add(new Arquero("Legolas", 70, 6, 18));

        victoriasJugador = 0;
        victoriasComputadora = 0;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido a Maestros del Combate!");
        System.out.println("Fecha: 2025-07-09 21:23:11");
        System.out.println("Usuario: EMILIOABRIL05");

        for (int batalla = 1; batalla <= 3; batalla++) {
            if (victoriasJugador == 2 || victoriasComputadora == 2) {
                break; // Si ya hay un ganador (mejor de 3), terminamos
            }

            System.out.println("\n=== BATALLA " + batalla + " de 3 ===");

            // Selección de personaje para el jugador
            Personaje personajeJugador = seleccionarPersonajeJugador(scanner);

            // Selección aleatoria para la computadora (diferente al del jugador)
            Personaje personajeComputadora;
            do {
                int indiceAleatorio = (int) (Math.random() * personajes.size());
                personajeComputadora = personajes.get(indiceAleatorio);
            } while (personajeComputadora.getNombre().equals(personajeJugador.getNombre()));

            System.out.println("\nLa computadora ha elegido a: " + personajeComputadora.getNombre() + " (" + personajeComputadora.getTipo() + ")");

            // Configurar orden de cartas para el jugador
            configurarOrdenCartas(scanner, personajeJugador);

            // Configurar orden aleatorio para la computadora
            List<CartaDePoder> cartasComputadora = personajeComputadora.getCartas();
            List<CartaDePoder> ordenComputadora = new ArrayList<>(cartasComputadora);
            // Mezclamos el orden de las cartas para la computadora
            for (int i = ordenComputadora.size() - 1; i > 0; i--) {
                int j = (int) (Math.random() * (i + 1));
                CartaDePoder temp = ordenComputadora.get(i);
                ordenComputadora.set(i, ordenComputadora.get(j));
                ordenComputadora.set(j, temp);
            }
            personajeComputadora.definirOrdenCartas(ordenComputadora);

            System.out.println("\n¡Comienza la batalla! Presiona Enter para continuar...");
            scanner.nextLine();

            // Iniciar batalla
            Batalla batalla1 = new Batalla(personajeJugador, personajeComputadora);
            ResultadoBatalla resultado = batalla1.iniciar();

            // Actualizar contadores basados en el ganador
            if (resultado.getGanador() == personajeJugador) {
                victoriasJugador++;
                System.out.println("\n>> Punto para el jugador <<");
            } else {
                victoriasComputadora++;
                System.out.println("\n>> Punto para la computadora <<");
            }

            System.out.println("\nMarcador actual: Jugador " + victoriasJugador + " - " + victoriasComputadora + " Computadora");

            if (batalla < 3 && victoriasJugador < 2 && victoriasComputadora < 2) {
                System.out.println("\nPresiona Enter para la siguiente batalla...");
                scanner.nextLine();
            }
        }

        // Resultado final
        System.out.println("\n=== RESULTADO FINAL DEL TORNEO ===");
        if (victoriasJugador > victoriasComputadora) {
            System.out.println("¡FELICIDADES EMILIOABRIL05! Has ganado el torneo " + victoriasJugador + " a " + victoriasComputadora);
        } else {
            System.out.println("La computadora ha ganado el torneo " + victoriasComputadora + " a " + victoriasJugador);
        }

        scanner.close();
    }

    private Personaje seleccionarPersonajeJugador(Scanner scanner) {
        System.out.println("\nPersonajes disponibles:");
        for (int i = 0; i < personajes.size(); i++) {
            Personaje p = personajes.get(i);
            System.out.println((i + 1) + ". " + p.getNombre() + " (" + p.getTipo() + ")");
        }

        int seleccion;
        do {
            System.out.print("\nElige tu personaje (1-" + personajes.size() + "): ");
            try {
                seleccion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                seleccion = -1;
            }
        } while (seleccion < 1 || seleccion > personajes.size());

        return personajes.get(seleccion - 1);
    }

    private void configurarOrdenCartas(Scanner scanner, Personaje personaje) {
        List<CartaDePoder> cartas = personaje.getCartas();
        List<CartaDePoder> ordenCartas = new ArrayList<>();

        System.out.println("\nConfigura el orden en que usarás tus cartas de poder:");
        for (int i = 0; i < cartas.size(); i++) {
            System.out.println((i + 1) + ". " + cartas.get(i));
        }

        System.out.println("\nSelecciona el orden de uso (ingresa los números separados por espacios):");
        String input = scanner.nextLine();
        String[] indices = input.trim().split("\\s+");

        for (String indice : indices) {
            try {
                int idx = Integer.parseInt(indice) - 1;
                if (idx >= 0 && idx < cartas.size()) {
                    ordenCartas.add(cartas.get(idx));
                }
            } catch (NumberFormatException e) {
                // Ignorar entradas no válidas
            }
        }

        // Si no se seleccionaron cartas válidas, usar todas en orden original
        if (ordenCartas.isEmpty()) {
            ordenCartas.addAll(cartas);
        }

        personaje.definirOrdenCartas(ordenCartas);

        System.out.println("\nOrden de cartas configurado:");
        for (int i = 0; i < ordenCartas.size(); i++) {
            System.out.println((i + 1) + ". " + ordenCartas.get(i));
        }
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.iniciar();
    }
}
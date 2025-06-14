import java.util.Scanner;

public class MainCarrera {
    private static Scanner scanner = new Scanner(System.in);

    // Velocidades base predefinidas para cada tipo de vehículo
    private static final double velocidadAutomovil = 80.0;  // km/h
    private static final double velocidadMoto = 120.0;      // km/h
    private static final double velocidadCamion = 60.0;     // km/h

    public static void main(String[] args) {
        System.out.println("===== SIMULADOR DE CARRERAS =====");

        // Solicitar número de vueltas
        int numVueltas = solicitarNumeroVueltas();
        Carrera carrera = new Carrera(numVueltas);

        // Menú para agregar vehículos
        boolean seguirAgregando = true;
        while (seguirAgregando) {
            agregarVehiculo(carrera);

            System.out.print("¿Desea agregar otro vehículo? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            seguirAgregando = respuesta.equals("s") || respuesta.equals("si");
        }

        // Iniciar carrera
        if (!carrera.getVehiculos().isEmpty()) {
            carrera.iniciarCarrera();
        } else {
            System.out.println("No se puede iniciar la carrera sin vehículos");
        }

        scanner.close();
    }

    private static int solicitarNumeroVueltas() {
        int vueltas = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print("Ingrese el número de vueltas para la carrera: ");
            try {
                vueltas = Integer.parseInt(scanner.nextLine().trim());
                if (vueltas > 0) {
                    entradaValida = true;
                } else {
                    System.out.println("El número de vueltas debe ser mayor que cero");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido");
            }
        }

        return vueltas;
    }

    private static void agregarVehiculo(Carrera carrera) {
        System.out.println("\n----- AGREGAR VEHÍCULO -----");

        // Tipo de vehículo
        System.out.println("Seleccione el tipo de vehículo:");
        System.out.println("1. Automovil (Velocidad: " + velocidadAutomovil + " km/h)");
        System.out.println("2. Moto (Velocidad: " + velocidadMoto + " km/h)");
        System.out.println("3. Camion (Velocidad: " + velocidadCamion + " km/h)");

        int tipoVehiculo = 0;
        while (tipoVehiculo < 1 || tipoVehiculo > 3) {
            System.out.print("Opción: ");
            try {
                tipoVehiculo = Integer.parseInt(scanner.nextLine().trim());
                if (tipoVehiculo < 1 || tipoVehiculo > 3) {
                    System.out.println("Opción inválida. Seleccione 1, 2 o 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido");
            }
        }

        // Solicitar datos del vehículo (solo marca y piloto)
        System.out.print("Ingrese la marca del vehículo: ");
        String marca = scanner.nextLine().trim();

        System.out.print("Ingrese el nombre del piloto: ");
        String nombrePiloto = scanner.nextLine().trim();

        // Crear el piloto
        Piloto piloto = new Piloto(nombrePiloto);

        // Crear y agregar el vehículo a la carrera con velocidad predefinida
        Vehiculo vehiculo = null;
        double velocidadBase = 0;

        switch (tipoVehiculo) {
            case 1:
                velocidadBase = velocidadAutomovil;
                vehiculo = new Automovil(marca, piloto, velocidadBase);
                break;
            case 2:
                velocidadBase = velocidadMoto;
                vehiculo = new Moto(marca, piloto, velocidadBase);
                break;
            case 3:
                velocidadBase = velocidadCamion;
                vehiculo = new Camion(marca, piloto, velocidadBase);
                break;
        }

        if (vehiculo != null) {
            carrera.agregarVehiculo(vehiculo);
            System.out.println("Vehículo creado con velocidad base: " + velocidadBase + " km/h");
        }
    }
}
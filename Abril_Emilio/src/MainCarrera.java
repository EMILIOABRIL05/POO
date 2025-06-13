import java.util.Scanner;

public class MainCarrera {
    private static Scanner scanner = new Scanner(System.in);

    // velocidades definidas de cada vehiculo
    private static final double velocidadAutomovil = 80.0;
    private static final double velocidadMoto = 120.0;
    private static final double velocidadCamion = 60.0;
    private static final double velocidadBicicleta=40.0;

    public static void main(String[] args) {
        System.out.println("----SIMULADOR DE CARRERAS----");

        // Solicitar número de vueltas
        int numVueltas = solicitarNumeroVueltas();
        Carrera carrera = new Carrera(numVueltas);


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
        boolean entradaValida =false;

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
        System.out.println("4. Bicicleta (Velocidad: " + velocidadBicicleta + " km/h)");

        int tipoVehiculo = 0;
        while (tipoVehiculo < 1 || tipoVehiculo > 4) {
            System.out.print("Opción: ");
            try {
                tipoVehiculo = Integer.parseInt(scanner.nextLine().trim());
                if (tipoVehiculo < 1 || tipoVehiculo > 4) {
                    System.out.println("Opción inválida. Seleccione 1, 2 , 3 o 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido");
            }
        }

        // solicita datos de vehiculo como la marca y su piloto respectivo
        System.out.print("Ingrese la marca del vehículo: ");
        String marca = scanner.nextLine().trim();

        System.out.print("Ingrese el nombre del piloto: ");
        String nombrePiloto = scanner.nextLine().trim();

        // Crear el piloto
        Piloto piloto = new Piloto(nombrePiloto);

        // Creo y agrego el vehiculo con su respectiva velocidad
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
            case 4:
                velocidadBase = velocidadBicicleta;
                vehiculo = new Bicleta(marca, piloto, velocidadBase);
        }

        if (vehiculo != null) {
            carrera.agregarVehiculo(vehiculo);
            System.out.println("Vehículo creado con velocidad base: " + velocidadBase + " km/h");
        }
    }
}
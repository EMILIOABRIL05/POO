import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

    public class Carrera {
        private List<Vehiculo> vehiculos;
        private int numVueltas;
        private boolean carreraFinalizada;

        public Carrera(int numVueltas) {
            this.vehiculos = new ArrayList<>();
            this.numVueltas = numVueltas;
            this.carreraFinalizada = false;
        }

        public void agregarVehiculo(Vehiculo vehiculo) {

            if (carreraFinalizada) {
                throw new IllegalStateException("No se pueden agregar vehículos: la carrera ya finalizó");
            }

            vehiculos.add(vehiculo);
            System.out.println("Vehículo agregado: " + vehiculo);
        }

        public void iniciarCarrera() {
            if (vehiculos.isEmpty()) {
                System.out.println("No hay vehículos en la carrera");
                return;
            }

            System.out.println("\n¡COMIENZA LA CARRERA CON " + numVueltas + " VUELTAS!");
            System.out.println("*****GRILLA DE PARTIDA*****");
            mostrarGrilla();

            //
            for (int vuelta = 1; vuelta <= numVueltas; vuelta++) {
                System.out.println("\n----- VUELTA# " + vuelta + " -----");
                for (Vehiculo vehiculo : vehiculos) {
                    vehiculo.recorrer();
                    System.out.println(vehiculo + " - Distancia: " + String.format("%.2f", vehiculo.getDistanciaRecorrida())+"m");
                }
            }

            carreraFinalizada = true;
            System.out.println("\n===== CARRERA FINALIZADA =====");
            mostrarResultados();
        }

        private void mostrarGrilla() {
            int posicion = 1;
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(posicion + ". " + vehiculo);
                posicion++;
            }
        }

        public void mostrarResultados() {
            if (!carreraFinalizada) {
                System.out.println("La carrera aún no ha finalizado");
                return;
            }

            // Ordenar vehículos por distancia recorrida (de mayor a menor)
            List<Vehiculo> resultados = new ArrayList<>(vehiculos);
            Collections.sort(resultados, new Comparator<Vehiculo>() {
                @Override
                public int compare(Vehiculo v1, Vehiculo v2) {
                    return Double.compare(v2.getDistanciaRecorrida(), v1.getDistanciaRecorrida());
                }
            });

            System.out.println("\n===== RESULTADOS FINALES =====");
            int posicion = 1;
            for (Vehiculo vehiculo : resultados) {
                System.out.println(posicion + ". " + vehiculo +
                        " - Distancia total: " + String.format("%.2f", vehiculo.getDistanciaRecorrida()));
                posicion++;
            }

            System.out.println("\n¡EL GANADOR DE LA CARRERA ES: " + resultados.get(0) + "!");
        }

        public int getNumVueltas() {
            return numVueltas;
        }

        public List<Vehiculo> getVehiculos() {
            return vehiculos;
        }

        public boolean isCarreraFinalizada() {
            return carreraFinalizada;
        }
    }


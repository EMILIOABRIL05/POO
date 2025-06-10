


    import java.time.LocalDate;

    /**
     * Clase que representa al paquete enviado
     */
    public class Paquete {
        private Cliente emisor, receptor;
        private Mensajero mensajero;
        private double pesoKg;
        private LocalDate fechaEnvio, fechaEntrega;
        private boolean entregado = false;

        /**
         * Constructor que recibe todos los datos necesarios del paquete
         * @param emisor Cliente que envía el paquete
         * @param receptor Cliente que recibe el paquete
         * @param mensajero Mensajero asignado para la entrega
         * @param pesoKg Peso del paquete en kilogramos
         * @param fechaEnvio Fecha en que se envía el paquete
         * @param fechaEntrega Fecha programada para la entrega
         */
        public Paquete(Cliente emisor, Cliente receptor, Mensajero mensajero,
                       double pesoKg, LocalDate fechaEnvio, LocalDate fechaEntrega) {
            this.emisor = emisor;
            this.receptor = receptor;
            this.mensajero = mensajero;
            this.pesoKg = pesoKg;
            this.fechaEnvio = fechaEnvio;
            this.fechaEntrega = fechaEntrega;
        }

        /**
         * @return Cliente emisor del paquete
         */
        public Cliente getEmisor() {
            return emisor;
        }

        /**
         * Establece el cliente emisor del paquete
         * @param emisor Nuevo cliente emisor
         */
        public void setEmisor(Cliente emisor) {
            this.emisor = emisor;
        }

        /**
         * @return Cliente receptor del paquete
         */
        public Cliente getReceptor() {
            return receptor;
        }

        /**
         * Establece el cliente receptor del paquete
         * @param receptor Nuevo cliente receptor
         */
        public void setReceptor(Cliente receptor) {
            this.receptor = receptor;
        }

        /**
         * @return Mensajero asignado a la entrega
         */
        public Mensajero getMensajero() {
            return mensajero;
        }

        /**
         * Establece el mensajero asignado a la entrega
         * @param mensajero Nuevo mensajero asignado
         */
        public void setMensajero(Mensajero mensajero) {
            this.mensajero = mensajero;
        }

        /**
         * @return Peso del paquete en kilogramos
         */
        public double getPesoKg() {
            return pesoKg;
        }

        /**
         * Establece el peso del paquete
         * @param pesoKg Nuevo peso en kilogramos
         */
        public void setPesoKg(double pesoKg) {
            this.pesoKg = pesoKg;
        }

        /**
         * @return Fecha de envío del paquete
         */
        public LocalDate getFechaEnvio() {
            return fechaEnvio;
        }

        /**
         * Establece la fecha de envío
         * @param fechaEnvio Nueva fecha de envío
         */
        public void setFechaEnvio(LocalDate fechaEnvio) {
            this.fechaEnvio = fechaEnvio;
        }

        /**
         * @return Fecha de entrega programada
         */
        public LocalDate getFechaEntrega() {
            return fechaEntrega;
        }

        /**
         * Establece la fecha de entrega programada
         * @param fechaEntrega Nueva fecha de entrega
         */
        public void setFechaEntrega(LocalDate fechaEntrega) {
            this.fechaEntrega = fechaEntrega;
        }

        /**
         * @return Estado de entrega del paquete
         */
        public boolean isEntregado() {
            return entregado;
        }

        /**
         * Establece el estado de entrega del paquete
         * @param entregado Nuevo estado de entrega
         */
        public void setEntregado(boolean entregado) {
            this.entregado = entregado;
        }

        /**
         * Método que valida si la fecha de entrega es posterior o igual a la de envío
         * @return true si las fechas son válidas, false en caso contrario
         */
        public boolean validarFechas() {
            return !fechaEntrega.isBefore(fechaEnvio);
        }

        /**
         * Calcula el costo del envío según el peso (tarifa fija por kg)
         * @return Costo del envío
         */
        public double calcularCosto() {
            return pesoKg * 2.5;
        }

        /**
         * Marca el paquete como entregado
         */
        public void marcarEntregado() {
            entregado = true;
        }

        /**
         * Imprime un recibo detallado con toda la información del envío
         */
        public void imprimirRecibo() {
            System.out.println("\n===== RECIBO =====");
            System.out.printf("Emisor: %s (%s)%n", emisor.getNombre(), emisor.getTelefono());
            System.out.printf("Receptor: %s, %s%n", receptor.getNombre(), receptor.getDireccion());
            System.out.println("Mensajero: " + mensajero.getNombre());
            System.out.printf("Peso: %.2f kg%n", pesoKg);
            System.out.println("Fecha de Envío: " + fechaEnvio);
            System.out.println("Fecha de Entrega: " + fechaEntrega);
            System.out.println("Estado: " + (entregado ? "Entregado" : "Pendiente"));
            System.out.printf("Costo: $%.2f%n", calcularCosto());
            System.out.println("==================");
        }
    }


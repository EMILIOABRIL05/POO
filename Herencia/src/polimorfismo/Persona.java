package polimorfismo;

import java.util.Objects;

// Clase que representa una Persona

/**
 * Clase que representa una Persona e implementa:
 * - AutoCloseable: Para manejo seguro de recursos con try-with-resources
 * - Cloneable: Para permitir la clonación de objetos
 */
public class Persona implements AutoCloseable, Cloneable {

    private String nombre;
    private int edad;
    private boolean recursosLiberados = false; // Simula la gestión de recursos

    public Persona(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // toString, equals, hashCode, clone son métodos heredados de Object y sobreescribibles
    @Override
    public String toString() {
        return String.format("%s(%d).%n", this.nombre, this.edad);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Persona persona = (Persona) obj;
        return this.edad == persona.edad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.edad);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Metodo finalize()
     *
     * CONCEPTO:
     * - Metodo heredado de Object para limpieza final de recursos
     * - Llamado por el Garbage Collector antes de destruir el objeto
     *
     * CARACTERÍSTICAS:
     * - Se ejecuta una vez antes de la recolección de basura
     * - Permite realizar tareas de limpieza final
     *
     * DEBILIDADES:
     * - DEPRECADO desde Java 9
     * - Ejecución NO garantizada
     * - Puede causar problemas de rendimiento
     * - No es un mecanismo confiable para liberación de recursos
     */
    @Deprecated(since = "9", forRemoval = true)
    @Override
    protected void finalize() throws Throwable {
        try {
            if (!recursosLiberados) {
                System.out.println("finalize() llamado. Liberando recursos de " + this.nombre);
                liberarRecursos(); // simulación de limpieza
            }
        } catch (Exception e) {
            System.err.println("Error en finalize(): " + e.getMessage());
        } finally {
            super.finalize(); // Llamada a Object.finalize()
        }
    }

    /**
     * Metodo close()
     *
     * CONCEPTO:
     * - Metodo de la interfaz AutoCloseable
     * - Diseñado para liberación explícita de recursos
     *
     * CARACTERÍSTICAS:
     * - Permite control manual de cierre de recursos
     * - Compatible con try-with-resources
     * - Metodo seguro para liberar recursos
     *
     * DEBILIDADES:
     * - Requiere implementación manual
     * - Posible lanzamiento de excepciones
     * - Necesita manejo explícito por parte del desarrollador
     */
    @Override
    public void close() throws Exception {
        if (!recursosLiberados) {
            try {
                System.out.println("close() llamado. Cerrando recursos de " + this.nombre);
                liberarRecursos();
            } catch (Exception e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
                throw e;
            }
        }
    }

    // Metodo privado para simular liberación de recursos
    private void liberarRecursos() {
        this.nombre = null;
        this.edad = 0;
        this.recursosLiberados = true;
    }
}

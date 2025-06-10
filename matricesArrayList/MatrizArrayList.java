package matricesArrayList;

import java.util.ArrayList;
import java.util.List;

public class MatrizArrayList {

    private int filas;
    private int columnas;
    /** Declaración e inicialización de la matriz como una lista de listas.
     Cada elemento de la lista principal representa una fila (List<Integer>),
     y cada fila contiene los elementos (enteros) de esa fila.
     Es equivalente a una matriz bidimensional, pero usando ArrayList para flexibilidad.
     **/
    private List<List<Integer>> matriz = new ArrayList<>();

    /**
     * Construye una matriz de tamaño filas×columnas,
     * inicializando cada posición con 0.
     * Lanza IllegalArgumentException si filas o columnas ≤ 0.
     */
    public MatrizArrayList(int filas, int columnas) {
        if (filas <= 0 || columnas <= 0) {
            throw new IllegalArgumentException(
                    "El número de filas y columnas debe ser mayor que 0"
            );
        }
        this.filas = filas;
        this.columnas = columnas;

        // Crear lista de listas: cada "fila" es un ArrayList de tamaño 'columnas'
        for (int i = 0; i < filas; i++) {
            ArrayList<Integer> fila = new ArrayList<>();
            for (int j = 0; j < columnas; j++) {
                fila.add(0);  // valor inicial neutro
            }
            matriz.add(fila);
        }
    }

    /** Devuelve el número de filas de la matriz. */
    public int getFilas() {
        return filas;
    }

    /** Devuelve el número de columnas de la matriz. */
    public int getColumnas() {
        return columnas;
    }

    /**
     * Retorna el valor en (fila, columna).
     * Comprueba límites y lanza IndexOutOfBoundsException si están fuera de rango.
     */
    public int getValor(int fila, int columna) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            throw new IndexOutOfBoundsException("Índices fuera de rango.");
        }
        return matriz.get(fila).get(columna);
    }

    /**
     * Asigna un valor en (fila, columna).
     * Valida índices igual que getValor.
     */
    public void setValor(int fila, int columna, int valor) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            throw new IndexOutOfBoundsException("Índices fuera de rango.");
        }
        matriz.get(fila).set(columna, valor);
    }

    /**
     * Devuelve la lista completa de una fila (útil para impresión o iteración).
     * Valida que el índice de fila exista.
     */
    public List<Integer> getFila(int fila) {
        if (fila < 0 || fila >= filas) {
            throw new IndexOutOfBoundsException("Índice de fila fuera de rango.");
        }
        return matriz.get(fila);
    }

    /**
     * Genera una representación en texto de la matriz,
     * con cada fila en una línea y formato [a, b, c].
     * Ideal para depuración o mostrar resultados al usuario.
     */
    public String toFormattedString() {
        StringBuilder sb = new StringBuilder();
        for (List<Integer> fila : matriz) {
            sb.append(fila.toString())
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}

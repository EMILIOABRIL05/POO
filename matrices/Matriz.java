package matrices;

import java.util.Arrays;

public class Matriz {

    private final int filas;
    private final int columnas;
    private final int[][] matriz;

    public Matriz(int filas, int columnas) {
        // Validaciones para tamaños de matriz sean distintas a 0
        if (filas <= 0) {
            throw new IllegalArgumentException("El número de filas debe ser mayor que 0");
        }
        if (columnas <= 0) {
            throw new IllegalArgumentException("El número de columnas debe ser mayor que 0");
        }
        
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new int[filas][columnas];
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    // Excepción para acceso a valor de matriz
    public int getValor(int a, int b) {
        // Validar rangos de índices
        if (a < 0 || a >= filas) {
            throw new IndexOutOfBoundsException("Índice de fila fuera de rango: " + a);
        }
        if (b < 0 || b >= columnas) {
            throw new IndexOutOfBoundsException("Índice de columna fuera de rango: " + b);
        }
        
        return this.matriz[a][b];
    }

    @Override
    public String toString() {
        // Crea un objeto StringBuilder para construir una cadena grande más eficientemente que con concatenación
        StringBuilder sb = new StringBuilder();

        // Recorre todas las filas de la matriz usando un índice 'i'
        for(int i = 0; i < this.filas; i++) {

            // Convierte la fila i (que es un arreglo) a una cadena legible como [1, 2, 3]
            // y la añade al StringBuilder. Esto es útil para mostrar la fila completa como texto.
            sb.append(Arrays.toString(matriz[i]))

                    // Añade un salto de línea específico del sistema operativo (Windows: "\r\n", Linux/Mac: "\n")
                    .append(System.lineSeparator());
        }

        // Retorna el contenido final como una sola cadena con todas las filas de la matriz separadas por líneas
        return sb.toString();
    }
}
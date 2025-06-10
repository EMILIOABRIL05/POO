package matricesArrayList;

public class OperacionesArrayList {

    public static MatrizArrayList multiplicar(MatrizArrayList matriz1, MatrizArrayList matriz2) {
        if (matriz1.getColumnas() != matriz2.getFilas()) {
            throw new IllegalArgumentException("Las matrices no son compatibles para multiplicación. " +
                    "El número de columnas de la primera matriz (" + matriz1.getColumnas() +
                    ") debe ser igual al número de filas de la segunda matriz (" + matriz2.getFilas() + ")");
        }

        int filasResultado = matriz1.getFilas();
        int columnasResultado = matriz2.getColumnas();
        int dimensionComun = matriz1.getColumnas();

        MatrizArrayList resultado = new MatrizArrayList(filasResultado, columnasResultado);

        // Recorre cada fila de la matriz resultado
        for (int i = 0; i < filasResultado; i++) {
            // Recorre cada columna de la matriz resultado
            for (int j = 0; j < columnasResultado; j++) {
                int suma = 0;  // Acumula la suma del producto escalar de la fila i y la columna j

                // Multiplica los elementos correspondientes de la fila i de matriz1
                // y la columna j de matriz2, acumulando el resultado en 'suma'
                for (int k = 0; k < dimensionComun; k++) {
                    suma += matriz1.getValor(i, k)  // elemento de la fila i, columna k de la primera matriz
                            * matriz2.getValor(k, j); // elemento de la fila k, columna j de la segunda matriz
                }

                // Asigna el valor calculado a la posición (i, j) de la matriz resultado
                resultado.setValor(i, j, suma);
            }
        }

        return resultado;
    }
}

package matrices;

public class Operacion {
    public Matriz multiplicar(Matriz a, Matriz b) {
        // Validar que las matrices sean multiplicables
        if (a == null || b == null) {
            throw new NullPointerException("Las matrices no pueden ser nulas");
        }
        // Implementación de la multiplicación de matrices
        Matriz resultado = new Matriz(a.getFilas(), b.getColumnas());

        // Lógica de multiplicación
        // Itera a través de las filas de la matriz A
        for (int i = 0; i < a.getFilas(); i++) {
            // Itera a través de las columnas de la matriz B 
            for (int j = 0; j < b.getColumnas(); j++) {
                int suma = 0;
                // Itera para calcular el producto escalar entre la fila i de A y la columna j de B
                for (int k = 0; k < a.getColumnas(); k++) {
                    // Multiplica el valor de la posición i,k de la matriz A por el valor de la posición k,j de la matriz B y lo acumula en suma
                    suma += a.getValor(i, k) * b.getValor(k, j);
                }
                resultado.getMatriz()[i][j] = suma;
            }
        }
        return resultado;
    }
}

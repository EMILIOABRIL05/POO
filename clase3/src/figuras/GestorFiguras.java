package figuras;

import java.util.Arrays;

public class GestorFiguras {
    private Figura[] figuras;
    private int cantidadFiguras;
    private static final int MAX_FIGURAS = 40;

    public GestorFiguras() {
        figuras = new Figura[MAX_FIGURAS];
        cantidadFiguras = 0;
    }

    public boolean insertarFigura(Figura figura) {
        if (figura == null || cantidadFiguras >= MAX_FIGURAS) {
            return false;
        }
        figuras[cantidadFiguras++] = figura;
        return true;
    }

    public boolean eliminarFigura(int indice) {
        if (indice < 0 || indice >= cantidadFiguras) {
            return false;
        }
        figuras[indice] = figuras[cantidadFiguras - 1];
        figuras[cantidadFiguras - 1] = null;
        cantidadFiguras--;
        return true;
    }

    public double calcularAreaTotal() {
        double areaTotal = 0;
        for (int i = 0; i < cantidadFiguras; i++) {
            areaTotal += figuras[i].calcularArea();
        }
        return areaTotal;
    }

    public double calcularAreaPromedio() {
        if (cantidadFiguras == 0) {
            return 0;
        }
        return calcularAreaTotal() / cantidadFiguras;
    }

    public void ordenarPorArea() {
        if (cantidadFiguras > 1) {
            Arrays.sort(figuras, 0, cantidadFiguras);
        }
    }

    public void listarFiguras() {
        if (cantidadFiguras == 0) {
            System.out.println("No hay figuras registradas");
            return;
        }

        System.out.println("\nListado de figuras:");
        System.out.println("----------------------");
        for (int i = 0; i < cantidadFiguras; i++) {
            System.out.printf("%d. %s\n", (i + 1), figuras[i]);
        }
        System.out.println("----------------------");
    }

    public int getCantidadFiguras() {
        return cantidadFiguras;
    }
}

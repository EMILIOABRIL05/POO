package comercio;

import java.util.ArrayList;
import java.util.List;

public class GestorOrden {
    private List<Orden> ordenes;

    public GestorOrden() {
        this.ordenes = new ArrayList<>();
    }

    public void encolarOrden(Orden orden) {
        ordenes.add(orden);
    }

    public boolean tieneOrdenes() {
        return !ordenes.isEmpty();
    }

    public Orden getUltimaOrden() {
        if (!ordenes.isEmpty()) {
            return ordenes.get(ordenes.size() - 1);
        }
        return null;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Orden orden : ordenes) {
            sb.append(orden.toString()).append("\n");
        }
        return sb.toString();
    }
}
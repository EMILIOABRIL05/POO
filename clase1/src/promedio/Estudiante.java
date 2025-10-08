package promedio;

public class Estudiante {
    private int cantMaterias;
    private Float[] notas;

    public Estudiante(int cantMaterias) {
        this.cantMaterias = cantMaterias;
        this.notas = new Float[cantMaterias];
    }

    public boolean registrar(Float value) {
        if (value == null || value < 0 || value > 10) {
            return false;
        }

        for (int i = 0; i < this.cantMaterias; i++) {
            if (notas[i] == null) {
                notas[i] = value;
                return true;
            }
        }
        return false; // si no encuentra espacio libre
    }

    public float promedio() {
        float suma = 0;
        int cant = 0;

        for (Float valor : this.notas) { // importante usar Float, no float
            if (valor != null) {
                suma += valor;
                cant++;// contar cuantas notas validas hay
            }
        }
        return (cant == 0) ? -1 : (suma / cant);
    }
}

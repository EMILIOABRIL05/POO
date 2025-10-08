package promedio;

public class Main {
    public static void main(String[] args) {
        Estudiante e = new Estudiante(5);
        e.registrar(5.0f);
        e.registrar(8.0f);
        e.registrar(3.0f);
        e.registrar(2.0f);
        e.registrar(1.0f);

        System.out.println("El promedio de nota es: " + e.promedio());
    }
}

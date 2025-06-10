package fiesta;

public class AppFiesta {

    public static void main(String[] args) {
        try {
            Organizador ximena = new Organizador(
                    "Ximena", "Carcelen", "1723494430",
                    "Direccion de Cultura de Quito", "ximena@gmail.com"
            );
            Evento expo = new Evento(
                    "Exposicion de Pintura",
                    new Fecha(18,2,2025),
                    new Fecha(23,2,2025),
                    ximena,
                    "Casa de la Cultura"
            );
            Participante jesus = new Participante(
                    "1893948587", "Jesus Mateo", "Urbina",
                    "Ambato", "jesus@gmail.com", "0998238344"
            );
            Participante maria = new Participante(
                    "1822403844", "Maria Magdalena", "Quishpe",
                    "Quito", "maria@gmail.com", "0995244382"
            );
            expo.inscribir(jesus);
            expo.inscribir(maria);

            System.out.println(expo);
            System.out.println();
            System.out.println(jesus);
            System.out.println();
            System.out.println(maria);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

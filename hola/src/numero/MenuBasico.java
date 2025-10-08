package numero;
import java.util.Scanner;
public class MenuBasico {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- MENU DE OPCIONES ---");
            System.out.println("1. Saludo personalizado");
            System.out.println("2. Verificar si es par o impar");
            System.out.println("3. Tabla de multiplicar");
            System.out.println("4. Contador ascendente");
            System.out.println("5. Suma acumulativa");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();



            switch (opcion) {
                case 1 :
                    Saludo.ejecutar(sc);
                    break;
                case 2 :
                    ParImpar.ejecutar(sc);
                    break;
                case 3 :
                    TablaNum.ejecutar(sc);
                    break;
                case 4 :
                    break;
                case 5 :
                    break;
                case 0 :
                    System.out.println("Saliendo del programa...");
                    break;


            }
        } while (opcion != 0);



    }
}
package numero;
import java.util.Scanner;

public class Saludo {
    public static void ejecutar(Scanner sc){

        System.out.println("Ingrese su nombre: ");
        sc.nextLine();


        String nombre = sc.nextLine();

        System.out.println("Hola " + nombre);



    }

}

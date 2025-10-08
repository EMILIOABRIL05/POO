package numero;

public class TablaNum {

    public static void ejecutar(int numero){
        for (int i = 1; i <= 10; i++){
            System.out.printf("%d x %d = %d\n", numero, i, numero * i);
        }
    }

}

package ejemplos;

public class UsoGrafico {

    public static void main(String[] args) {

        int[] a; // Arreglo que solo almacena enteros, que se llama a; declaracion normal de Java
        int b[]; // Arreglo que se llama b, y que solo admite enteros, declaracion normal de C
        // ningun arreglo tradicional sirve para nada si no se ha definido su limite.

        a = new int[10];
        b = new int[]{1,2,3,4,5,6,7,8};

        for(int i: a) {

            System.out.println(i);
        }
        System.out.println();
        for(int i = 0; i< b.length;i++) {

            System.out.println(b[i]);
        }

        int[] datos = new int[]{5,6,9,8,7,5,4,8,9,2,4,8,6};

        System.out.printf("%s%12s%n","Pregunta","Respuestas");

        for(int i = 0; i< datos.length;i++) {

            System.out.printf("%5d",i+1);
            for(int j = 1; j <=datos[i];j++) {

                System.out.print("&");
            }
            System.out.println();
        }



    }
}

package ejemplos;

public class UsoExcepcion {

    public static void main(String[] args) {

        int[] a = new int[]{1,2,3,4,5}; // El arreglo siempre recorre desde 0 hasta n-1, siendo n el length total del
        // arreglo.
        for(int i = 0; i < a.length;i++) {

            try {

                System.out.println(a[i]);
            } catch(ArrayIndexOutOfBoundsException e) {

                System.out.println(e.getMessage());
            }

        }

        int[] item = new int[6];
        int[] respuestas = new int[]{1,5,4,8,7,8,9,5,4,8,9,6,3,2,5,7,8};

        for(int i = 0; i < respuestas.length; i++) {

            try {

                item[respuestas[i]]++;
            } catch(ArrayIndexOutOfBoundsException e) {

                System.out.printf("%s: El error vino del indice [%d], que tiene un valor de %d%n",e.getMessage(),i,
                        respuestas[i]);
            }
        }

        System.out.printf("%s%10s%n","Respuesta","Cantidad");
        for(int i = 0; i < item.length;i++) {

            System.out.printf("%7d%11d%n",i+1,item[i]);
        }
    }
}

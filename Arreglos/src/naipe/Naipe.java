package naipe;



public class Naipe {



    public static void main(String[] args) {



        Carta cr1 = new Carta("Palmera","48");

        System.out.println(cr1.toString());



        Mazo mz1 = new Mazo();

        mz1.Imprimir();

        System.out.println();

        mz1.barajar();

        mz1.Imprimir();

        System.out.println();

        System.out.println(mz1.siguienteCarta().toString());

        System.out.println(mz1.siguienteCarta().toString());

        System.out.println();

        mz1.Imprimir();

        System.out.println();

        System.out.println(mz1.siguienteCarta().toString());

   }

}
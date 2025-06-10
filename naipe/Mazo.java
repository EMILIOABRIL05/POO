package naipe;

import java.security.SecureRandom;

public class Mazo {

    private final int CARTAS = 52;
    private Carta[] mazo = new Carta[CARTAS];
    private int cartaVista;

    SecureRandom sr = new SecureRandom();


    public Mazo() {

        String[] numero = {"As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez", "Valete", "Dama", "Rey"};
        String[] palo = {"Corazones", "Diamantes", "Espadas", "Treboles"};

        for (int i = 0; i < mazo.length; i++) {

            mazo[i] = new Carta(palo[i / 13], numero[i % 13]);

            /*

            int indice = 0;
            for(String palos: palo){

                for(String numeros: numero){

                    mazo[indice] = new Carta(palos, numeros);
                    indice++;
                }
            }

             */

        }

    }

    public Carta[] getMazo() {
        return mazo;
    }

    public void setMazo(Carta[] mazo) {
        this.mazo = mazo;
    }

    public int getCartaVista() {
        return cartaVista;
    }

    public void setCartaVista(int cartaVista) {
        this.cartaVista = cartaVista;
    }

    public void barajar() {

        for (int i = 0; i < CARTAS; i++) {

            int nuevaPosicion = sr.nextInt(CARTAS);

            Carta fantasma = mazo[nuevaPosicion];
            mazo[nuevaPosicion] = mazo[i];
            mazo[i] = fantasma;
        }
    }

    public Carta siguienteCarta() {

        if (this.cartaVista < CARTAS) {

            return mazo[cartaVista++];
        } else {
            System.out.println("Se acabaron las cartas");
            return null;
        }
    }

    public void Imprimir() {

        for (Carta carta : mazo) {

            System.out.println(carta);
        }


    }
}
package ejemplos;

import java.security.SecureRandom;

public class UsoDados {

    public static void main(String[] args) {

        SecureRandom st = new SecureRandom();

        int[] caraDado = new int[6];

        for(int i = 0; i< 600000;i++) {

            int j = st.nextInt(6);
            caraDado[j]++;
        }

        System.out.printf("%s%12s%n","Cara","Aparicion");
        for(int i = 0; i < caraDado.length;i++) {

            System.out.printf("%3d%12d%n",i+1,caraDado[i]);
        }
    }
}

import java.util.concurrent.ThreadLocalRandom;

public class Dados {
   private int valor;
   public  void lanzar(){
      valor = ThreadLocalRandom.current().nextInt(1, 7);

   }
   public int getValor(){
      return valor;
   }
}

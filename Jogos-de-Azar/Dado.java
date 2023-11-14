import java.io.Serializable;
import java.util.Random;
public class Dado implements Serializable{
  private int sideUp;
   //Gera Valores Aleatorios de 1 a 6.
   public Dado(){
      Random x = new Random();
      sideUp = x.nextInt(6) +1;
   }
   //Armazenao valor do dado
   public Dado(int s){
      sideUp=s;
   }
   public int getSideUp(){
      return sideUp;
   }
   //Rola o dado sem gerar um novo dado
   public void roll(){
      Random x = new Random();
      sideUp = x.nextInt(6) +1;
   }
   public String toString()
   {
      return "Lado "+ sideUp ;
   }
}


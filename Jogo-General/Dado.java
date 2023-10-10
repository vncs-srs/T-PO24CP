import java.io.Serializable;
import java.util.Random;
public class Dado implements Serializable{
  private int sideUp;

   public Dado(){
      Random x = new Random();
      sideUp = x.nextInt(6) +1;
   }
   public Dado(int s){
      sideUp=s;
   }
   public int getSideUp(){
      return sideUp;
   }
   public void roll(){
      Random x = new Random();
      sideUp = x.nextInt(6) +1;
   }
   public String toString()
   {
      return "Lado do dado: "+ sideUp ;
      //arrumar isso aqui
   }
}


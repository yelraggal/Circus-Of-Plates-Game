package AbstractFactory;
import java.util.Random;


public class FactoryMaker {
   private static BallFactory ballFactory;
   private static PlateFactory bFactory;
    
    public static AbstractFactory getFactory() {
        
        Random randomGenerator = new Random();  
        int index = randomGenerator.nextInt(2);
       

        switch(index){
            case 0: 
            {   if(ballFactory==null)
                return new BallFactory();
                else
                return ballFactory;
            }  
            case 1: 
            {   if(bFactory==null)
                return new PlateFactory();       
                else
                return bFactory;
            }
        }
       return null;  
    }
}

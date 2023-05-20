package AbstractFactory;

import eg.edu.alexu.csd.oop.game.sample.object.Shape;
import java.awt.Color;
import java.util.Random;

public abstract class AbstractFactory {
    
    public abstract Shape createShape(int level);
    
    protected int generateX(int [] positionX, int generateTo){
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(generateTo);   
        return positionX[index];
    }
        
    
    protected int generateY(int [] positionY, int generateTo){   
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(generateTo);
        return positionY[index];
    }
    
     protected Color getRandColor() {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(4);      
        return ColorFactory.getInstance().getColor(index);
    }
    
}

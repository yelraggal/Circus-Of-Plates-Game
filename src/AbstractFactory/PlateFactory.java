package AbstractFactory;

import Strategy.MovingHorizontal;
import eg.edu.alexu.csd.oop.game.sample.object.Plate;
import eg.edu.alexu.csd.oop.game.sample.object.Shape;
import java.awt.Color;
import java.util.HashMap;

public class PlateFactory extends AbstractFactory {

    private int[] positionY = {40, 80};
    private int[] positionX = {0, 800};   
    private static final HashMap<Color, Shape> usedObjects = new HashMap<Color, Shape>(); //FlY Weight

    @Override
    public Shape createShape(int level) {// 1 or 2 or 3 (easy meduim hard)
        
        Color color = getRandColor();
        Shape shape = usedObjects.get(color);

        switch (level) {
            case 1:

                if (shape == null || shape.isOnScreen()) {//creates a new object if the same object is on screen 
                    shape = new Plate(false, color);
                    usedObjects.put(color, shape);
                }
                shape.setX(generateX(positionX, 2));
                shape.setY(generateY(positionY, 1));
                break;

            case 2:
                int x, y;
                do {
                    x = generateX(positionX, 2);
                    y = generateY(positionY, 2);
                } while ((x == 800 && y == 80));

                if (shape == null || shape.isOnScreen()) {//creates a new object if the same object is on screen 
                    shape = new Plate(false, color);
                    usedObjects.put(color, shape);
                }
                shape.setX(x);
                shape.setY(y);
                break;
            case 3:

                if (shape == null || shape.isOnScreen()) {//creates a new object if the same object is on screen 
                    shape = new Plate(false, color);
                    usedObjects.put(color, shape);
                }
                shape.setX(generateX(positionX, 2));
                shape.setY(generateY(positionY, 2));
                break;
        }

        shape.setOnScreen(true);
        shape.setMovingDirection(new MovingHorizontal());
        
        return shape;

    }

}
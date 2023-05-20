package AbstractFactory;

import Strategy.MovingHorizontal;
import eg.edu.alexu.csd.oop.game.sample.object.Ball;
import eg.edu.alexu.csd.oop.game.sample.object.Shape;
import java.awt.Color;
import java.util.HashMap;

public class BallFactory extends AbstractFactory {

    private static int[] positionY = {18, 58};
    private static int[] positionX = {0, 800};
    private static final HashMap<Color, Shape> usedObjects = new HashMap<Color, Shape>();

    @Override
    public Shape createShape(int level) {

        Color color = getRandColor();
        Shape shape = usedObjects.get(color);//FLYWEIGHT DESIGN PATTERN

        switch (level) {
            case 1:

                if (shape == null || shape.isOnScreen()) {//creates a new object if the same object is on screen 
                    shape = new Ball(false, color);
                    usedObjects.put(color, shape);
                } 
                shape.setX(generateX(positionX, 2));
                shape.setY(generateY(positionY, 1));
                break;

            case 2:
                int x, y;
                do {
                    x = generateX(positionX, 2);
                    y = generateX(positionY, 2);
                } while ((x == 800 && y == 58));

                if (shape == null || shape.isOnScreen()) {//creates a new object if the same object is on screen 
                    shape = new Ball(false, color);
                    usedObjects.put(color, shape);
                }

                shape.setX(x);
                shape.setY(y);
                break;
                
            case 3:

                if (shape == null || shape.isOnScreen()) {//creates a new object if the same object is on screen 
                    shape = new Ball(false, color);
                    usedObjects.put(color, shape);
                } 
                shape.setX(generateX(positionX, 2));
                shape.setY(generateY(positionY, 2));
                break;
        }

        shape.setMovingDirection(new MovingHorizontal());
        shape.setOnScreen(true);
        return shape;

    }

}

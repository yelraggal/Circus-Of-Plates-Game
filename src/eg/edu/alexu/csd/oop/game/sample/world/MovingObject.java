package eg.edu.alexu.csd.oop.game.sample.world;

import AbstractFactory.FactoryMaker;
import eg.edu.alexu.csd.oop.game.sample.object.Shape;

public class MovingObject {

    private static Shape obj;
    private static MovingObject instance;

    private MovingObject() {
    }

    public static MovingObject getInstance() {

        if (instance == null) {
            instance = new MovingObject();
        }
        return instance;

    }

    public static Shape movingObject(int levelIndex) {          
        obj = FactoryMaker.getFactory().createShape(levelIndex);
        return obj;
    }
}

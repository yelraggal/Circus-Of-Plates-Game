
package Strategy;

import eg.edu.alexu.csd.oop.game.sample.object.Shape;

public class MovingVertical implements Strategy {

    @Override
    public boolean isMovingHorizontal() {
        return false;
    }

     @Override
    public void move(Shape shape){
         shape.setY(shape.getY() + 2);
    }

}

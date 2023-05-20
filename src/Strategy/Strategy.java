
package Strategy;

import eg.edu.alexu.csd.oop.game.sample.object.Shape;

public interface Strategy {

    boolean isMovingHorizontal();
    void move(Shape plate);

}

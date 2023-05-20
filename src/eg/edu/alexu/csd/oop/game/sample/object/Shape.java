package eg.edu.alexu.csd.oop.game.sample.object;

import Strategy.MovingHorizontal;
import Strategy.Strategy;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.Color;
import java.awt.image.BufferedImage;

public abstract class Shape implements GameObject {

    private static final int MAX_MSTATE = 1;
    private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private boolean horizontalOnly;
    private Color color;
    private Strategy movingDirection = new MovingHorizontal();
    private boolean onScreen;
    private boolean isInControl;

    public Shape(int width, int height, boolean visibile, boolean horizontalOnly, Color color) {
        this.height = height;
        this.width = width;
        this.horizontalOnly = horizontalOnly;
        this.color = color;
        this.visible = true;
        spriteImages[0] = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        onScreen = true;
        isInControl=false;
    }

    public void setIsInControl(boolean isInControl) {
        this.isInControl = isInControl;
    }
    

    public void setOnScreen(boolean onScreen) {
        this.onScreen = onScreen;
    }

    public boolean isOnScreen() {
        return onScreen;
    }

    public Strategy getMovingDirection() {
        return movingDirection;
    }

    public void setMovingDirection(Strategy movingDirection) {
        this.movingDirection = movingDirection;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int mX) {
        this.x = mX;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int mY) {
        if (horizontalOnly||isInControl) 
        {
            return;
        }
        this.y = mY;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    public Color getColor() {
        return this.color;
    }
    
     public void setHorizontalOnly(boolean horizontalOnly) {
        this.horizontalOnly = horizontalOnly;
    }

}

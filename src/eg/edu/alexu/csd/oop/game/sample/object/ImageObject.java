package eg.edu.alexu.csd.oop.game.sample.object;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import eg.edu.alexu.csd.oop.game.GameObject;

public class ImageObject implements GameObject { // background & clown & stickes

    private static final int MAX_MSTATE = 2;
    // an array of sprite images that are drawn sequentially
    private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
    private int x;
    private int y;
    private boolean visible;
    private boolean horizontalOnly;
    private boolean clown;
    private String path2;
    
    public ImageObject(int posX, int posY, String path,String path2) { 
        this(posX, posY, path,true,path2);

    }

    public ImageObject(int posX, int posY, String path,boolean horizontalOnly,String path2) {
        this.x = posX;
        this.y = posY;
        this.visible = true;
        this.horizontalOnly = horizontalOnly;
        // create a bunch of buffered images and place into an array, to be displayed sequentially
        try {
            spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
            spriteImages[1] = ImageIO.read(getClass().getResourceAsStream(path2));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        if (horizontalOnly) {
            return;
        }
        this.y = mY;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }

    @Override
    public int getWidth() {
        return spriteImages[0].getWidth();
    }

    @Override
    public int getHeight() {
        return spriteImages[0].getHeight();
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) { // used this method in factroy for the concept of flyweight
        this.visible = visible;
    }

}

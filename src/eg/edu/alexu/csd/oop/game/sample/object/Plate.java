package eg.edu.alexu.csd.oop.game.sample.object;

import Observer.Observer;
import eg.edu.alexu.csd.oop.game.sample.world.GameDataManager;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Plate extends Shape implements Observer{
  
    private BufferedImage[] spriteImages;
        
    public Plate(boolean horizontalOnly, Color color) {
        super(40, 8,true, horizontalOnly, color);
        String path = null;
        spriteImages = getSpriteImages();
        
        if (color == color.RED){
            path=(GameDataManager.getInstance().getThemes().GetPlates("red"));

    }
        else if(color == color.YELLOW){
            path=(GameDataManager.getInstance().getThemes().GetPlates("yellow"));

    }
        else if(color== color.BLUE){
            path=(GameDataManager.getInstance().getThemes().GetPlates("blue"));

    }
         else if (color == color.BLACK){
            path=(GameDataManager.getInstance().getThemes().GetPlates("black"));

    }
         try {
            spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    
}

    @Override
    public void update() { // observer method
       this.setOnScreen(true); 
    }
}

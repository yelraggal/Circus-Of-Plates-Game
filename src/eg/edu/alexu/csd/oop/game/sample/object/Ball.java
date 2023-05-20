/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game.sample.object;

import Observer.Observer;
import eg.edu.alexu.csd.oop.game.sample.world.GameDataManager;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Ball extends Shape implements Observer{
    
    private BufferedImage[] spriteImages;

    
    public Ball(boolean horizontalOnly, Color color) {
        super(30, 30,true, horizontalOnly, color);
        String path = null;
        spriteImages = getSpriteImages();
        
        if (color == color.RED){
            path=(GameDataManager.getInstance().getThemes().GetBalls("red"));
    }
        else if(color == color.YELLOW){
            path=(GameDataManager.getInstance().getThemes().GetBalls("yellow"));

    }
        else if(color == color.BLUE){
            path=(GameDataManager.getInstance().getThemes().GetBalls("blue"));

    }
         else if (color == color.BLACK){
            path=(GameDataManager.getInstance().getThemes().GetBalls("black"));

    }
         try {
            spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }   
}

    @Override
    public void update() {
       this.setOnScreen(true);
       //this.setVisible(false);
    }
}
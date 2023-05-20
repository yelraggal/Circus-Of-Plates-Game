package AbstractFactory;

import java.awt.Color;
import java.util.HashMap;

public class ColorFactory {

    private static ColorFactory instance;
    private static final HashMap<Integer, Color> randomColors = new HashMap<>();

    private ColorFactory(){
        randomColors.put(0, Color.BLUE);
        randomColors.put(1, Color.BLACK);
        randomColors.put(2, Color.RED);
        randomColors.put(3, Color.YELLOW);
    }

    public static ColorFactory getInstance() {

        if (instance == null){
            instance = new ColorFactory();
        }
        return instance;

    }

    public Color getColor(int randomNumber) {
        return randomColors.get(randomNumber);
    }

}

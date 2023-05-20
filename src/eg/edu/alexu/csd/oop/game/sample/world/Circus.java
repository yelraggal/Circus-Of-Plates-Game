package eg.edu.alexu.csd.oop.game.sample.world;

import MVC.Audio;
import Memento.Caretaker;
import Memento.Orginator;

import Observer.StickSubject;

import State.DifficultyState;
import State.Medium;
import State.Hard;
import State.Easy;

import ThemeStrategy.Theme1;
import ThemeStrategy.Theme2;
import ThemeStrategy.Theme3;
import ThemeStrategy.Themes;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.sample.object.BarObject;
import eg.edu.alexu.csd.oop.game.sample.object.ImageObject;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

public class Circus implements World {

    private static final int MAX_TIME = 1 * 60 * 1000;	// 1 minute
    private static long startTime = System.currentTimeMillis();
    private static long time = 0;
    private final int width;
    private final int height;
    // makemethod for backgroud and method for barart

    private final List<GameObject> constant = new LinkedList<>(); // barat
    private final List<GameObject> moving = new LinkedList<>();// kwr GetPlates
    private final List<GameObject> control = new LinkedList<>();// clown & swr l 3osyan

    //stores indices of shape in control
    private final List<Integer> pileLeft = new LinkedList<Integer>();// catch things in left Hand 
    private final List<Integer> pileRight = new LinkedList<Integer>();

    private String Difficulty;//from combBox

    private boolean count15 = true;
    private boolean count30 = true;
    private boolean count45 = true;

    private DifficultyState state;


    private Themes themes;

    private Playing playing;// has execute

    private StickSubject subject;

    
    public Circus(int screenWidth, int screenHeight, String Difficulty, int themeChoose) {
        width = screenWidth;
        height = screenHeight;
  
        if (themeChoose==1) {
            themes = new Theme1();
        }
        if (themeChoose==2) {
            themes = new Theme2();
        }
        if (themeChoose==3) {
            themes = new Theme3();
        }       
        GameDataManager.getInstance().setThemes(themes);

        constant.add(new ImageObject(0, 0, themes.getbackgroud(), themes.getbackgroud())); // backGrounds

//        GameDataManager.getInstance().setScoreAfterNewgame();

        if (Difficulty.equalsIgnoreCase("Easy")) {
            state = new Easy();
            GameDataManager.getInstance().setLevelIndex(1); // we use lvl index when we want to create new plates
                                                                    // bb3t l index da 3lshan aadr a3rf ana htl3 plates mn 2ni
        } else if (Difficulty.equalsIgnoreCase("Medium")) {
            state = new Medium();
            GameDataManager.getInstance().setLevelIndex(2);
        } else {
            state = new Hard();
            GameDataManager.getInstance().setLevelIndex(3);
        }

        GameDataManager.getInstance().setWidth(width);
        GameDataManager.getInstance().setHeight(height);

        control.add(new ImageObject(screenWidth / 3, (int) (screenHeight * 0.8), themes.clown(), themes.clownrev())); // lazm b trteb da
        control.add(new ImageObject(screenWidth / 3 - 10, (int) (screenHeight * 0.8) - 30, themes.getLeftHand(), themes.getLeftHand()));
        control.add(new ImageObject(screenWidth / 3 + 90, (int) (screenHeight * 0.8) - 30, themes.getRightHand(), themes.getRightHand()));

        drawBars();

        subject = new StickSubject();
        playing = new Playing(subject);
        playing.setSpeed(state.getGameSpeed());
        
        //Creat Memento at start of Game
         Orginator.getInstance().Set(0, 60);
         Caretaker.getInstance().addMemento(Orginator.getInstance().createMomento());

    }
    private void drawBars() {
        int bars;
        bars = state.getNoOfBars();

        switch (bars) {
            case 2:
                constant.add(new BarObject(0, 50, (int) (width * 0.4), true, Color.ORANGE));
                constant.add(new BarObject(width - (int) (width * 0.4), 50, (int) (width * 0.5), true, Color.ORANGE));
                break;
            case 3:
                constant.add(new BarObject(0, 50, (int) (width * 0.4), true, Color.ORANGE));
                constant.add(new BarObject(width - (int) (width * 0.4), 50, (int) (width * 0.5), true, Color.ORANGE));
                constant.add(new BarObject(0, 90, (int) (width * 0.2), true, Color.ORANGE));
                break;
            default:
                constant.add(new BarObject(0, 50, (int) (width * 0.4), true, Color.ORANGE));
                constant.add(new BarObject(width - (int) (width * 0.4), 50, (int) (width * 0.5), true, Color.ORANGE));
                constant.add(new BarObject(0, 90, (int) (width * 0.2), true, Color.ORANGE));
                constant.add(new BarObject(width - (int) (width * 0.2), 90, (int) (width * 0.5), true, Color.ORANGE));
                break;
        }
    }    
    public static void setStartTime(long startTime) { //static method to set start time
        Circus.startTime = startTime - time;
    }
   public static void setTime(long time) {
        Circus.time = time;
    }
    @Override
    public boolean refresh() {

        long currentTime = System.currentTimeMillis() - startTime;        
        boolean timeout = currentTime > MAX_TIME; // time end and game over       
        int time = (int) ((MAX_TIME - (System.currentTimeMillis() - startTime)) / 1000);
        
//        System.out.println("START TIME      "+startTime);
//        System.out.println("currentTime     "+System.currentTimeMillis());
//        System.out.println("current - start       "+(System.currentTimeMillis()- startTime));
//        System.out.println("Time    "+time);

        
        if (time % 15 == 0) {
            

            if (time == 15 && count15) {
                Orginator.getInstance().Set(GameDataManager.getInstance().getScore(), (int) time);// orginator has state so we need to change the state
                                                                                                      //we have in our code state is our score
                Caretaker.getInstance().addMemento(Orginator.getInstance().createMomento());// this is arraylist of stack that save our memento
                count15 = false;
            }
            if (time == 30 && count30) {
                Orginator.getInstance().Set(GameDataManager.getInstance().getScore(), (int) time);
                Caretaker.getInstance().addMemento(Orginator.getInstance().createMomento());
                count30 = false;
            }
            if (time == 45 && count45) {
                Orginator.getInstance().Set(GameDataManager.getInstance().getScore(), (int) time);
                Caretaker.getInstance().addMemento(Orginator.getInstance().createMomento());
                count45 = false;
            }
        }

        playing.execute(moving, control, timeout, pileLeft, pileRight); // if timeout = true  -->game over

        if (timeout) {
            Audio.getInstance().stop();
            if (GameDataManager.getInstance().getScore() >= 4) {
                constant.add(new ImageObject(300, 287, "/winner.jpeg", "/winner.jpeg"));
            }
        }
        return !timeout;
    }

    @Override
    public int getSpeed() {
        return 10;
    }

    @Override
    public int getControlSpeed() {
        return 10;
    }

    @Override
    public List<GameObject> getConstantObjects() {
        return constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return moving;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return control;
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
    public String getStatus() {
        return "Score=" + GameDataManager.getInstance().getScore() + "   |   Time=" +Math.max(0, +((MAX_TIME - (System.currentTimeMillis() - startTime)) / 1000))+ "                    Get 4 Points to win";	// update status
    }
    
}

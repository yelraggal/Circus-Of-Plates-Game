package eg.edu.alexu.csd.oop.game.sample.world;

import ThemeStrategy.Themes;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.sample.object.Shape;

public class GameDataManager {

    private static GameDataManager instance;
    private static long lastSpawnTime = System.currentTimeMillis();
    private static int randomSeconds = 1;
    private int score = 0;
    public static int intersectCount = 0;

    private int width;
    private int height;

    private static boolean firstLeftIntersect = true;
    private static boolean firstRightIntersect = true;

    private int color;
    private int levelIndex;

    private Themes themes;

    private GameDataManager() {
    }

    public static GameDataManager getInstance() {

        if (instance == null) {
            instance = new GameDataManager();
        }
        return instance;
    }


    public static void setFirstLeftIntersect(boolean intersect) {
        GameDataManager.firstLeftIntersect = intersect;
    }

    public static boolean isFirstLeftIntersect() {
        return firstLeftIntersect;
    }

    public static void setFirstRightIntersect(boolean intersect) {
        GameDataManager.firstRightIntersect = intersect;
    }

    public static boolean isFirstRightIntersect() {
        return firstRightIntersect;
    }

    public void setMomentoScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore() {
        this.score++;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static int getIntersectCount() {
        return intersectCount;
    }

    public static void setLastSpawnTime() {
        GameDataManager.lastSpawnTime = System.currentTimeMillis();
    }

    public static void setRandomSeconds() {
        GameDataManager.randomSeconds = (int) (Math.floor(Math.random() * 4) + 1);
    }

    public long getLastSpawnTime() {
        return lastSpawnTime;
    }

    public int getRandomSeconds() {
        return randomSeconds;
    }

    public boolean Getintersect(GameObject o1, GameObject o2) {
        return (Math.abs((o1.getX() + o1.getWidth() / 2) - (o2.getX() + o2.getWidth() / 2)) <= o1.getWidth())
                && (Math.abs(o1.getY() + o1.getHeight()) == o2.getY());

        /* l atba2 lma byegi fo2eha tb2 l tb2 byghr2
        return (Math.abs((o1.getX() + o1.getWidth() / 2) - (o2.getX() + o2.getWidth() / 2)) <= o1.getWidth()) 
                && (Math.abs((o1.getY() + o1.getHeight() / 2) - (o2.getY() + o2.getHeight() / 2)) <= o1.getHeight());
    }
         */
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return this.color;
    }

    public void setLevelIndex(int levelIndex) {
        this.levelIndex = levelIndex;
    }

    public Shape getPlayObject() {
        return MovingObject.getInstance().movingObject(levelIndex);
    }
//
//    void setScoreAfterNewgame() {
//        score = 0;
//    }
    public Themes getThemes() {
        return themes;
    }

    public void setThemes(Themes themes) {
        this.themes = themes;
    }

}

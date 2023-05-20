package eg.edu.alexu.csd.oop.game.sample.world;

import Iterator.ArrayIterator;
import Iterator.MyIterator;
import Observer.StickSubject;
import Observer.Observer;
import Strategy.MovingVertical;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.sample.object.Shape;
import java.util.List;

public class Playing {

    private GameDataManager manager; // singelton class has the nessecary data of the game to connect between circus & playing & other classes
    private StickSubject subject; // observer designpattern
    private int speed; // we set this speed from constructor in circus
    private MyIterator iter; // array iter designpattern

    public Playing(StickSubject subject) {
        manager = GameDataManager.getInstance();
        this.subject = subject;
    }

    public void execute(List<GameObject> moving, List<GameObject> control, boolean timeOut, List<Integer> pileLeft, List<Integer> pileRight) {
    
        for (int i = 0; i < moving.size(); i++) { // moving.size --> 3dd lkwr w plates
       
            Shape shape = (Shape) moving.get(i);


            //Timeout? empty list
            checkDirection(shape);// lw horizontal w hy2lb verticall this method check if hy2lb 

            if (checkTimeOut(timeOut)) {
                moving.clear();
                break;
            } else { // Time lesa m5lsh

                shape.getMovingDirection().move(shape); // byhrk shape

                //does it move in X or Y 
                if (!(shape.getMovingDirection().isMovingHorizontal())) {

             
                    //Is it at end of screen? remove from list
                    if (atEndOfScreen(shape, manager.getHeight())) {
                        moving.remove(i);
                        shape.setOnScreen(false);
                        break;
                    }

                    if (isFirstIntersect(i, moving, control, pileLeft, 1)) 
                    {
                        GameDataManager.setFirstLeftIntersect(false);
                        break;
                    } else if (otherIntersect(i, moving, control, pileLeft,1)) 
                    {
                        if (isThreeOrMore(pileLeft)) 
                        {
                            if (areTheySame(control, pileLeft))
                            {
                                if (pileLeft.isEmpty())
                                {
                                    GameDataManager.setFirstLeftIntersect(true);
                                }
                                break;
                            }
                        }
                    }

                    if (isFirstIntersect(i, moving, control, pileRight, 2)) {
                        GameDataManager.setFirstRightIntersect(false);
                        break;
                    } else if (otherIntersect(i, moving, control, pileRight,2)) {
                        if (isThreeOrMore(pileRight)) {
//                                System.out.println("Intersect count" + countIntersect);
                            if (areTheySame(control, pileRight)) {
                                if (pileRight.isEmpty()) {
                                    GameDataManager.setFirstRightIntersect(true);
                                }
                                break;
                            }
                        }
                    }

                }
            }
        }
        
        if(control.get(1).getX()==0)
        {
         control.get(0).setX(10);
         control.get(2).setX(100);
         for (int i=0;i<pileRight.size();i++)
         {
             (control.get(pileRight.get(i))).setX(100);
         }
        }
        
        
        if(control.get(2).getX()>=770)
        {
        control.get(0).setX(680);
        control.get(1).setX(670);
          for (int i=0;i<pileLeft.size();i++)
         {
             (control.get(pileLeft.get(i))).setX(670);
         }
        }

        spawnShape(moving, manager.getWidth());
 
    }

    private void checkDirection(Shape shape) {

        if ((shape.getX() >= (int) (manager.getWidth() * 0.4) // for the upper two bars
                && shape.getX() <= (int) (manager.getWidth() - manager.getWidth() * 0.4 - shape.getWidth()))
                && (shape.getY() <= 50)) {

            shape.setMovingDirection(new MovingVertical());

        } else if ((shape.getX() >= (int) (manager.getWidth() * 0.2) // for the lower bars
                && shape.getX() <= (int) (manager.getWidth() - manager.getWidth() * 0.2 - shape.getWidth()))
                && (shape.getY() > 50)) {
            shape.setMovingDirection(new MovingVertical());
        }

    }

    boolean checkTimeOut(boolean timeOut) {
        return timeOut;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    boolean atEndOfScreen(Shape shape, int height) {
        if (shape.getY() >= manager.getHeight()) {
            return true;
        }
        return false;
    }

    boolean isFirstIntersect(int current, List<GameObject> moving, List<GameObject> control, List<Integer> pile, int pileNumber) {
        if ((manager.Getintersect(moving.get(current), control.get(pileNumber)))
                && (GameDataManager.isFirstRightIntersect() == true || GameDataManager.isFirstLeftIntersect() == true)) {// one hand is empty
            // control.get(1)  htrg3li awl 3sya

            //-15 to raise the bar above subject a bit
            moving.get(current).setY(control.get(pileNumber).getY() - moving.get(current).getHeight());
            moving.get(current).setX(control.get(pileNumber).getX());

            // clown 2stickes  shape  
            //  0      1  2      3
            control.add(moving.get(current));
            pile.add(control.size() - 1);// if first time  --> 3
            
            ((Shape) moving.get(current)).setIsInControl(true);
            
            subject.attach((Observer) moving.get(current));
            subject.notifyObservers();

            moving.remove(moving.get(current));

            return true;
        }
        return false;
    }
// list of pile [3,4] // this number m3naha indecies in control linkedList
    
    // control[clown , 3sya left , 3sya right, plate]  
        //      0    ,   1       ,      2    ,  3 
    ////    // clown w 3syten dol fl imag object    // index in imagobj by2oli ana bmove eh delw2ti 
        
    boolean otherIntersect(int current, List<GameObject> moving, List<GameObject> control, List<Integer> pile,int pileNumber) {
        if (pile.size() >= 1 && 
            manager.Getintersect(moving.get(current), control.get(pile.get(pile.size() - 1)))) {
            if(moving.get(current).getY()<= (control.get(pile.get(pile.size() - 1))).getY())
            {
                
            moving.get(current).setY(control.get(pile.get(pile.size() - 1)).getY() - moving.get(current).getHeight());
            moving.get(current).setX(control.get(pileNumber).getX());
 
            control.add(moving.get(current));
            pile.add(control.size() - 1);

            ((Shape) moving.get(current)).setIsInControl(true);
            
            subject.attach((Observer) moving.get(current));    
            subject.notifyObservers();
            
            moving.remove(moving.get(current));
            return true;
            }
           }
        return false;
    }

    boolean isThreeOrMore(List<Integer> pile) {
        iter = new ArrayIterator(pile);
        int i = 0;
        while (iter.hasNext()) {
            i++;
            iter.next();
        }
        return i>=3;
    }

    boolean areTheySame(List<GameObject> control, List<Integer> pile) {

        Shape checkColors1 = (Shape) control.get(pile.get(pile.size() - 1));
        Shape checkColors2 = (Shape) control.get(pile.get(pile.size() - 2));
        Shape checkColors3 = (Shape) control.get(pile.get(pile.size() - 3));

        if (checkColors1.getColor() == checkColors2.getColor() && checkColors1.getColor() == checkColors3.getColor()) {
            
            subject.deattach((Observer) control.get(pile.get(pile.size() - 1)));
            subject.deattach((Observer) control.get(pile.get(pile.size() - 2)));
            subject.deattach((Observer) control.get(pile.get(pile.size() - 3)));
            subject.notifyObservers();


            control.remove(pile.get(pile.size() - 1));          // da byfdy mkan l object fel shasha .. bs lw   
                                                                        // estghdmto mn gher set visible hyb2a mkano fady bs hwa mrsom
            control.remove(pile.get(pile.size() - 2));
            control.remove(pile.get(pile.size() - 3));

            checkColors1.setVisible(false);  // lw estghdmtha lwhdha hyb2a msh zaher fel shasha
                                                    //  bs mrsom lw ga shape hyeb2a fo2eh
            checkColors2.setVisible(false);
            checkColors3.setVisible(false);

            pile.remove(pile.size() - 1);
            pile.remove(pile.size() - 1);
            pile.remove(pile.size() - 1);
            
            manager.setScore();
            
            return true;
        }
        return false;
    }

    void spawnShape(List<GameObject> moving, int width) {
        
//        System.out.println("Last Spawn Time         "+manager.getLastSpawnTime());
//        System.out.println("RANDOM SECONDS          "+(manager.getRandomSeconds() * this.speed * 100));
//        System.out.println("Current Time          "+System.currentTimeMillis());   
        if (manager.getLastSpawnTime() + (manager.getRandomSeconds() * this.speed * 100) < System.currentTimeMillis()) 
                                                                                          // in first run the randomsecond returns 1
                                                                                          //& lastspawn time is the currentsystemtime
        {                                                        //speed = 10 or 7 or 3   
                                                                 //       easy  medium  hard
            moving.add(manager.getPlayObject());     // create new shape  
            GameDataManager.setRandomSeconds();        // set new random seconds
            GameDataManager.setLastSpawnTime();       //setLast spawnTime with currenttime
        }
        
    }

}

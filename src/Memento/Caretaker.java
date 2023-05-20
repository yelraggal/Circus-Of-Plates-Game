package Memento;

import java.util.ArrayList;

public class Caretaker {
    
    private static Caretaker instance;     
    private ArrayList<Memento> ScoresList = new ArrayList<Memento>();
    private int scoreCount=0;
     
    private Caretaker() {
    }
    public static Caretaker getInstance() {

        if (instance == null) {
            instance = new Caretaker();
        }
        return instance;
    }

    public void addMemento(Memento score)
    {
        ScoresList.add(score);
        scoreCount++;
    }
    
    public Memento getLastMemento()
    {
        return ScoresList.get(ScoresList.size()-1);
    }
    
   
}

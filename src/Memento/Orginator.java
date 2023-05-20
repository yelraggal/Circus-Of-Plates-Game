package Memento;


public class Orginator {

    private static Orginator instance;
    private int[] Score = new int[2];

    private Orginator() {
    }
    public static Orginator getInstance() {

        if (instance == null) {
            instance = new Orginator();
        }
        return instance;
    }
    

    public void Set(int score , int Time) {
         Score[0]=score;
         Score[1]=Time;
    }
    
    public Memento createMomento()
    {
        return new Memento(Score[0],Score[1]);
    }
   
    public int[] RestoreLastMemento(Memento memento)
    {
        int[] score =memento.getScore();
        return score;
    }
    
}

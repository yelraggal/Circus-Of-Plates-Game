package Memento;

public class Memento {

    private int info[] = new int[2];
    public Memento(int scores , int currentTime) {
        info[0] = scores;
        info[1]=currentTime;
    }
    
    public int[] getScore()
    {
        return info;
    }

}

package Observer;

import java.util.ArrayList;
import java.util.List;

public class StickSubject implements Subject {

    private List<Observer> observers = new ArrayList<Observer>();
    private int size;
    public StickSubject() 
    {    
        size=0;
    }
    
    @Override
    public void attach(Observer observer) { 
        observers.add(observer);
        System.out.println("observer plate added");
        size++;
        System.out.println("SIZE OF ARRAY: "+size);
    }
    
    @Override                                  
    public void deattach(Observer observer) { // lw 3 atba2 nfs lon hy5fyhom 
        observers.remove(observer);
        System.out.println("observer plate removed");
        size--;
    }

    @Override
    public void notifyObservers() {

        for (int i = 0; i < observers.size(); i++) {   
            observers.get(i).update(); // every shape has this method we can use it // but in this code there is no thing to do 
                                           // with this method but we used the concept of observer design pattern
           // deattach(observers.get(lastElement)); 
        }
    }

}

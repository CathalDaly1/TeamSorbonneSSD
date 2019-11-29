package Auctions;

import Users.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o){
        observers.add(o);
    }

    public void removeObserver(Observer o){
        observers.remove(o);
    }

    protected void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

}

package com.patterns.observer_listener;

import java.util.ArrayList;
import java.util.List;


public class Subject {

    private int state;
    List<Observer> observers = new ArrayList<>();

    public void attachObserver(Observer observer) {
        observers.add(observer);
    }

    public void setState(int state) {
        this.state = state;
        System.out.println("Original state in DECIMIAL system " + state);
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }

}

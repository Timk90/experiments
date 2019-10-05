package com.patterns.observer_listener;

public class FirstObserver implements Observer {

    Subject subject;

    @Override
    public void update(Object state) {
        System.out.println("First observer BINARY output " + Integer.toBinaryString((int) state));
    }

    public FirstObserver(Subject subject) {
        this.subject = subject;
        this.subject.attachObserver(this);
    }
}

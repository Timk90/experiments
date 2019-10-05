package com.patterns.observer_listener;

public class SecondObserver implements Observer {

    Subject subject;

    @Override
    public void update(Object state) {
        System.out.println("First observer OCTAL output " + Integer.toOctalString((int) state));
    }

    public SecondObserver(Subject subject) {
        this.subject = subject;
        this.subject.attachObserver(this);
    }
}

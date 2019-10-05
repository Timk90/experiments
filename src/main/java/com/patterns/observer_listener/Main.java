package com.patterns.observer_listener;

public class Main {
    public static void main(String[] args) {

        Subject subject = new Subject();

        new FirstObserver(subject);
        new SecondObserver(subject);

        System.out.println("First state");
        subject.setState(123);

        System.out.println("Second state");
        subject.setState(25);

    }
}

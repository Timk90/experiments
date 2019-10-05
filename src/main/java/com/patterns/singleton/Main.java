package com.patterns.singleton;

public class Main {
    public static void main(String[] args) {
        Thread firstThread = new Thread(new FirstSingletonThread());
        Thread secondThread = new Thread(new SecondSingletonThread());
        Thread thirdThread = new Thread(new ThirdSingletonThread());


        firstThread.start();
        secondThread.start();
        thirdThread.start();

    }

    static class FirstSingletonThread implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("Some text");
            System.out.println(singleton.getValue());
        }
    }

    static class SecondSingletonThread implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("Another text");
            System.out.println(singleton.getValue());
        }
    }

    static class ThirdSingletonThread implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("Another some text");
            System.out.println(singleton.getValue());
        }
    }
}

package com.patterns.strategy;

public interface PaymentStrategy {

    boolean authenticate();

    void pay(int total);

}

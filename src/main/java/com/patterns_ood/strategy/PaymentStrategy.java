package com.patterns_ood.strategy;

public interface PaymentStrategy {

    boolean authenticate();

    void pay(int total);

}

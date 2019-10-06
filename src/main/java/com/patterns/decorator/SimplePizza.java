package com.patterns.decorator;

public class SimplePizza implements Pizza {
    @Override
    public Double getCost() {
        return 4.5;
    }

    @Override
    public String getIngridients() {
        return "Pizza";
    }
}

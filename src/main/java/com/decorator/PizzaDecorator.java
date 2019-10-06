package com.decorator;

public abstract class PizzaDecorator implements Pizza {

    private Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public Double getCost() {
        return pizza.getCost();
    }

    @Override
    public String getIngridients() {
        return pizza.getIngridients();
    }
}

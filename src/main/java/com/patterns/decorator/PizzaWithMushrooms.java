package com.patterns.decorator;

public class PizzaWithMushrooms extends PizzaDecorator {

    private Pizza pizza;

    public PizzaWithMushrooms(Pizza pizza) {
        super(pizza);
    }

    @Override
    public Double getCost() {
        return super.getCost() + 2.3;
    }

    @Override
    public String getIngridients() {
        return super.getIngridients() + " + mushrooms";
    }
}

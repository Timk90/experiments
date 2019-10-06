package com.patterns.decorator;

public class PizzaWithSausages extends PizzaDecorator {

    private Pizza pizza;

    public PizzaWithSausages(Pizza pizza) {
        super(pizza);
    }

    @Override
    public Double getCost() {
        return super.getCost() + 3.0;
    }

    @Override
    public String getIngridients() {
        return super.getIngridients() + " + sausages";
    }
}

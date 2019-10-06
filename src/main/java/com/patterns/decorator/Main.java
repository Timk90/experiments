package com.patterns.decorator;

public class Main {
    public static void main(String[] args) {

        SimplePizza simplePizza = new SimplePizza();
        System.out.printf("%s, price %.2f%n", simplePizza.getIngridients(), simplePizza.getCost());

        Pizza pizzaWithMushrooms = new PizzaWithMushrooms(new SimplePizza());
        System.out.printf("%s, price %.2f%n", pizzaWithMushrooms.getIngridients(), pizzaWithMushrooms.getCost());

        Pizza pizzaWithSausages = new PizzaWithSausages(new SimplePizza());
        System.out.printf("%s, price %.2f%n", pizzaWithSausages.getIngridients(), pizzaWithSausages.getCost());

        Pizza allIngredients = new PizzaWithMushrooms(new PizzaWithSausages(new SimplePizza()));
        System.out.printf("%s, price %.2f%n", allIngredients.getIngridients(), allIngredients.getCost());
    }
}

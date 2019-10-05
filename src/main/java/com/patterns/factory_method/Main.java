package com.patterns.factory_method;

public class Main {
    public static void main(String[] args) {
        //Product glass = ProductFactory.makeProduct(ProductTypes.GLASS);
        //Product dish = ProductFactory.makeProduct(ProductTypes.DISH);

        //glass.getProduct();
        //dish.getProduct();

        System.out.println("=======Random Creator=======");
        for (int i = 0; i < 100; i++) {
            Product product = ProductFactory.getRandomProduct();
            product.getProduct();
        }
        System.out.println("=======Number of Products=======");
        ProductFactory.getCounters();

    }
}

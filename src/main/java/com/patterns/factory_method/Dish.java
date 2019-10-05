package com.patterns.factory_method;

public class Dish extends Product {


    @Override
    public void getProduct() {
        System.out.println("I am a dish extending product");
    }
}

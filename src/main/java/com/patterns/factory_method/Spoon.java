package com.patterns.factory_method;

public class Spoon extends Product {

    @Override
    public void getProduct() {
        System.out.println("I am a spoon extending Product");
    }
}

package com.patterns.factory_method;

public class Glass extends Product {

    @Override
    public void getProduct() {
        System.out.println("I am a Glass extending Product");
    }
}

package com.patterns_ood.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class QIWIPayment implements PaymentStrategy {


    boolean signedIn = false;
    String phone = null;
    String password = null;


    private final Map<String, String> DATABASE = new HashMap<>();

    {
        DATABASE.put("+79503111111", "testpass");
    }


    @Override
    public boolean authenticate() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DATABASE.put("+79503111111", "testpass");

        try {
            System.out.println("Enter phone number:");
            phone = reader.readLine();
            System.out.println("Enter password:");
            password = reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (DATABASE.get(phone) != null && DATABASE.get(phone).equals(password)) {
            signedIn = true;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void pay(int total) {

        if (authenticate()) {
            System.out.println("Payment with QIWI total price of " + total + " $");
            signedIn = false;
        } else {
            System.out.println("Payment failed. Incorrect QIWI credentials.");
            signedIn = false;
        }
    }
}

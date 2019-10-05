package com.patterns.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PayPalPayment implements PaymentStrategy {

    boolean signedIn = false;
    String mail = null;
    String password = null;


    private final Map<String, String> DATABASE = new HashMap<>();

    {
        DATABASE.put("testpass", "test@mail.ru");
    }

    @Override
    public boolean authenticate() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DATABASE.put("test@mail.ru", "testpass");

        try {
            System.out.println("Enter e-mail address:");
            mail = reader.readLine();
            System.out.println("Enter password:");
            password = reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (DATABASE.get(mail) != null && DATABASE.get(mail).equals(password)) {
            signedIn = true;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void pay(int total) {
        if (authenticate()) {
            System.out.println("Payment with PayPal a total price of " + total + " $");
            signedIn = false;
        } else {
            System.out.println("Payment failed. Incorrect credentials.");
            signedIn = false;
        }

    }
}

package com.patterns.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Order {

    private static PaymentStrategy paymentStrategy;

    static int total = 0;

    private static Map<String, String> items = new HashMap<>();

    {
        items.put("1", "100");
        items.put("2", "300");
        items.put("3", "500");
    }

    public static void main(String[] args) {
        boolean finishOrder = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            do {
                items.put("1", "100");
                items.put("2", "300");
                items.put("3", "500");

                System.out.println("Choose item number\n" + items);
                String item = reader.readLine();
                System.out.println("How many");
                int amount = Integer.parseInt(reader.readLine());

                if (items.containsKey(item)) {
                    total += amount * Integer.parseInt(items.get(item));
                } else {
                    System.out.println("Incorrect item number...");
                }
                System.out.println("Press Y/N to finish");
                String finish = reader.readLine();
                if (finish.equals("Y")) {
                    finishOrder = true;
                }
            } while (!finishOrder);

            System.out.println("Put 1 to pay with PayPal or 2 to pay with QIWI");
            String strategy = reader.readLine();
            if (strategy.equals("1")) {
                paymentStrategy = new PayPalPayment();
            } else if (strategy.equals("2")) {
                paymentStrategy = new QIWIPayment();
            } else {
                System.out.println("Incorrect payment type");
                System.exit(0);
            }
            paymentStrategy.pay(total);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

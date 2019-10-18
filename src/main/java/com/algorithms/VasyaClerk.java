package com.algorithms;

import java.util.HashMap;
import java.util.Map;

public class VasyaClerk {

    enum Answer {
        YES, NO
    }

    public static String Tickets(int[] peopleInLine) {

        //Your code is here...
        Map<Integer, Integer> billTypes = new HashMap<>();
        billTypes.put(25, 0);
        billTypes.put(100, 0);
        billTypes.put(50, 0);

        for (Integer current : peopleInLine) {
            int tickets = current / 25;
            if (tickets == 1) {
                int value25 = billTypes.get(25);
                billTypes.put(25, ++value25);
            } else if (tickets == 2) {
                int value25 = billTypes.get(25);
                int value50 = billTypes.get(50);
                if (value25 > 0) {
                    billTypes.put(25, --value25);
                    billTypes.put(50, ++value50);
                } else {
                    return Answer.NO.toString();
                }
            } else if (tickets == 4) {
                int value25 = billTypes.get(25);
                int value50 = billTypes.get(50);
                int value100 = billTypes.get(100);
                if (value50 > 0 && value25 > 0) {
                    billTypes.put(100, ++value100);
                    billTypes.put(50, --value50);
                    billTypes.put(25, --value25);
                } else if (value25 > 2) {
                    billTypes.put(25, value25 - 3);
                    billTypes.put(100, ++value100);
                } else {
                    return Answer.NO.toString();
                }

            }
        }
        return Answer.YES.toString();
    }

    public static void main(String[] args) {
        System.out.println(Tickets(new int[]{25, 50, 100}));
        System.out.println(Tickets(new int[]{25, 25, 50, 25, 100}));
        System.out.println(Tickets(new int[]{50, 25, 100}));
        System.out.println(Tickets(new int[]{25, 50, 25, 100}));
        System.out.println(Tickets(new int[]{25, 25, 25, 100}));
        System.out.println(Tickets(new int[]{25, 100, 50}));
    }
}

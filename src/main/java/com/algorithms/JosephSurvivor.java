package com.algorithms;

import java.util.ArrayList;
import java.util.List;

public class JosephSurvivor {


    public static int josephusSurvivor(final int n, final int k) {
        List<Integer> initiallist = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            initiallist.add(i);
        }

        int currentElement = k - 1;
        while (initiallist.size() != 1) {
            if (k > initiallist.size() || currentElement >= initiallist.size()) {
                currentElement = (currentElement) % initiallist.size();
                initiallist.remove(currentElement);
                currentElement += k - 1;
            } else {
                initiallist.remove(currentElement);
                currentElement += k - 1;
            }
        }
        return initiallist.get(0);
    }

    public static void main(String[] args) {
        System.out.println(josephusSurvivor(7, 3));
    }
}

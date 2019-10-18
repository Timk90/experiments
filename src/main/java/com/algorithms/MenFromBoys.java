package com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MenFromBoys {

    public static int[] menFromBoys(final int[] values) {
        // Your Code is Here .. Enjoy !! , Don't Forget To Vote :wink: :wink
        Set<Integer> initialSet = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        list = Arrays.stream(values).boxed().collect(Collectors.toList());
        initialSet.addAll(list);

        List<Integer> boys = new ArrayList<>();
        List<Integer> men = new ArrayList<>();

        for (Integer number : initialSet) {
            if (number != 0) {
                if (number % 2 == 0) {
                    men.add(number);
                } else {
                    boys.add(number);
                }
            } else {
                men.add(number);
            }
        }
        Collections.sort(men, (a, b) -> a - b);
        Collections.sort(boys, (a, b) -> b - a);
        men.addAll(boys);
        System.out.println(men);

        int[] all = new int[men.size()];
        for (int i = 0; i < men.size(); i++) {
            all[i] = men.get(i);
        }
        System.out.println(men);
        return all;
    }


    public static void main(String[] args) {
        int[] array = {-94, -99, -100, -99, -96, -99};
        menFromBoys(array);
    }

}

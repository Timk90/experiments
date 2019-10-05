package com.core.streams_basics;

import com.core.lambda_exp.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsMain {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("First string...");
        list.add("Second");
        list.add("Third");
        list.add("Third");
        list.add("Third");
        list.add("Six");
        list.add("Seven");
        list.add("Third");
        list.add("Five");
        list.add(null);


        /**
         * filter - пример промежуточной функции
         * count - пример терминальной функции
         */
        //counting number of "Third" fields
        long count = list.stream().filter((p) -> p != null && p.equals("Third")).count();

        //max value found in the list
        String max = list.stream().filter((p1) -> p1 != null).max((p1, p2) -> p1.compareTo(p2)).get();

        System.out.println(max);
        System.out.println(count);

        System.out.println("============");
        list.stream().filter(value -> value != null && !value.equals("Third")).forEach(System.out::println);

        System.out.println("=======Streams=======");
        IntStream.of(1, 2, 3).forEach(System.out::println);

        DoubleStream.of(2.0, 3.3, 5.0).forEach(System.out::println);

        String[] arr = {"First", "Second", "Third"};
        Stream<String> stream = Arrays.stream(arr);
        stream.filter(val -> !val.equals("First")).forEach(System.out::println);

        Stream<String> stringStream = Stream.of("1", "2", "3");
        Consumer<Long> consumer1 = System.out::println;
        consumer1.accept(stringStream.count());

        Stream<User> userStream = Stream.of(new User("Tim", "Brown"), new User("Tom", "Reddl"));
        userStream.map(User::getName).forEach(System.out::println);

        Function<Double, String> function = (val) -> "double value is : " + val.toString();
        System.out.println(function.apply(123.0));

    }
}

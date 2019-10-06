package com.core.streams_basics;

import com.core.lambda_exp.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
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
         *
         * Streams use functional interfaces:
         * Predicate - boolean test(T t, R r);
         * Consumer - void accept(T t);
         * Function - R apply(T t);
         * BinaryOperator - T foo(T t1, T t2);
         *
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

        Stream<String> stream1 = Stream.of("1", "2", "3");
        stream1.reduce((a, b) -> a.compareTo(b) > 0 ? a : b);

        /**
         * Functional interface function
         * Function<T, R> - method R apply(T t)
         * translate T to R
         */
        Function<Double, String> function = (val) -> "double value is : " + val.toString();
        System.out.println(function.apply(123.0));

        /**
         * Stream to Collection translation
         */
        Stream<Integer> integerStream = Stream.of(1, 2, 2, 2, 3, 3, 4, 4, 5, 6, 7, 8, 9);
        integerStream.collect(Collectors.toList()).forEach(System.out::print);
        System.out.println();

        Stream<Integer> integerStream1 = Stream.of(1, 2, 2, 2, 3, 3, 4, 4, 5, 6, 7, 8, 9);
        integerStream1.collect(Collectors.toCollection(TreeSet::new)).forEach(System.out::print);
        System.out.println();

        Stream<Integer> integerStream2 = Stream.of(1, 2, 2, 2, 3, 3, 4, 4, 5, 6, 7, 8, 9);
        integerStream2.collect(ArrayList::new, ArrayList::add, ArrayList::addAll).forEach(System.out::print);
        System.out.println();

        Stream<Item> itemStream = Stream.of(new Item(1, "First"), new Item(2, "Second"));
        itemStream.collect(Collectors.toMap((item) -> item.getPrice(), (item) -> item.getName())).forEach((key, value) -> System.out.println("Key: " + key + ", valuer: " + value));

    }
}

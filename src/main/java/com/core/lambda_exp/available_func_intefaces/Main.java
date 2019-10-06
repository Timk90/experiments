package com.core.lambda_exp.available_func_intefaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {

        /**
         * Consumer
         * этот интерфейс принимает какое-то значение и ничего не возвращает
         */
        Consumer<String> consumer1 = (String str) -> System.out.println(str);
        //аналогичный метод предыдущему. Здесь в качестве реализации метода
        //мы передаем статический метод println(Object obj) класса PrintStream
        Consumer<String> consumer2 = System.out::println;
        consumer1.accept("Hello Consumer");

        /**
         * Predicate
         * интерфейс проверяет условие методом test и возвращает true/false
         * входной аргумент один
         */
        Predicate<Integer> predicate = (Integer int1) -> int1 > 50 ? true : false;
        System.out.println(predicate.test(50));//false
        System.out.println(predicate.test(51));//true

        /**
         * Supplier
         * интерфейс на выходе дает какой-то результат ничего не принимая
         */
        Supplier<String> supplier = () -> new String("Hello Supplier");
        System.out.println(supplier.get());

        /**
         * UnaryOperator
         * интерфейс производит действие над входным параметрои и возвращает его
         */
        UnaryOperator<Double> unaryOperator = (Double value) -> Math.sqrt(value);
        System.out.printf("Sqrt value of 43 is %.2f%n", unaryOperator.apply(43.0));
        System.out.printf("Sqrt value of 21 is %.2f%n", unaryOperator.apply(21.0));

        /**
         * Function
         * интерфейс переводит объект одного типа в объект другого типа
         */
        Function<List<Integer>, String> function = (List<Integer> list) -> {
            String str = "";
            int sum = 0;
            for (Integer int1 : list) {
                sum += int1;
            }

            return str = "Total sum over all elements: " + sum;
        };
        System.out.println(function.apply(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8))));

        /**
         * BinaryOperator
         * интерфейс производит действие над двумя однотипными параметрами и возвращает параметр того же типа
         */
        BinaryOperator<String> binaryOperator = (String str1, String str2) -> str1 + str2 + ": concatenation result";
        System.out.println(binaryOperator.apply("Hello, cruel ", "World!"));
    }
}

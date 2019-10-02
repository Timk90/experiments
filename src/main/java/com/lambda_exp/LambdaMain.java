package com.lambda_exp;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class LambdaMain {

    public static void main(String[] args) {
        System.out.println(getOperation('/').getResult(2.0, 3.0));

        //system.out - объект класса PrintStream
        //в нем мы вызываем СТАТИЧЕСКИЙ метод println(Object obj) через System.out::println
        //далее мыдоставляем ссылку на этот метод в качестве реализации метода accept(T t) в функц интерфейс consumer
        Consumer consumer = System.out::println;
        consumer.accept("Hello world!");

        Consumer<String> printName = LambdaMain::printName;
        printName.accept("Timur");

        Consumer<Map> mapConsumer = Map::clear;

        Map<String, String> map = new HashMap<>();
        map.put("1", "First");
        map.put("2", "Second");
        System.out.println(map);

        mapConsumer.accept(map);
        System.out.println(map);

        UserCreator userCreator = User::new;

        User user = userCreator.create("Patrik", "Black");

        System.out.println(user.getName() + " " + user.getSurename());


    }

    static void printName(String str) {
        System.out.println("My name is " + str);
    }

    public static Operation getOperation(char symbol) {
        switch (symbol) {
            case '/':
                return (value1, value2) -> value1 / value2;
            case '*':
                return (value1, value2) -> value1 * value2;
            case '+':
                return (value1, value2) -> value1 + value2;
            case '-':
                return (value1, value2) -> value1 - value2;
            default:
                return (var1, var2) -> 0.0;
        }
    }
}

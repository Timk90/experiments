package com.patterns.singleton;

public class Singleton {

    private static volatile Singleton instance;

    private String value;

    public static Singleton getInstance(String context) {

        /**
         * synchronized(ClassName.class) - синхронизация произойдет только однажды,
         * во время инициализации объекта
         * зачем нужен double-check locking?
         * Она приводит к уменьшению потребления
         * ресурсов при многопоточном варианте
         * Блокировка на уровне класса, а не объетка! Должна всегда выполняться
         * для статических данных класса.
         */
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(context);
                }
            }
        }
        return instance;
    }

    public String getValue() {
        return value;
    }

    private Singleton(String value) {
        this.value = value;
    }
}

package com.patterns.factory_method;

import java.util.Random;

/**
 * Фабрика по созданию посуды.
 * Можно создать даже случайную тарелку или ложку
 */
public class ProductFactory {

    static int dishCounter = 0;
    static int glassCounter = 0;
    static int spoonCounter = 0;

    private ProductFactory() {
    }

    public static Product makeProduct(ProductTypes type) {
        switch (type) {
            case DISH:
                dishCounter++;
                return new Dish();
            case GLASS:
                glassCounter++;
                return new Glass();
            case SPOON:
                spoonCounter++;
                return new Spoon();
            default:
                System.out.println("Unknown product type");
                throw new IllegalArgumentException();
        }
    }

    /**
     * Создает случайный элемент посуды
     *
     * @return экземпляр наследник класса Product
     */
    public static Product getRandomProduct() {
        Random random = new Random();
        ProductTypes type = ProductTypes.values()[random.nextInt(ProductTypes.values().length)];
        return makeProduct(type);
    }

    /**
     * Считает всю посуду, что насоздавал.
     */
    public static void getCounters() {
        System.out.println("Number 0f created dishes: " + dishCounter);
        System.out.println("Number 0f created glasses: " + glassCounter);
        System.out.println("Number 0f created spoons: " + spoonCounter);
    }

}

package org.example;

import java.util.HashMap;

public class Basket {
    /*
     * Нарушен принцип единственной ответственности. Класс Purchase делал 2 вещи одновременно -
     * был чертежем и покупки, и коризины в которой покупки находились
     * Логика корзины была вынесена в отельный класс.
     * */
    private HashMap<String, Integer> prices;
    private Purchase[] items;

    /*
     * Инициализация массива покупок была сделана с сипользованием строго определенного в коде числа.
     * Нарушен принцип волшебных чисел.
     * Инициализация массива теперь зависит от длины HashMap
     * */

    public Basket(HashMap<String, Integer> products) {
        this.prices = products;
        this.items = new Purchase[products.size()];
    }

    public void addPurchase(String title, int count) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = new Purchase(title, count);
                return;
            }
            if (items[i].title.equals(title)) {
                items[i].count += count;
                return;
            }
        }
    }

    /*
     * Убрали параметр из сигнатуры метода sum() за ненадобностью
     * */
    public long sum() {
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (int i = 0; i < items.length; i++) {
            Purchase purchase = items[i];
            if (purchase == null) {             //Поправили оформление
                continue;
            }
            System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " + (purchase.count * prices.get(purchase.title)) + " руб.");
            sum += purchase.count * prices.get(purchase.title);
        }
        return sum;
    }
}

package org.example;

public class Purchase {

    /*
     * Нарушен принцип единственной ответственности. Класс Purchase делал 2 вещи одновременно -
     * был чертежем и покупки, и коризины в которой покупки находились
     * Логика корзины была вынесена в отельный класс.
     * */
    protected String title;
    protected int count;

    public Purchase(String title, int count) {
        this.title = title;
        this.count = count;
    }

}

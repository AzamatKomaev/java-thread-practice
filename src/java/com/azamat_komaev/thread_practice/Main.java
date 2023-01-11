package com.azamat_komaev.thread_practice;

public class Main {
    public static void main(String[] args) {
        Foo obj = new Foo();

        Runnable printFirst = () -> System.out.print("first");
        Runnable printSecond = () -> System.out.print("second");
        Runnable printThird = () -> System.out.print("third");

        try {
            obj.first(printFirst);
            obj.second(printSecond);
            obj.third(printThird);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

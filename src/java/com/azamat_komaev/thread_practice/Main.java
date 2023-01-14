package com.azamat_komaev.thread_practice;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Foo obj = new Foo();

        Runnable printFirst = () -> System.out.print("first");
        Runnable printSecond = () -> System.out.print("second");
        Runnable printThird = () -> System.out.print("third");

        CompletableFuture.runAsync(() -> {
            obj.first(printFirst);
        });
        CompletableFuture.runAsync(() -> {
            obj.second(printSecond);
        });
        CompletableFuture.runAsync(() -> {
            obj.third(printThird);
        });

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

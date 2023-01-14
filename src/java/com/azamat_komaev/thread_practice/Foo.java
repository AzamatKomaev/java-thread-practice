package com.azamat_komaev.thread_practice;

import java.util.concurrent.CountDownLatch;

public class Foo {
    private final CountDownLatch latchFirst = new CountDownLatch(1);
    private final CountDownLatch latchSecond = new CountDownLatch(1);

    public void first(Runnable r) {
        r.run();
        latchFirst.countDown();
    }

    public void second(Runnable r) {
        try {
            latchFirst.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r.run();
        latchSecond.countDown();
    }

    public void third(Runnable r) {
        try {
            latchSecond.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r.run();
    }
}

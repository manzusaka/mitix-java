package com.mitix.len.jdk8base.concurrent.book1.exp4;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    static AtomicInteger i = new AtomicInteger();

    public static class AddThread implements Runnable {

        @Override
        public void run() {
            for (int k = 0; k < 100000; k++) {
                i.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) {
        Thread[] t = new Thread[10];
        for (int k = 0; k < 10; k++) {
            t[k] = new Thread(new AddThread());
        }
        for (int i = 0; i < 10; i++) {
            t[i].start();

        }
        for (int i = 0; i < 10; i++) {
            try {
                t[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(i);
    }
}

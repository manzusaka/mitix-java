package com.mitix.len.jdk8base.concurrent.book1.wjob.job2;

import java.util.UUID;

public class WaitNotifyQueueTest {
    public static void main(String[] args) {
        WaitNotifyQueue waitNotifyQueue = new WaitNotifyQueue();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    waitNotifyQueue.add(UUID.randomUUID().toString());
                    try {
                        Thread.sleep(Math.round(new Double("1000")));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    waitNotifyQueue.get();
                    try {
                        Thread.sleep(Math.round(new Double("1000")));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}

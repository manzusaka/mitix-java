package com.mitix.len.jdk8base.concurrent.book1.exp1;

import org.junit.Test;

public class ThreadCreateTest {
//线程的新建

    /**
     * Thread 在调用run方法时没有启动新的线程
     * <p>
     * 区别  start调用了本地的start()方法
     * run方法直接调用了target的run()方法
     */
    @Test
    public void operationThread() {
        System.out.println("main is current " + Thread.currentThread().getId());
        operationThread1();
        operationThread2();
    }


    public void operationThread1() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1 is current " + Thread.currentThread().getId());
            }
        });
        thread.start();
    }

    public void operationThread2() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2 is current " + Thread.currentThread().getId());
            }
        });
        thread.run();
    }
}

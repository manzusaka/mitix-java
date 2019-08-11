package com.mitix.len.jdk8base.concurrent.book1.exp1;

import org.junit.Test;

public class ThreadInterruptedTest {
//线程的中断
//  public void Thread.interrupt()  // 中断线程
//  public boolean Thread.isInterrupted() // 判断是否被中断
//  public static boolean Thread.interrupted()  // 判断是否被中断，并清除当前中断状态

    /**
     * Thread 在调用run方法时没有启动新的线程
     * <p>
     * 区别  start调用了本地的start()方法
     * run方法直接调用了target的run()方法
     */
    @Test
    public void operationThread() throws InterruptedException {
        System.out.println("main is current " + Thread.currentThread().getId());
        operationThread1();
        operationThread2();
    }


    public void operationThread1() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1 is current " + Thread.currentThread().getId());
                while (true) {
                    Thread.yield();
                }

            }
        });
        thread.start();
        thread.interrupt();
    }

    public void operationThread2() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2 is current " + Thread.currentThread().getId());
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("T2 is Interruted!");
                        break;
                    }
                    Thread.yield();
                }
            }
        });
        thread.start();
        Thread.sleep(10000);
        thread.interrupt();
    }
}

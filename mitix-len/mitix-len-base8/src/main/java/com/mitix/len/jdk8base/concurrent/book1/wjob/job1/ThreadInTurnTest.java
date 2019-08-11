package com.mitix.len.jdk8base.concurrent.book1.wjob.job1;

import org.junit.Test;

/**
 * 1.现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行
 */
public class ThreadInTurnTest {

    public class Thread1 implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this is thread 1");
        }
    }

    public class Thread2 implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this is thread 2");
        }
    }

    public class Thread3 implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this is thread 3");
        }
    }


    @Test
    public void inTurnTest() throws InterruptedException {
        Thread t1 = new Thread(new Thread1());
        Thread t2 = new Thread(new Thread2());
        Thread t3 = new Thread(new Thread3());
        t1.start();
        //等待
        t1.join();
        t2.start();
        //等待
        t2.join();
        t3.start();
        //等待
        t3.join();
        Thread.sleep(5000);
    }
}

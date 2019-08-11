package com.mitix.len.jdk8base.concurrent.book2.exp1;

/**
 * @author oldflame-jm
 * @create 2018/5/6
 * 典型的死锁的场景
 */
public class DeadLockDemo {
    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {

        new DeadLockDemo().deadLock();
    }

    private void deadLock() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("1");
                    }

                }

            }

        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("2");
                    }

                }
            }

        });

        t1.start();
        t2.start();

    }
}

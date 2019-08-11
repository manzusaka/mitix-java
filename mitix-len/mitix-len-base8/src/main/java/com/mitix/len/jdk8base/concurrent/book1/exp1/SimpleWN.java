package com.mitix.len.jdk8base.concurrent.book1.exp1;

public class SimpleWN {
    final static SimpleWN simplewm = new SimpleWN();

    public static class T1 extends Thread {
        @Override
        public void run() {
            synchronized (simplewm) {
                System.out.println(System.currentTimeMillis() + ": t1 start");

                try {
                    System.out.println(System.currentTimeMillis() + ": t1 wait for object");
                    //wait本线程休眠   然后对象锁进行处理  等待通知notify
                    simplewm.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ": t1 end");
            }
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (simplewm) {
                System.out.println(System.currentTimeMillis() + ": t2 start! notify one thread");
                //唤醒对象上休眠的一个线程
                simplewm.notify();
                //唤醒对象上休眠的所有线程
                //simplewm.notifyAll();
                System.out.println(System.currentTimeMillis() + ": t2 end");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }
}

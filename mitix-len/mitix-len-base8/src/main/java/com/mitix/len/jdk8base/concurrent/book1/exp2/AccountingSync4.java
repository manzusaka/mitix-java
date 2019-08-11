package com.mitix.len.jdk8base.concurrent.book1.exp2;

public class AccountingSync4 implements Runnable {
    static int i = 0;

    //这里static synchronized  拥有一把类的同步锁
    private static synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000000l; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //这两个锁是不在同一个对象上的
        Thread thread1 = new Thread(new AccountingSync4());
        Thread thread2 = new Thread(new AccountingSync4());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("this is count i  " + i);
    }

}

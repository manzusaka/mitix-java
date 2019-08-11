package com.mitix.len.jdk8base.concurrent.book1.exp2;

public class AccountingSync implements Runnable {
    static AccountingSync instance = new AccountingSync();
    static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10000000l; j++) {
            synchronized (instance) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("this is count i  " + i);
    }
}

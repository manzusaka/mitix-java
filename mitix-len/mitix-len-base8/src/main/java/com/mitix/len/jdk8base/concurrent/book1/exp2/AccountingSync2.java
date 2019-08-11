package com.mitix.len.jdk8base.concurrent.book1.exp2;

public class AccountingSync2 implements Runnable {

    static AccountingSync2 instance = new AccountingSync2();
    static int i = 0;


    //这个是把同步锁创建到对象上,其实锁是在对象的实例上
    private synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000000l; j++) {
            increase();
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

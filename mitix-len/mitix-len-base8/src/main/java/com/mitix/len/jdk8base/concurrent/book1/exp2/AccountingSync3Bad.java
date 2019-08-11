package com.mitix.len.jdk8base.concurrent.book1.exp2;

public class AccountingSync3Bad implements Runnable {

    static AccountingSync3Bad instance = new AccountingSync3Bad();
    static int i = 0;


    //这个是把同步锁创建到对象上，这个是一个坏的错误的实现
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
        //这两个锁是不在同一个对象上的
        Thread thread1 = new Thread(new AccountingSync3Bad());
        Thread thread2 = new Thread(new AccountingSync3Bad());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("this is count i  " + i);
    }
}

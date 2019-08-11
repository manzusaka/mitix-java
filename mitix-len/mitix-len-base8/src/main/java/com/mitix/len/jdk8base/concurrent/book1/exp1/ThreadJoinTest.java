package com.mitix.len.jdk8base.concurrent.book1.exp1;

public class ThreadJoinTest {


    public volatile static int i = 0;

    public static class AddThread extends Thread {
        @Override
        public void run() {
            for (i = 0; i < 10000000; i++) ;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread at = new AddThread();
        at.start();
        //主线程等待at线程执行完
        at.join();
        System.out.println(i);
    }


}

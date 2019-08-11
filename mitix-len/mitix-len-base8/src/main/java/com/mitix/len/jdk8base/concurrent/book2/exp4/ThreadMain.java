package com.mitix.len.jdk8base.concurrent.book2.exp4;

/**
 * @author oldflame-jm
 * @create 2018/5/23
 * ${DESCRIPTION}
 */
public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        NleepThread nleepThread = new NleepThread();
        nleepThread.start();
//        for (int i = 0; i < 10; i++) {
//            nleepThread.notify();
//            System.out.println("释放一次-----");
//            TimeUnit.MILLISECONDS.sleep(2000);
//        }
    }
}

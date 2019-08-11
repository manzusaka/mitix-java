package com.mitix.len.multithread4oood.jthread;

/**
 * @author oldflame-jm
 * @create 2018/3/5
 * ${DESCRIPTION}
 */
public class ThreadSleepTest extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("this is Nice ! " + i);
            try {
                //线程的暂停
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadSleepTest threadSleepTest = new ThreadSleepTest();
        threadSleepTest.start();
    }
}

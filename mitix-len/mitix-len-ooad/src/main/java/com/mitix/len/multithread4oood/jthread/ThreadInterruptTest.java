package com.mitix.len.multithread4oood.jthread;

import java.util.concurrent.TimeUnit;

/**
 * @author oldflame-jm
 * @create 2018/4/6
 * ${DESCRIPTION}
 */

public class ThreadInterruptTest {
    /**
     * 调用了以后线程依然在跑，没有中断的迹象
     * 状态虽然被置位了  但是线程还是在跑
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadInterrupt());
        thread.start();

        thread.interrupt();
        System.out.println("刚打断的状态 " + thread.isInterrupted());
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("打断后一秒的状态 " + thread.isInterrupted());

        thread.interrupt();
        System.out.println("刚打断的状态 " + thread.isInterrupted());
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("打断后一秒的状态 " + thread.isInterrupted());

        thread.interrupt();
        System.out.println("刚打断的状态 " + thread.isInterrupted());
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("打断后一秒的状态 " + thread.isInterrupted());


    }
}

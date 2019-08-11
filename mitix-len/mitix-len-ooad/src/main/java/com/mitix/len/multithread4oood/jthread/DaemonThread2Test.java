package com.mitix.len.multithread4oood.jthread;

import java.util.concurrent.TimeUnit;

/**
 * @author oldflame-jm
 * @create 2018/4/5
 * 增加了一个其他线程一直在跑  所有守护线程一直都在
 */
public class DaemonThread2Test {

    public static void main(String[] args) {
        DaemonThread2Test daemonThreadTest = new DaemonThread2Test();
        daemonThreadTest.testDaemon();

    }

    public void testDaemon() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread childThread = new Thread(new ChildThread());
                childThread.setDaemon(true);
                childThread.start();
                System.out.println("i am main thread..");
            }
        });
        thread.start();
        Thread anotherThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("i am another thread ..");
                    try {
                        TimeUnit.MILLISECONDS.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        anotherThread.start();
    }


    public class ChildThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("i am child thread..");
                try {
                    TimeUnit.MILLISECONDS.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}


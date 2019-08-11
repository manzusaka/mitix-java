package com.mitix.len.multithread4oood.jthread;

import java.util.concurrent.TimeUnit;

/**
 * @author oldflame-jm
 * @create 2018/4/5
 * Childthread虽然是守护线程  单当时主线程全部释放   么有线程可以守护，所以守护线程也会推出
 */
public class DaemonThreadTest {

    public static void main(String[] args) {
        DaemonThreadTest daemonThreadTest = new DaemonThreadTest();
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


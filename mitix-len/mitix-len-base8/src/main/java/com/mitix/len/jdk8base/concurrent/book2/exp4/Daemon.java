package com.mitix.len.jdk8base.concurrent.book2.exp4;

import java.util.concurrent.TimeUnit;

/**
 * @author oldflame-jm
 * @create 2018/6/23
 * ${DESCRIPTION}
 */
public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("DaemonThread finally run.");
            }
        }

    }
}

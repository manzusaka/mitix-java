package com.mitix.len.multithread4oood.jthread;

/**
 * @author oldflame-jm
 * @create 2018/3/5
 * ${DESCRIPTION}
 */
public class PrintThread extends Thread {
    private String message;

    public PrintThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("this is " + message + " ! " + i);
        }
    }

    public static void main(String[] args) {
        new PrintThread("Good").start();
        new PrintThread("Nice").start();

    }
}

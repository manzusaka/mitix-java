package com.mitix.len.multithread4oood.jthread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author oldflame-jm
 * @create 2018/3/5
 * ${DESCRIPTION}
 */
public class PrintThreadFactory implements Runnable {
    private String message;

    public PrintThreadFactory(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("this is " + message + " ! " + i);
        }
    }

    public static void main(String[] args) {
        ThreadFactory factory = Executors.defaultThreadFactory();
        factory.newThread(new PrintThreadFactory("Good")).start();
        factory.newThread(new PrintThreadFactory("Nice")).start();
    }
}

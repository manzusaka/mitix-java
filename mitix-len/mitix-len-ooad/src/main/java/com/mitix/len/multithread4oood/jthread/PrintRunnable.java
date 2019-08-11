package com.mitix.len.multithread4oood.jthread;

/**
 * @author oldflame-jm
 * @create 2018/3/5
 * ${DESCRIPTION}
 */
public class PrintRunnable implements Runnable {
    private String message;

    public PrintRunnable(String message) {
        this.message = message;
    }

    public static void main(String[] args) {
        new Thread(new PrintRunnable("Good")).start();
        new Thread(new PrintRunnable("Nice")).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (i == 500) {
                System.gc();
            }
            System.out.println("this is " + message + " ! " + i);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("整个类已经被回收....说明主线程的类都被回收了 程序还在跑");
    }
}

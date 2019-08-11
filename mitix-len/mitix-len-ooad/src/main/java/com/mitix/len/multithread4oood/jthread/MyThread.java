package com.mitix.len.multithread4oood.jthread;

/**
 * @author oldflame-jm
 * @create 2018/3/5
 * 最基本的通过继承方式新建线程
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("this is Nice ! " + i);
        }
    }
    
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("this is Good ! " + i);
        }
    }

}

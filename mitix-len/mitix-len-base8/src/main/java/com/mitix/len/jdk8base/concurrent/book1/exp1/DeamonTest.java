package com.mitix.len.jdk8base.concurrent.book1.exp1;

public class DeamonTest {
    //守护线程
    public static class DeamonT extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("in current thread is live " + getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        DeamonT deamonT = new DeamonT();
        deamonT.setName("测试我是一个守护线程");
        //设置一个线程为守护线程   虚拟机
        deamonT.setDaemon(true);
        deamonT.start();
    }
}

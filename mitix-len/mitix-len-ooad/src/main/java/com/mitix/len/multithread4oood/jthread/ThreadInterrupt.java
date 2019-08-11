package com.mitix.len.multithread4oood.jthread;

/**
 * @author oldflame-jm
 * @create 2018/4/6
 * ${DESCRIPTION}
 */
public class ThreadInterrupt implements Runnable {
    @Override
    public void run() {
        for (; ; ) {
            //可以实现某些业务逻辑要执行前需要先判断  是否线程被中断
            if (!Thread.currentThread().isInterrupted()) {
                System.out.println("thread is running..");
                long currentTime = System.currentTimeMillis();
                for (; System.currentTimeMillis() - currentTime < 1000; ) {

                }
            } else {
                System.out.println("MMP 打断我干嘛。。。");
                //拿到当前线程的中断状态  并清除中断标记
                boolean b = Thread.interrupted();
                System.out.println("我自己恢复一下状态。。。");
            }
        }
    }
}

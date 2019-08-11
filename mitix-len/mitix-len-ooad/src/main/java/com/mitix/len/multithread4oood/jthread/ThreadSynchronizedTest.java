package com.mitix.len.multithread4oood.jthread;

/**
 * @author oldflame-jm
 * @create 2018/4/6
 * ${DESCRIPTION}
 */
public class ThreadSynchronizedTest implements Runnable {
    public static void main(String[] args) {
        Thread test1 = new Thread(new ThreadSynchronizedTest());
        Thread test2 = new Thread(new ThreadSynchronizedTest());
        test1.start();
        test2.start();
    }

    @Override
    public void run() {
        //调用对象锁  两个方法在多线程都可以进去 可以确定，对象所锁的事对象本身
//        ThreadSynchronized t1 = new ThreadSynchronized();
//        t1.doSamething1();

        //使用static  锁的事类对象class  几个线程都一样
//        ThreadSynchronized.doSamething3();

        //如果使用类中的对象做锁  那就是用的单独的对象
//        ThreadSynchronized t1 = new ThreadSynchronized();
//        t1.doSamething2();
        ThreadSynchronized t1 = new ThreadSynchronized();
        t1.doSamething4();
    }
}

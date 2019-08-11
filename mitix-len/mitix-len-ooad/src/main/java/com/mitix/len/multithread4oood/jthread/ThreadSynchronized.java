package com.mitix.len.multithread4oood.jthread;

import java.util.concurrent.TimeUnit;

/**
 * @author oldflame-jm
 * @create 2018/3/5
 * ${DESCRIPTION}
 */
public class ThreadSynchronized {
    private Object syncObject = new Object();
    private static Object sSyncObject = new Object();

    //静态方法同步(锁为ThreadSynchronizedTest.class)
    public static synchronized String doSamething3() {
        System.out.println("this is something3 start");
        try {
            TimeUnit.MILLISECONDS.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("this is something3 end");
        return "this is something3 end";
    }

    //方法的同步(锁为ThreadSynchronizedTest的Object)
    public synchronized String doSamething1() {
        System.out.println("this is something1 start");
        System.out.println("object is " + this);
        try {
            TimeUnit.MILLISECONDS.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("this is something1 end");
        return "this is something1 end";
    }


    public String doSamething2() {
        //代码块的同步
        synchronized (syncObject) {
            System.out.println("this is something2 start");
            System.out.println("object is " + this);
            try {
                TimeUnit.MILLISECONDS.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this is something2 end");
            return "this is something2 end";
        }
    }

    public String doSamething4() {
        //代码块的同步
        synchronized (sSyncObject) {
            System.out.println("this is something4 start");
            System.out.println("object is " + this);
            try {
                TimeUnit.MILLISECONDS.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this is something4 end");
            return "this is something4 end";
        }
    }

}

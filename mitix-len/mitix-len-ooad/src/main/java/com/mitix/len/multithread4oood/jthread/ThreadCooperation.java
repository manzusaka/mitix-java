package com.mitix.len.multithread4oood.jthread;

import java.util.concurrent.TimeUnit;

/**
 * @author oldflame-jm
 * @create 2018/4/6
 * ${DESCRIPTION}
 */
public class ThreadCooperation {
    private static Object sSyncObject = new Object();

    public String doSamething() {
        //代码块的同步
        synchronized (sSyncObject) {
            System.out.println("this is something start");
            System.out.println("object is " + this);
            //先进行wait()保证第二个线程能进来
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this is something end");
            return "this is something end";
        }
    }

    public String doSamething2() {
        //代码块的同步
        synchronized (sSyncObject) {
            System.out.println("this is something2 start");
            System.out.println("object is " + this);
            try {
                TimeUnit.MILLISECONDS.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this is something2 end");
            //进行释放
            this.notify();
            return "this is something2 end";
        }
    }
}

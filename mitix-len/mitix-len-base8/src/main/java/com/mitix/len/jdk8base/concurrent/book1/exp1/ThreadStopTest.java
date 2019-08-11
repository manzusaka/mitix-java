package com.mitix.len.jdk8base.concurrent.book1.exp1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ThreadStopTest {
    //线程的停止--不建议使用，会释放所有的monitor
    private Object lock;
    private Map<String, String> data = new HashMap();

    /**
     * Thread  看PPT
     */
    @Test

    public void operationThread() {
        System.out.println("main is current " + Thread.currentThread().getId());
        data.put("aa", "aaa");
        data.put("bb", "bbb");
        operationThread1();
        operationThread2();
    }


    public void operationThread1() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    data.put("aa", "ccc");
                    try {
                        Thread.sleep(50000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        thread.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.stop();
    }

    public void operationThread2() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println(data.get("aa"));
                    System.out.println(data.get("bb"));
                }

            }
        });
        thread.start();
    }
}

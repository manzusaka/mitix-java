package com.mitix.len.jdk8base.concurrent.book2.exp5;

import com.mitix.len.jdk8base.concurrent.book2.SleepUtils;
import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * @author oldflame-jm
 * @create 2018/7/8
 * ${DESCRIPTION}
 */
public class TwinsLockTest {
    @Test
    public void test() {

        final Lock lock = new TwinsLock();

        class Worker extends Thread {

            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }

        }

        // 启动10个线程
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();

            w.setDaemon(true);

            w.start();
        }
        // 每隔1秒换行
        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println();
        }

    }
}

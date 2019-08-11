package com.mitix.len.jdk8base.concurrent.book2.exp5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author oldflame-jm
 * @create 2018/7/8
 * ${DESCRIPTION}
 */
public class FairAndUnfairTest {
    private static Lock fairLock = new ReentrantLock2(true);

    private static Lock unfairLock = new ReentrantLock2(false);

    public static void main(String[] args) {
        // 公平锁
//        for (int i = 1; i < 6; i++) {
//            Thread thread = new Job(fairLock);
//            thread.setName("thread " + i);
//            thread.start();
//        }
        //非公平锁
        for (int i = 1; i < 6; i++) {
            Thread thread = new Job(unfairLock);
            thread.setName("thread " + i);
            thread.start();
        }
    }


    private void testLock(Lock lock) {
        // 启动5个Job（略）
        for (int i = 1; i < 6; i++) {
            Thread thread = new Job(lock);
            thread.setName("thread " + i);
            thread.start();
        }
    }

    private static class Job extends Thread {
        private Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            for (; ; ) {
                lock.lock();
                try {
                    for (int i = 0; i < 2; i++) {
                        StringBuffer buffer = new StringBuffer();
                        buffer.append("lock by ").append(Thread.currentThread().getName()).append("[");
                        ReentrantLock2 lock2 = (ReentrantLock2) lock;
                        Collection<Thread> threads = lock2.getQueuedThreads();
                        for (Thread thread : threads) {
                            buffer.append(thread.getName()).append(",");
                        }
                        buffer.append("]");
                        System.out.println(buffer.toString());
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private static class ReentrantLock2 extends ReentrantLock {

        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        @Override
        public Collection<Thread> getQueuedThreads() {
            List<Thread> arrayList = new ArrayList<Thread>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }

    }
}

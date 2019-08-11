package com.mitix.len.jdk8base.concurrent.book2.exp5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author oldflame-jm
 * @create 2018/7/12
 * ${DESCRIPTION}
 */
public class ConditionUseCase {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void conditionWait() throws InterruptedException {

        lock.lock();

        try {
            condition.await();

        } finally {
            lock.unlock();

        }
    }

    public void conditionSignal() throws InterruptedException {

        lock.lock();

        try {
            condition.signal();

        } finally {
            lock.unlock();

        }
    }
}

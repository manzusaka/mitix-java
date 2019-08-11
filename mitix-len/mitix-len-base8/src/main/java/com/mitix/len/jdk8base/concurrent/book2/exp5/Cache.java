package com.mitix.len.jdk8base.concurrent.book2.exp5;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author oldflame-jm
 * @create 2018/7/8
 * 读写锁使用说明
 * <p>
 * 1.state是队列同步状态标记   int类型高16位是读锁  低16位是写锁
 * 1.写锁   00000000000000001111111111111111，当和state 进行 & 运算的时候
 * 只要低位有一个数  然后这个进程不是自己  那就是被其他写进程锁住了
 * 那就是如果写锁被取了以后  写锁后面的读也得排队
 * 2.读锁  判断读锁是通过  state>>>16处理
 * 只要这个时候读锁不用中断（应该是写已经在处理中了）+ 读锁次数<65536+ CAS成功
 * 那就可以算是拿到读锁了
 * <p>
 * 3.读线程标记规则
 * 如果r=0  就是第一个线程进去读  那标记firstReader
 */
public class Cache {
    static Map<String, Object> map = new HashMap<String, Object>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock r = rwl.readLock();
    static Lock w = rwl.writeLock();

    // 获取一个key对应的value
    public static final Object get(String key) {
        r.lock();
        try {
            return map.get(key);
        } finally {

            r.unlock();
        }
    }

    // 设置key对应的value，并返回旧的value
    public static final Object put(String key, Object value) {

        w.lock();
        try {
            return map.put(key, value);
        } finally {

            w.unlock();
        }
    }

    //清空所有的内容
    public static final void clear() {

        w.lock();
        try {
            map.clear();
        } finally {

            w.unlock();
        }
    }
}

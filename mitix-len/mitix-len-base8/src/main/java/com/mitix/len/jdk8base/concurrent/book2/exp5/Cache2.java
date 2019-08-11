package com.mitix.len.jdk8base.concurrent.book2.exp5;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author oldflame-jm
 * @create 2018/7/8
 */
public class Cache2 {
    static Map<String, Object> map = new HashMap<String, Object>();
    static ReentrantLock rwl = new ReentrantLock();


    // 获取一个key对应的value
    public static final Object get(String key) {
        rwl.lock();
        try {
            return map.get(key);
        } finally {

            rwl.unlock();
        }
    }

    // 设置key对应的value，并返回旧的value
    public static final Object put(String key, Object value) {

        rwl.lock();
        try {
            return map.put(key, value);
        } finally {

            rwl.unlock();
        }
    }

    //清空所有的内容
    public static final void clear() {

        rwl.lock();
        try {
            map.clear();
        } finally {

            rwl.unlock();
        }
    }

    public static void main(String[] args) {
        Cache2.put("1", "info1");
        Cache2.put("2", "info2");
        Cache2.put("3", "info3");
        for (int i = 1; i < 4; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Cache2.get(Thread.currentThread().getName()));
                }
            });
            thread.setName("" + i);
            thread.start();
        }
    }
}

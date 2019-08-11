package com.mitix.len.jdk7.collection;

import java.util.HashMap;

/**
 * @author oldflame-jm
 * @create 2018/5/1
 * ${DESCRIPTION}
 */
public class HashMapTest {
    static final HashMap<Integer, String> map = new HashMap<>(2, 0.75f);


    /**
     * 测试hashmap无线循环死锁
     * 1.测试在jdk1.7进行
     * 2.在void transfer(Entry[] newTable, boolean rehash)方法第一行设置基于线程的断掉
     * 3.在上述方法Entry<K,V> next = e.next; 设置断点
     *
     * @param args
     */
    public static void main(String[] args) {
        map.put(5, "C");

        Thread thread1 = new Thread("thread1") {
            @Override
            public void run() {
                map.put(7, "B");
                System.out.println(map);
            }
        };

        Thread thread2 = new Thread("thread2") {
            @Override
            public void run() {
                map.put(3, "A");
                System.out.println(map);
            }
        };
        System.out.println("before thread start");
        thread1.start();
        thread2.start();
    }


}


package com.mitix.len.jdk8base.collection;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author oldflame-jm
 * @create 2018/5/1
 * ${DESCRIPTION}
 */
public class HashMapExp {

    //默认初始容量为16，这里这个数组的容量必须为2的n次幂。
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    //最大容量为2的30次方
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 测试AbstractMap的equals方法
     * 1.比较是否是一个对象
     * 2.确定是不是都是map类型 长度是否一样
     * 3.迭代的对比里面的对象是否一样
     */
    @Test
    public void testAbstractMapEquals() {
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();
        map1.put("aa", "aa");
        map1.put("bb", "bb");
        map2.put("aa", "aa");
        map2.put("bb", "bb");
        System.out.println(map1.equals(map2));
        //map的toString方法
        System.out.println(map1.toString());
    }

    /**
     * 测试hashmap扩容的方式
     */
    @Test
    public void testTableSizeFor() {
        int MAXIMUM_CAPACITY = 1 << 30;
        int n = 65 - 1;
        //49 = 00000000 00000000 00000000 00110001
        n = n | n >>> 1;
        n = n | n >>> 2;
        n = n | n >>> 4;
        n = n | n >>> 8;
        n = n | n >>> 16;
        int ret = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        System.out.println(" this is ret " + ret);
    }

    /**
     * hashMap的死循环
     * 测试代码在jdk1.7的工程里面测试
     */
    @Test
    public void testHashMapInfiniteLoop() {
        HashMap<Integer, String> map = new HashMap<>(2, 0.75f);
        map.put(5, "C");

        new Thread(new Runnable() {
            @Override
            public void run() {
                map.put(7, "B");
                System.out.println(map);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                map.put(3, "A");
                System.out.println(map);
            }
        }).start();
    }


}


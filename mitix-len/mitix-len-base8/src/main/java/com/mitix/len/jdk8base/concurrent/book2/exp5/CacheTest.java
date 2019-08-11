package com.mitix.len.jdk8base.concurrent.book2.exp5;

/**
 * @author oldflame-jm
 * @create 2018/7/11
 * ${DESCRIPTION}
 */
public class CacheTest {
    public static void main(String[] args) {
        Cache.put("1", "info1");
        Cache.put("2", "info2");
        Cache.put("3", "info3");
        for (int i = 1; i < 4; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Cache.get(Thread.currentThread().getName()));
                }
            });
            thread.setName("" + i);
            thread.start();
        }
    }
}

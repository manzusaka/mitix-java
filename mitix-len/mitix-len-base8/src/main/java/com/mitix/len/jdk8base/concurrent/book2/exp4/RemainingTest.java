package com.mitix.len.jdk8base.concurrent.book2.exp4;

/**
 * @author oldflame-jm
 * @create 2018/6/29
 * ${DESCRIPTION}
 */
public class RemainingTest implements Runnable {
    private String result;

    // 对当前对象加锁
    public synchronized String get(long mills) throws InterruptedException {
        long future = System.currentTimeMillis() + mills;
        long remaining = mills;
        // 当超时大于0并且result返回值不满足要求
        while ((result == null) && remaining > 0) {
            wait(remaining);
        }

        remaining = future - System.currentTimeMillis();
        return result;

    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RemainingTest());
        thread.start();
    }

    @Override
    public void run() {
        try {
            String result = get(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

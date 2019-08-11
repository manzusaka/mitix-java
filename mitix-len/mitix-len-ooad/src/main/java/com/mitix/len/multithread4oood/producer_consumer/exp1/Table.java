package com.mitix.len.multithread4oood.producer_consumer.exp1;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author oldflame-jm
 * @create 2018/4/9
 * ${DESCRIPTION}
 */
public class Table {
    private final String[] buffer;
    private Queue<String> queue;
    private int tail;
    private int head;
    private int count;

    public Table(int count) {
        this.queue = new LinkedBlockingDeque<>();
        this.buffer = new String[count];
        this.tail = 0;
        this.head = 0;
        this.count = 0;
    }

    public void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        queue.offer(cake);
//        synchronized (buffer) {
//            System.out.println(Thread.currentThread().getName() + " puts " + cake);
//            for (; count > buffer.length; ) {
//                buffer.wait();
//            }
//            //当前位置放入蛋糕
//            buffer[tail] = cake;
//            //计算下一个可以放入的蛋糕位置
//            tail = (tail + 1) % buffer.length;
//            //计算总数
//            count++;
//            //释放所有等待的线程（包括生产者消费者）
//            buffer.notifyAll();
//
//        }
    }

    public String take() throws InterruptedException {
        String cake = queue.poll();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
//        synchronized (buffer) {
//            while (count <= 0) {
//                buffer.wait();
//            }
//
//            //从第一个开始消费
//            String cake = buffer[head];
//            //计算新的head
//            head = (head + 1) % buffer.length;
//            //计算总数
//            count--;
//            //释放所有等待资源（包括生产者和消费者）
//            buffer.notifyAll();
//            System.out.println(Thread.currentThread().getName() + " takes " + cake);
//            return cake;
//        }

    }
}

package com.mitix.len.jdk8base.concurrent.book1.wjob.job2;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 2.使用 wait notify 实现一个队列，队列有2个方法，add 和 get 。
 * add方法往队列中添加元素，get方法往队列中获得元素。
 * 队列必须是线程安全的。如果get执行时，队列为空，线程必须阻塞等待，直到有队列有数据。
 * 如果add时，队列已经满，则add线程要等待，直到队列有空闲空间。
 */
public class WaitNotifyQueue {
    private final Queue<String> queue = new LinkedList<>();
    private final int capacity = 2;

    public void add(String name) {
        synchronized (queue) {
            //挂起
            if (queue.size() == capacity) {
                try {
                    System.out.println("is wait add name is " + name);
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.add(name);
            //System.out.println("add queue success, name is " + name + "  size is" + queue.size());
            //已经加完了  其他线程释放可以取数据了
            queue.notify();
        }
    }

    public String get() {
        synchronized (queue) {
            if (queue.size() == 0) {
                try {
                    System.out.println("is wait get name");
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String name = queue.poll();
            //System.out.println("get queue success, name is " + name + "  size is" + queue.size());
            //已经加完了  其他线程释放可以取数据了
            queue.notify();
            return name;
        }
    }

}

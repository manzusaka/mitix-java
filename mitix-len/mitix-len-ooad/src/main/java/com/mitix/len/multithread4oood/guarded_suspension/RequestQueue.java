package com.mitix.len.multithread4oood.guarded_suspension;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author oldflame-jm
 * @create 2018/4/8
 * ${DESCRIPTION}
 */
public class RequestQueue {

    private final Queue<Request> queue = new LinkedList<>();

    public Request getRequest() {
        synchronized (queue) {
            for (; queue.peek() == null; ) {
                System.out.println(Thread.currentThread().getName()+"  waiting...");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return queue.remove();
        }
    }


    public synchronized void putRequest(Request request) {
        synchronized (queue) {
            queue.offer(request);
            //如果使用notify，则挨释放queue上面的等待线程
            //queue.notify();
            //如果使用notifyAll,则每次都全部释放，大家去抢queue锁
            queue.notifyAll();
            //这个地方有个疑问，为什么每次都是一个线程抢到资源  然后很久才换一个线程
        }
    }
}

package com.mitix.len.multithread4oood.guarded_suspension;

import java.util.concurrent.TimeUnit;

/**
 * @author oldflame-jm
 * @create 2018/4/8
 * ${DESCRIPTION}
 */
public class ServerThread extends Thread {
//    private final Random random = new Random();
    private final RequestQueue queue;

    public ServerThread(RequestQueue queue, String name) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10000; i++) {
            Request request = queue.getRequest();
            System.out.println(Thread.currentThread().getName() + " handlers " + request);
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

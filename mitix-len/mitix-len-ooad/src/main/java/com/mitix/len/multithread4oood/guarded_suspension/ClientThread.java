package com.mitix.len.multithread4oood.guarded_suspension;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author oldflame-jm
 * @create 2018/4/8
 * ${DESCRIPTION}
 */
public class ClientThread extends Thread {

    private final Random random = new Random();
    private final RequestQueue queue;

    public ClientThread(RequestQueue queue, String name) {
        super(name);
        this.queue = queue;
    }


    @Override
    public void run() {

        for (int i = 0; i < 10000; i++) {
            Request request = new Request("No." + i, i);
            System.out.println(Thread.currentThread().getName() + " request " + request);
            queue.putRequest(request);
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

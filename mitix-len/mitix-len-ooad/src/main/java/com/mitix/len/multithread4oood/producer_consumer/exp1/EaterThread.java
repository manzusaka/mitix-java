package com.mitix.len.multithread4oood.producer_consumer.exp1;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author oldflame-jm
 * @create 2018/4/9
 * ${DESCRIPTION}
 */
public class EaterThread extends Thread {
    private final Random random;
    private final Table table;


    public EaterThread(String name, Table table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        try {
            for (; ; ) {
                String cake = table.take();
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

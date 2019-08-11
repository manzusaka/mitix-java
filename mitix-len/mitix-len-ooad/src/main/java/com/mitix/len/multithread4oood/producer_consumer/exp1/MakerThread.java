package com.mitix.len.multithread4oood.producer_consumer.exp1;


import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author oldflame-jm
 * @create 2018/4/9
 * ${DESCRIPTION}
 */
public class MakerThread extends Thread {
    private final Random random;
    private final Table table;
    private static int id = 0;

    public MakerThread(String name, Table table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        try {
            for (; ; ) {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(5000));
                String cake = "[Cake No.]" + nextId() + " by " + getName();
                table.put(cake);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized int nextId() {
        return id++;
    }

}

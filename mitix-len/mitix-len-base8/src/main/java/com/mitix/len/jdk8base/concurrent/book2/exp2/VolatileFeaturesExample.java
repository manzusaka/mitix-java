package com.mitix.len.jdk8base.concurrent.book2.exp2;

/**
 * @author oldflame-jm
 * @create 2018/5/16
 * ${DESCRIPTION}
 */
public class VolatileFeaturesExample {
    volatile long vl = 0L;

    public void set(long l) {

        vl = l;
    }

    public void getAndIncrement() {

        vl++;
    }

    public long get() {

        return vl;
    }
}

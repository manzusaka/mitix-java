package com.mitix.len.jdk8base.concurrent.book2.exp4;

import java.util.concurrent.TimeUnit;

/**
 * @author oldflame-jm
 * @create 2018/5/23
 * ${DESCRIPTION}
 */
public class NleepThread extends Thread implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("1111111111");
            try {
                TimeUnit.MILLISECONDS.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

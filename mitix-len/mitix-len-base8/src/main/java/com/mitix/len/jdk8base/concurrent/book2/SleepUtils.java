package com.mitix.len.jdk8base.concurrent.book2;

import java.util.concurrent.TimeUnit;

/**
 * @author oldflame-jm
 * @create 2018/7/8
 * ${DESCRIPTION}
 */
public class SleepUtils {

    public static void second(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

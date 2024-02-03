package com.mitix.len.jvm.classloader;

/**
 * @author oldflame-jm
 * @since 1.0.0
 */
public class GcExample {
    public static void main(String[] args) throws InterruptedException {
        byte[] placeholder = new byte[64 * 1024 * 1024];
        System.gc();
        Thread.sleep(100000);
    }
}

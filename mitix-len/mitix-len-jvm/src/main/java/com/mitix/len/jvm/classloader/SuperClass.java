package com.mitix.len.jvm.classloader;

/**
 * @author oldflame-jm
 * @since 1.0.0
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;
}

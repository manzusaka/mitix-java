package com.mitix.len.jvm.classloader;

/**
 * @author oldflame-jm
 * @since 1.0.0
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}

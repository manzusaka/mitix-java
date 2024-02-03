package com.mitix.len.jvm.allocmemory;

/**
 * @author oldflame-jm
 * @since 1.0.0
 */
public class MethodMain {
    public static void main(String[] args) {
        IDefaultMethod defaultMethod = new DefaultMethod();
        defaultMethod.sayHello();
        defaultMethod.sayHello2();
        defaultMethod.getClass().getClassLoader();
    }
}

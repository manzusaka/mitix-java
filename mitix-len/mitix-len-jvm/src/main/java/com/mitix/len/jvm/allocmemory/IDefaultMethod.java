package com.mitix.len.jvm.allocmemory;

/**
 * @author oldflame-jm
 * @since 1.0.0
 */
public interface IDefaultMethod {
    default void sayHello() {
        System.out.println("interface is lock");
    }

    void sayHello2();
}

package com.mitix.len.jvm.allocmemory;

/**
 * @author oldflame-jm
 * @since 1.0.0
 */

import static java.lang.invoke.MethodHandles.lookup;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

/**
 * JSR 292 MethodHandle 基础用法演示
 *
 * @author IcyFenix
 */
public class MethodHandleTest {
    static class ClassA {
        {
            System.out.println("let use class a");
        }

        public void println(String s) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws Throwable {
        for (int i = 0; i < 100; i++) {
            Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
            // 无论 obj 最终是哪个实现类，下面这句都能正确调用到 println 方法。
            getPrintlnMH(obj).invokeExact("icyfenix");
        }

    }

    private static MethodHandle getPrintlnMH(Object reveiver) throws Throwable {
        // MethodType：代表“方法类型”，包含了方法的返回值（methodType() 的第一个参数）和具体参数（methodType() 第二个及以后的参数）。
        MethodType mt = MethodType.methodType(void.class, String.class);
        // lookup() 方法来自于 MethodHandles.lookup，这句的作用是在指定类中查找符合给定的方法名称、方法类型，并且符合调用权限的方法句柄。
        // 因为这里调用的是一个虚方法，按照 Java 语言的规则，方法第一个参数是隐式的，代表该方法的接收者，也即是 this 指向的对象，这个参数以前是放在参数列表中进行传递，现在提供了 bindTo() 方法来完成这件事情。
        return lookup().findVirtual(reveiver.getClass(), "println", mt).bindTo(reveiver);
    }
}
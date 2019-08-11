package com.mitix.len.jdk8base.unsafe_test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author oldflame-jm
 * @create 2018/7/5
 * 测试Unsafe的用法  提供了cas的基本操作
 */
public final class UnsafeTest {
    private static final Unsafe unsafe = getUnsafe();

    public static void main(String[] args) throws NoSuchFieldException {
        User user = new User("oldflame-Jm", 22, 1, 1000);
        //获取实例字段的偏移地址
        long stateOffset = unsafe.objectFieldOffset
                (User.class.getDeclaredField("age"));
        unsafe.compareAndSwapInt(user, stateOffset, 22, 100);
        System.out.println(user.getAge());


    }


    public static Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {

        }
        return null;
    }

}

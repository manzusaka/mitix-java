package com.mitix.len.jvm4jdk7;

import java.lang.ref.SoftReference;

/**
 * @author oldflame-jm
 * @create 2018/2/8
 * 软引用
 */
public class SoftRef {
    private static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return " name is " + this.name + " and age is " + this.age;
        }
    }


    public static void main(String[] args) {
        SoftRef softRef = new SoftRef();
        User user = softRef.loadUser();
        SoftReference<User> userSoftReference = new SoftReference<User>(user);
        user = null;

        System.out.println(userSoftReference.get());
        System.gc();
        System.out.println("after gc");
        System.out.println(userSoftReference.get());


        byte[] b = new byte[1024 * 927 * 7];
        System.gc();
        System.out.println("after gc menory usered");
        System.out.println(userSoftReference.get());
    }

    private User loadUser() {
        return new User("honghong", 1);
    }

}

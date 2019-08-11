package com.mitix.len.jdk7.construct;

/**
 * Created by oldflame on 2017/3/30.
 */
public class B extends A {
    public B() {
        super("aaa");
        System.out.println("this is b instantiate");

    }

    public static void main(String[] args) {
        B b = new B();

    }
}

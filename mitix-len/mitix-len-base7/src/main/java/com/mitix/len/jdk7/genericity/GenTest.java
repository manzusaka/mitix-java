package com.mitix.len.jdk7.genericity;

/**
 * Created by oldflame on 2017/5/16.
 */
public class GenTest {
    public static void main(String[] args) {
        Gen<Integer> gen = new Gen("info");
        Integer info = gen.getInfo();
        System.out.println("aaa=" + gen.getInfo());
        //可以看到范型在取出以后直接进行打印的时候没有报错？？？
        System.out.println("bbb=" + info);
    }
}

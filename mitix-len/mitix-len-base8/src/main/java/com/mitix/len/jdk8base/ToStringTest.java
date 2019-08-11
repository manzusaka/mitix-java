package com.mitix.len.jdk8base;

/**
 * @author oldflame-jm
 * @create 2018/10
 * @see
 * @since
 */
public class ToStringTest {
    String name;
    String didi;
    Integer age;

    public static void main(String[] args) {
        ToStringTest toStringTest = new ToStringTest("hong", "info", 30);
        //System.out.println(toStringTest);
    }

    public ToStringTest(String name, String didi, Integer age) {
        this.name = name;
        this.didi = didi;
        this.age = age;
    }

    @Override
    public String toString() {
        System.out.println("this toString is call  by thread " + Thread.currentThread());
        return "name is " + name + " and didi is " + didi + "and age is " + age;
    }
}

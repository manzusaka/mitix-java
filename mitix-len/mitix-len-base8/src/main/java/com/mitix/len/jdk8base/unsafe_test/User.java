package com.mitix.len.jdk8base.unsafe_test;

/**
 * @author oldflame-jm
 * @create 2018/7/5
 * ${DESCRIPTION}
 */
public class User {
    private String name;
    private int age;
    private long max;
    private long min;

    public User(String name, int age, long min, long max) {
        this.name = name;
        this.age = age;
        this.min = min;
        this.max = max;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public long getMin() {
        return min;
    }

    public void setMin(long min) {
        this.min = min;
    }
}

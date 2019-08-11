package com.mitix.len.multithread4oood.guarded_suspension;

/**
 * @author oldflame-jm
 * @create 2018/4/8
 * ${DESCRIPTION}
 */
public class Request {
    private final String name;
    private final int age;

    public Request(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

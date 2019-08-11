package com.mitix.len.jdk8base.lambda.leson3;

/**
 * @author oldflame-jm
 * @create 2018/9/8
 * ${DESCRIPTION}
 */
public class Car {
    private int age;
    private String name;

    public Car(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.mitix.len.jdk8base.lambda.leson1;

/**
 * @author oldflame-jm
 * @create 2018/9/2
 * ${DESCRIPTION}
 */
public class Car {
    private int x;
    private int y;

    public Car() {
        this.x = 0;
        this.y = y;
    }

    public Car(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public String toString() {
        return "this x is [" + x + "] and this y is [" + y + "]";
    }
}

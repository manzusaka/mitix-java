package com.mitix.len.inttver;

/**
 * @author oldflame-jm
 * @since 1.0.0
 */
public class NewClassExp {

    private static class Apple {
        public String getName() {
            return "test";
        }
    }

    public static void main(String[] args) {
        //可以在New的时候直接重写方法，实质上是一个匿名继承
        Apple apple = new Apple() {
            @Override
            public String getName() {
                return super.getName();
            }
        };
    }

}

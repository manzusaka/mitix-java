package com.mitix.len.jdk7.genericity;

/**
 * Created by oldflame on 2017/5/16.
 */
public class Gen<T> {
    private String info;

    public Gen(String a) {
        this.info = a;
    }

    public T getInfo() {
        return (T) info;
    }
}

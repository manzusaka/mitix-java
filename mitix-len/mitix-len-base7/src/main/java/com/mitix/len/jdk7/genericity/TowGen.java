package com.mitix.len.jdk7.genericity;

/**
 * Created by oldflame on 2017/5/18.
 */
public class TowGen<T, V> {
    private T t;
    private V v;

    public TowGen(T to, V vo) {
        this.t = to;
        this.v = vo;
    }

}

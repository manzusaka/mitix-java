package com.mitix.len.lamdba;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author oldflame-jm
 * @since 1.0.0
 */

public class TestLamdba01 {

    //原来的匿名内部类
    @Test
    public void test01() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(comparator);
    }

    //这个是Lamdba
    @Test
    public void test02() {
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
    }

}

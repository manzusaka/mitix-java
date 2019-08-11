package com.mitix.len.jdk8base.lambda.leson5;

import org.junit.Test;

import java.util.stream.LongStream;

/**
 * @author oldflame-jm
 * @create 2018/9/14
 * Fork/Join框架学习
 */
public class ForkJoinTest {

    @Test
    public void testAdd() {
        long[] numbers = LongStream.rangeClosed(1, 100000).toArray();
        Calculator calculator = new ForLoopCalculator();
        System.out.println(calculator.sumUp(numbers)); // 打印结果500500
    }


    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 100000).toArray();
        Calculator calculator = new ForLoopCalculator();
        System.out.println(calculator.sumUp(numbers)); // 打印结果500500
    }
}

package com.mitix.len.jdk8base.concurrent.book2.exp6;

/**
 * @author oldflame-jm
 * @create 2018/7/17
 * $获取CPU推荐的核数
 */
public class ProcessTest {
    public static void main(String[] args) {
        System.out.println("recommend process is " + Runtime.getRuntime().availableProcessors());
    }
}

package com.mitix.len.jdk8base.lambda.leson2;

import org.junit.Test;

import java.util.concurrent.Callable;

/**
 * @author oldflame-jm
 * @create 2018/9/6
 * ${DESCRIPTION}
 */
public class RunnableTest {
    @Test
    public void testRunnable() throws Exception {
        Callable<Runnable> c = () -> () -> System.out.println("123");
        c.call().run();
    }
}

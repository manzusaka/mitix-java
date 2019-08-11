package com.mitix.len.jdk8base.lambda.leson2;

import org.junit.Test;

import java.util.function.Predicate;

/**
 * @author oldflame-jm
 * @create 2018/9/6
 * ${DESCRIPTION}
 */
public class PredicateTest {
    Predicate<String> p = o -> {
        System.out.println("this is p ");
        return o.equals("test");
    };
    Predicate<String> g = o -> {
        System.out.println("this is g");
        return o.startsWith("t");
    };

    /**
     * negate: 用于对原来的Predicate做取反处理；
     * 如当调用p.test("test")为True时，调用p.negate().test("test")就会是False；
     */
    @Test
    public void testNegate() {
        System.out.println(p.negate().test("test"));
        System.out.println(g.negate().test("text"));

    }


    /**
     * and: 针对同一输入值，多个Predicate均返回True时返回True，否则返回False；
     * p  g 的test 取逻辑于 &&
     */
    @Test
    public void testAnd() {
        System.out.println(p.and(g).test("test"));
    }

    /**
     * or: 针对同一输入值，多个Predicate只要有一个返回True则返回True，否则返回False
     * p g的 test 去逻辑或||
     */
    @Test
    public void testOr() {
        System.out.println(p.or(g).test("ta"));
    }
}

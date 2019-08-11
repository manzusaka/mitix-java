package com.mitix.len.jdk8base.lambda.leson2;

import org.junit.Test;

public class Hello {

    public Runnable runnable1 = () -> System.out.println(this);

    public Runnable runnable2 = () -> System.out.println(toString());

    public Runnable runnable3 = new Runnable() {
        @Override
        public void run() {
            System.out.println(this);
        }
    };

    public Runnable runnable4 = new Runnable() {
        @Override
        public void run() {
            System.out.println(toString());
        }
    };

    @Override
    public String toString() {
        return "Hello world!!!";
    }

    /**
     * 测试Hello的Lamdba的作用域问题
     */
    @Test
    public void testScopeOfLamdba() {
        new Hello().runnable1.run();
        new Hello().runnable2.run();
    }

    /**
     * 测试Hello的内部类的作用域问题
     */
    @Test
    public void testScopeOfInnerClass() {
        new Hello().runnable3.run();
        new Hello().runnable4.run();
    }

    /**
     * 测试类
     */
    protected void foo() {
        final int i = 2;
        Runnable r = () -> {
            //这里i j的作用域其实是一样的
            //所以不能重复命名
            int j = 3;
        };
    }

}

package com.mitix.len.jdk8base.lambda.leson2;

import org.junit.Test;

import java.util.function.Function;

/**
 * @author oldflame-jm
 * @create 2018/9/6
 * ${DESCRIPTION}
 */
public class FunctionTest {
    Function<Integer, Integer> f = s -> {
        System.out.println("this is f");
        return s++;
    };
    Function<Integer, Integer> g = s -> {
        System.out.println("this is g");
        return s * 2;
    };

    /**
     * 下面表示在执行F时，先执行G，并且执行F时使用G的输出当作输入。
     * 相当于以下代码：
     * Integer a = g.apply(1);
     * System.out.println(f.apply(a));
     */
    @Test
    public void testCompose() {
        System.out.println(f.compose(g).apply(5));

    }

    /**
     * 表示执行F的Apply后使用其返回的值当作输入再执行G的Apply；
     * 相当于以下代码
     * Integer a = f.apply(1);
     * System.out.println(g.apply(a));
     * <p>
     */
    @Test
    public void testAndThen() {
        System.out.println(f.andThen(g).apply(6));
    }


    /**
     * identity方法会返回一个不进行任何处理的Function，即输出与输入值相等；
     * Identity  一致的 相同的
     */
    @Test
    public void testIdentity() {
        System.out.println(Function.identity().apply("a"));
    }

}

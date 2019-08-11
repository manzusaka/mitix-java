package com.mitix.len.jdk8base.lambda.leson2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

/**
 * @author oldflame-jm
 * @create 2018/9/6
 * ${DESCRIPTION}
 */
public class LamdbaUsageScenariosTest {
    /**
     * 使用构造函数的方式
     */
    @Test
    public void testConstructor() {
        List<Car> pointList = Arrays.asList(new Car(1, 2), new Car(2, 3));
        pointList.forEach(car -> {
            car.translate(6, 6);
            System.out.println(car.toString());
        });
    }

    /**
     * 定义变量
     */
    @Test
    public void testVariate() {
        Runnable runnable1 = () -> System.out.println(this);
    }


    /**
     * 方法返回
     */
    @Test
    public void testReturn() {
        testReturnInner();
    }

    private Runnable testReturnInner() {
        return () -> System.out.println("123");
    }

    /**
     * lamdba体内部
     */
    @Test
    public void testLamdbaBody() throws Exception {
        Callable<Runnable> c = () -> () -> System.out.println("123");
        c.call().run();
    }

    /**
     * 使用三元表达式
     */
    @Test
    public void testxpression() {
        boolean flag = false;
        Callable<Integer> c = flag ? (() -> 23) : (() -> 24);
    }

    /**
     * 类型转换
     */
    @Test
    public void testTypeConversion() {
        Object o = (Consumer) x -> System.out.println(x);
    }


}

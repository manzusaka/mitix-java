package com.mitix.len.jdk8base.lambda.leson2;

import org.junit.Test;

/**
 * @author oldflame-jm
 * @create 2018/9/6
 * ${DESCRIPTION}
 */
public class UnaryOperatorTest {
    @Test
    public void testAdd() {
        UnaryOperator u = car -> {
            car.translate(6, 6);
            return car;
        };
        System.out.println(u.addInt(new Car(2, 2)));
    }
}

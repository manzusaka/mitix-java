package com.mitix.len.jdk8base.lambda.leson2;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author oldflame-jm
 * @create 2018/9/6
 * ${DESCRIPTION}
 */
public class ConsumerTest {

    @Test
    public void testAccept() {
        Consumer c = car -> {
            ((Car) car).translate(2, 2);
            System.out.println(car.toString());
        };
        Consumer c2 = car -> {
            ((Car) car).translate(3, 3);
            System.out.println(car.toString());
        };
        c.andThen(c2).accept(new Car(1, 1));
    }
}

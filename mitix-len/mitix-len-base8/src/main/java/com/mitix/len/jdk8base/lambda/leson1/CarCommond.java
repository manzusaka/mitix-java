package com.mitix.len.jdk8base.lambda.leson1;

/**
 * @author oldflame-jm
 * @create 2018/9/3
 * ${DESCRIPTION}
 */
public class CarCommond implements Commond {

    @Override
    public void move(Car car) {
        car.translate(6, 6);
        System.out.println(car.toString());
    }
}

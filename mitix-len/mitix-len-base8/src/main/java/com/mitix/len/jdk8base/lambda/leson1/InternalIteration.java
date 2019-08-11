package com.mitix.len.jdk8base.lambda.leson1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;


/**
 * @author oldflame-jm
 * @create 2018/9/2
 * 从外部迭代到内部迭代内部迭代
 */
public class InternalIteration {

    /**
     * 传统的外部迭代方法
     */
    @Test
    public void testOutIteration() {
        List<Car> pointList = Arrays.asList(new Car(1, 2), new Car(2, 3));
        for (Iterator iterator = pointList.iterator(); iterator.hasNext(); ) {
            ((Car) iterator.next()).translate(6, 6);
        }
    }

    /**
     * Cpmmond模式
     * 这完全是定制化的
     */
    @Test
    public void testUserCommond() {
        CarArrayList<Car> cars = new CarArrayList<>();
        cars.add(new Car(1, 2));
        cars.add(new Car(2, 3));
        cars.forEach(new CarCommond());
    }

    /**
     * 内部迭代方法
     * 通用的内部迭代方法  针对testUserCommond通用化
     */
    @Test
    public void testInnerIteration() {
        List<Car> pointList = Arrays.asList(new Car(1, 2), new Car(2, 3));
        pointList.forEach(new CarConsumer());
    }

    /**
     * 内部迭代方法,Lamdba
     */
    @Test
    public void testInnerIterationLamdba() {
        List<Car> pointList = Arrays.asList(new Car(1, 2), new Car(2, 3));
        pointList.forEach(car -> {
            car.translate(6, 6);
            System.out.println(car.toString());
        });
        UnaryOperator u = car -> {
            ((Car) car).translate(6, 6);
            return car;
        };
        pointList.replaceAll(u);

    }


    public class CarArrayList<T extends Car> extends ArrayList<T> {

        public void forEach(CarCommond commond) {
            for (Car car : this) {
                commond.move(car);
            }
        }
    }

    public class CarConsumer<T extends Car> implements Consumer<Car> {
        @Override
        public void accept(Car car) {
            car.translate(7, 7);
            System.out.println(car.toString());
        }
    }


}


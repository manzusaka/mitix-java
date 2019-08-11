package com.mitix.len.jdk8base.lambda.leson3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author oldflame-jm
 * @create 2018/9/8
 * ${DESCRIPTION}
 */
public class StreamConcurrentTest {

    /**
     * 测试并发  线程不安全的信息
     * 使用非线程安全的流的参数会出现问题
     */
    @Test
    public void testConcurrent() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("doing times {" + i + "}");

            List<Car> cars = new ArrayList<>();
            for (int j = 0; j < 10000; j++) {
                cars.add(new Car(UUID.randomUUID().toString(), i));
            }
            //这里的线程安全非常重要
            //Map<String, List<Car>> carsByName = new HashMap<>();

            Map<String, List<Car>> carsByName = new ConcurrentHashMap<>();
            cars.parallelStream().peek(car -> {
                String name = car.getName();
                List<Car> concurrentCarsByName = carsByName.get(name);
                if (concurrentCarsByName == null) {
                    concurrentCarsByName = new ArrayList<>();
                }
                concurrentCarsByName.add(car);
                carsByName.put(name, concurrentCarsByName);
            }).anyMatch(car -> false);
        }

    }

}

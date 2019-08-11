package com.mitix.len.jdk8base.spi;

import java.util.ServiceLoader;

/**
 * @author oldflame-jm
 * @create 2018/11
 * @since
 */
public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<HelloService> loaders = ServiceLoader.load(HelloService.class);
        for (HelloService service : loaders) {
            service.sayHello();
        }
    }
}

package com.mitix.len.jdk8base.spi.client.america;

import com.mitix.len.jdk8base.spi.HelloService;

/**
 * @author oldflame-jm
 * @create 2018/11
 * @since
 */
public class AmericaHelloService implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("hello world!!");
    }
}

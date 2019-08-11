package com.mitix.len.jdk8base.spi.client.china;

import com.mitix.len.jdk8base.spi.HelloService;

/**
 * @author oldflame-jm
 * @create 2018/11
 * @since
 */
public class ChinaHelloService implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("你好！！世界！！");
    }
}

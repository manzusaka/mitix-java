package com.mitix.len.jdk7.interfacetest;

/**
 * Created by oldflame on 2017/3/30.
 */
public class Test {
    public static void main(String[] args) {
        HelloService.HelloProService service = new HelloServiceImpl();
        service.sayProService();
    }
}

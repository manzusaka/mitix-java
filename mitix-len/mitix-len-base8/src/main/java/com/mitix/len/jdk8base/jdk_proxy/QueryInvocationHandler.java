package com.mitix.len.jdk8base.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author oldflame-jm
 * @create 2018/9/5
 * ${DESCRIPTION}
 */
public class QueryInvocationHandler implements InvocationHandler {

    private Object target;

    public QueryInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("this is proxy");
        method.invoke(target, args);
        return null;
    }
}

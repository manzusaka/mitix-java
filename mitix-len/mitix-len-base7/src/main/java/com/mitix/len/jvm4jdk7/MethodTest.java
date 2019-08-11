package com.mitix.len.jvm4jdk7;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author oldflame-jm
 * @create 2018/2/4
 * jdk 1.6  1.7  方法区可以理解为永久区的一部分  通过-XX:PermSize  -XX:MaxPermSize 设置
 * jdk 1.8  可以设置为 -XX:MetaspaceSize  -XX:MaxMetaspaceSize 设置
 */
public class MethodTest {
    static int count = 0;

    public static void main(final String[] args) {
        try {
            while (true) {
                count++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(JavaMethodAreaOOM.OOMObject.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invoke(objects, args);
                    }
                });
                enhancer.create();
            }
        } catch (Throwable throwable) {
            System.out.println("count is " + count);
            throwable.printStackTrace();
        }
    }
}

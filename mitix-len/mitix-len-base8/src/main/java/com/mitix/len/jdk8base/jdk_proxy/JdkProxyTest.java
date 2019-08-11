package com.mitix.len.jdk8base.jdk_proxy;

import java.lang.reflect.Proxy;

/**
 * @author oldflame-jm
 * @create 2018/9/5
 * ${DESCRIPTION}
 */

public class JdkProxyTest {

    public static void main(String[] args) {
        Dao dao = (Dao) Proxy.newProxyInstance(JdkProxyTest.class.getClassLoader(), new Class[]{Dao.class}, new QueryInvocationHandler(new DaoImpl()));
        dao.query("intech");
    }

}

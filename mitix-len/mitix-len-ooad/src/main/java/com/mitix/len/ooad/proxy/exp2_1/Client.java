package com.mitix.len.ooad.proxy.exp2_1;

import java.lang.reflect.Proxy;

/**
 * 创建于:2016年6月5日<br>
 * 版权所有(C) 2016 one dream code farmer<br>
 * TODO
 * 
 * @author hlh19
 * @version TODO
 */
public class Client {
  public static void main(String[] args) {
    // 实例化目标对象
    Tank tank = new Tank();
    // 实例化InvocationHandler
    TimeHandler handler = new TimeHandler(tank);
    // 根据目标对象生成代理对象
    Moveable proxy = (Moveable) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Moveable.class},
      handler);
    
    //Class<?> porxy=Proxy.getProxyClass(Thread.currentThread().getContextClassLoader(), Moveable.class);
    
    
    // 调用代理对象的方法
    proxy.move();

  }
}

package com.mitix.len.ooad.proxy.exp2_1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

  private Object target;

  public TimeHandler(Object target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    beforeProcess();
    Object result = method.invoke(target, args);
    afterProcess();
    return result;
  }

  private void beforeProcess() {
    System.out.println("------before------");
  }

  private void afterProcess() {
    System.out.println("------after------");
  }


}

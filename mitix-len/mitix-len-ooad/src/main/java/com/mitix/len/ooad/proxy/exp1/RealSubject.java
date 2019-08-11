package com.mitix.len.ooad.proxy.exp1;

/**
 * 创建于:2016年10月29日<br>
 * GPL 2016 a code farmer<br>
 * 真实主题
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class RealSubject implements Subject {

  public RealSubject(){
    
  }
  /*
   * (non-Javadoc)
   * 
   * @see Subject#request()
   */
  @Override
  public void request() {
    System.out.println("我是真实主题执行的方法！！！");

  }

}

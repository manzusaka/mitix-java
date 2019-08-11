package com.mitix.len.ooad.observer.exp2;

/**
 * 
 *创建于:2016年9月5日<br>
 * GPL 2016 a code farmer<br>
 * 目标对象--具体的被观察对象
 * @author infoconsole
 * @version 1.0.0
 * @param <T>
 */
public class NewPaper<T> extends Subject<T>{
  /**
   * 具体的业务
   */
  protected void notifyObserver() {
    super.notifyObserver();
  }
  
  
  protected void notifyObserver2(){
    super.notifyObserver2();
  }
  
}

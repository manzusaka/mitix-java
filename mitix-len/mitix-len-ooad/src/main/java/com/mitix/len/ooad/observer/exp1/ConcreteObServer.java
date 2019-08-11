package com.mitix.len.ooad.observer.exp1;

/**
 * 创建于:2016年8月20日<br>
 * GPL 2016 a code farmer<br>
 * 具体的观察者对象 实现更新方法 是自己的状态和目标保持一致
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class ConcreteObServer implements ObServer {
  private String observerState;

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.atdz.footprint.designpatterns.observer.ep1.ObServer#update(com.atdz.footprint.designpatterns
   * .observer.ep1.Subject)
   */
  @Override
  public void update(Subject subject) {
    // TODO Auto-generated method stub
    observerState = subject.getSubjectState();
    System.out.println(observerState);
  }

}

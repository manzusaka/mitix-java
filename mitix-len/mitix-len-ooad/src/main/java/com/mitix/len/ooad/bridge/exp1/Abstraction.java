package com.mitix.len.ooad.bridge.exp1;

/**
 *创建于:2016年11月12日<br>
 * GPL 2016 a code farmer<br>
 * 抽象化角色
 * @author infoconsole
 * @version 1.0.0
 */
public class Abstraction {
  private Implementer implementer;
  
  /**
   * 商业方法
   */
  protected void operation() {
    implementer.operationImpl();
  }

  public Implementer getImplementer() {
    return implementer;
  }

  public void setImplementer(Implementer implementer) {
    this.implementer = implementer;
  }
}

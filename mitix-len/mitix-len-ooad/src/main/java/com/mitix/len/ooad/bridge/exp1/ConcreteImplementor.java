package com.mitix.len.ooad.bridge.exp1;

/**
 *创建于:2016年11月12日<br>
 * GPL 2016 a code farmer<br>
 * 具体的实现    实现或者继承自实现化角色
 * @author infoconsole
 * @version 1.0.0
 */
public class ConcreteImplementor implements Implementer {

  /* (non-Javadoc)
   * @see Implementer#operationImpl()
   */
  //实现莫个商业方法
  @Override
  public void operationImpl() {
    System.out.println("ConcreteImplementor 实现的某个商业方法");
  }

}

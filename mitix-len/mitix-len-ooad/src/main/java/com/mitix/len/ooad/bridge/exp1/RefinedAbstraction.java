package com.mitix.len.ooad.bridge.exp1;
/**
 * 
 *创建于:2016年11月12日<br>
 * GPL 2016 a code farmer<br>
 * 修正抽象化角色  就是对于抽象角色进行继承  扩展
 * @author infoconsole
 * @version 1.0.0
 */
public class RefinedAbstraction extends Abstraction {
  /**
   * 商业方法
   */
  @Override
  protected void operation() {
    System.out.println("before抽象化修正  有了自己的逻辑");
    
    super.operation();
    
    System.out.println("after抽象化修正  有了自己的逻辑");
  }
}

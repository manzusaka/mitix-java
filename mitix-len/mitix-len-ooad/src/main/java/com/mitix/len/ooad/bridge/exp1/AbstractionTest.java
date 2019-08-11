package com.mitix.len.ooad.bridge.exp1;

/**
 * 
 *创建于:2016年11月12日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * @author infoconsole
 * @version TODO
 */
public class AbstractionTest {
  
  public static void main(String[] args) {
    //注意  再spring中  这里可以使用bean注入  从而实现彻底的代码解耦和
    Implementer impl=new ConcreteImplementor();
    Abstraction abs=new RefinedAbstraction();
    abs.setImplementer(impl);
    abs.operation();
  }
  

}

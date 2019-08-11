/**
 * 
 */
package com.mitix.len.ooad.abstractfactory;

/**
 * 创建于:2016年10月2日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class UsaFactory implements AbstractFactory {
  
  private static final UsaFactory factory = new UsaFactory();
  //具体工厂可以设计成单例模式
  private UsaFactory() {

  }

  public static UsaFactory getInstance() {
    return factory;
  }

  public Apple createApple() {
    return new UsaApple();
  }

  public Strawberry createStrawberry() {
    return new UsaStrawberry();
  }



}

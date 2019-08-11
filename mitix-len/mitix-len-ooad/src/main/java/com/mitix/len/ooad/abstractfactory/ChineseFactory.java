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
public class ChineseFactory implements AbstractFactory {
  private static final ChineseFactory factory=new ChineseFactory();
  
  //具体工厂可以使用单例模式
  private ChineseFactory(){
    
  }
  
  public static ChineseFactory getInstance(){
    return factory ;
  }
  
  public Apple createApple() {
    return new ChineseApple();
  }
  
  public Strawberry createStrawberry() {
    return new ChineseStrawberry();
  }

}

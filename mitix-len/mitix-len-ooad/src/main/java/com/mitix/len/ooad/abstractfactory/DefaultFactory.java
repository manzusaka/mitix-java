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
public abstract class DefaultFactory {
  private static AbstractFactory factory;

  public static void setFactory(Integer index) {
    switch (index) {
      case 1:
        factory = ChineseFactory.getInstance();
        break;
      case 2:
        factory = UsaFactory.getInstance();
      default:
        break;
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see AbstractFactory#createApple()
   */
  public static Apple createApple() {
    if (factory == null) {
      throw new RuntimeException("there is now factory");
    }
    return factory.createApple();
  }

  /*
   * (non-Javadoc)
   * 
   * @see AbstractFactory#createStrawberry()
   */
  public static Strawberry createStrawberry() {
    if (factory == null) {
      throw new RuntimeException("there is now factory");
    }
    return factory.createStrawberry();
  }



}

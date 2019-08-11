package com.mitix.len.ooad.simplefactory.exp5;


/**
 * 创建于:2016年9月25日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version TODO
 */
public class ConcreteProduct {
  private static ConcreteProduct cp = null;

  /**
   * 关闭外部创建的可能性
   */
  private ConcreteProduct() {}

  public static ConcreteProduct create() {
    if (cp == null) {
      cp = new ConcreteProduct();
    }
    return cp;
  }
}

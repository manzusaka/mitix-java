package com.mitix.len.ooad.simplefactory.exp1;

/**
 * 创建于:2016年9月25日<br>
 * GPL 2016 a code farmer<br>
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class FruitGardener {
  /**
   * 静态工厂方法
   * 
   * @param swich
   * @return Fruit
   */
  public static Fruit create(String swich) {
    if (swich.equalsIgnoreCase("apple")) {
      return new Apple();
    } else if (swich.equalsIgnoreCase("grape")) {
      return new Grape();
    } else if (swich.equalsIgnoreCase("strawberry")) {
      return new Strawberry();
    } else {
      throw new RuntimeException("not have this fruit[" + swich + "]");
    }
  }
  
}

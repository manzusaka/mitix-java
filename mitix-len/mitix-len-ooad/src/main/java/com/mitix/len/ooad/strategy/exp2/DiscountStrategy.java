package com.mitix.len.ooad.strategy.exp2;

/**
 * 创建于:2016年10月9日<br>
 * GPL 2016 a code farmer<br>
 * 抽象折扣类
 * 
 * @author infoconsole
 * @version TODO
 */
public abstract class DiscountStrategy {
  // 价格
  protected double price = 0;
  // 数量
  protected int copies = 0;
  
  protected DiscountStrategy(double price, int copies) {
    this.copies = copies;
    this.price = price;
  }

  public abstract double calculateDiscount();
}

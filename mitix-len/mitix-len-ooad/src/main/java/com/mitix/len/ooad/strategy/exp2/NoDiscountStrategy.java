package com.mitix.len.ooad.strategy.exp2;

/**
 * 创建于:2016年10月9日<br>
 * GPL 2016 a code farmer<br>
 * 无折扣
 * 
 * @author infoconsole
 * @version TODO
 */
public class NoDiscountStrategy extends DiscountStrategy {

  protected NoDiscountStrategy(double price, int copies) {
    super(price, copies);
  }

  /*
   * (non-Javadoc)
   * 
   * @see DiscountStrategy#calculateDiscount()
   */
  @Override
  public double calculateDiscount() {
    return 0;
  }

}

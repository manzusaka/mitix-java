package com.mitix.len.ooad.strategy.exp2;

/**
 * 创建于:2016年10月9日<br>
 * GPL 2016 a code farmer<br>
 * 固定折扣
 * 
 * @author infoconsole
 * @version TODO
 */
public class FlatRateStrategy extends DiscountStrategy {
  private double amount;

  protected FlatRateStrategy(double price, int copies) {
    super(price, copies);
    // TODO Auto-generated constructor stub
  }
  
  /*
   * (non-Javadoc)
   * 
   * @see DiscountStrategy#calculateDiscount()
   */
  @Override
  public double calculateDiscount() {
    // TODO Auto-generated method stub
    return super.copies * amount;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

}

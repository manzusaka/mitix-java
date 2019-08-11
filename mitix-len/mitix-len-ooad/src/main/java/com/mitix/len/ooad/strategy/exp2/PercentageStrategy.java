package com.mitix.len.ooad.strategy.exp2;

/**
 * 创建于:2016年10月9日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version TODO
 */
public class PercentageStrategy extends DiscountStrategy {
  private double percent;

  protected PercentageStrategy(double price, int copies) {
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
    return super.price * super.copies * percent;
  }

  public double getPercent() {
    return percent;
  }

  public void setPercent(double percent) {
    this.percent = percent;
  }

}

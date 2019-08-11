package com.mitix.len.ooad.template.exp1;

/**
 *创建于:2016年10月11日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * @author infoconsole
 * @version TODO
 */
public class Coffee extends HotDrink {

  /* (non-Javadoc)
   * @see HotDrink#brew()
   */
  @Override
  protected void brew() {
    System.out.println("冲泡咖啡");

  }

  /* (non-Javadoc)
   * @see HotDrink#addComdiment()
   */
  @Override
  protected void addComdiment() {
    System.out.println("加入糖");

  }

}

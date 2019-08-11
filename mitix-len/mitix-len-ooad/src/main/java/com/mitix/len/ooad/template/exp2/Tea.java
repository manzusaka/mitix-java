package com.mitix.len.ooad.template.exp2;

/**
 *创建于:2016年10月11日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * @author infoconsole
 * @version TODO
 */
public class Tea extends HotDrink {

  /* (non-Javadoc)
   * @see HotDrink#brew()
   */
  @Override
  public void brew() {
    System.out.println("冲泡茶叶");

  }

  /* (non-Javadoc)
   * @see HotDrink#addComdiment()
   */
  @Override
  public void addComdiment() {
    System.out.println("加入牛奶");

  }
  
  @Override
  protected boolean doAddComdiment() {
    System.out.println("自己选要不要加东西");
    return true;
  }

}

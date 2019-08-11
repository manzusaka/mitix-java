package com.mitix.len.ooad.abstractfactory;


/**
 * 创建于:2016年9月25日<br>
 * GPL 2016 a code farmer<br>
 * 苹果
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class UsaApple implements Apple {
  private int treeAge;

  /*
   * (non-Javadoc)
   * 
   * @see com.mitix.len.ooad.simplefactory.Fruit#grow()
   */
  public void grow() {
    System.out.println("UsaApple is grow");
  }

  public void applePlant() {
    System.out.println("UsaApple is plant");

  }

  public int getTreeAge() {
    return treeAge;
  }

  public void setTreeAge(int treeAge) {
    this.treeAge = treeAge;
  }



}

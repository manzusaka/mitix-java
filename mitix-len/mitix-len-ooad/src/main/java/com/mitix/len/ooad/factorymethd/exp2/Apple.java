package com.mitix.len.ooad.factorymethd.exp2;


/**
 * 创建于:2016年9月25日<br>
 * GPL 2016 a code farmer<br>
 * 苹果
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class Apple implements Fruit {
  private int treeAge;

  /*
   * (non-Javadoc)
   * 
   * @see com.mitix.len.ooad.simplefactory.Fruit#grow()
   */
  public void grow() {
    System.out.println("apple is grow");
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.mitix.len.ooad.simplefactory.Fruit#harvest()
   */
  public void harvest() {
    System.out.println("apple is harvest");
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.mitix.len.ooad.simplefactory.Fruit#plant()
   */
  public void plant() {
    System.out.println("apple is plant");
  }

  public int getTreeAge() {
    return treeAge;
  }

  public void setTreeAge(int treeAge) {
    this.treeAge = treeAge;
  }


}

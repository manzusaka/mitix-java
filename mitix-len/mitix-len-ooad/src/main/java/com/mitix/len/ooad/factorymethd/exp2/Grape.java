package com.mitix.len.ooad.factorymethd.exp2;

/**
 * 创建于:2016年9月25日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version TODO
 */
public class Grape implements Fruit {
  private boolean seedless;

  /*
   * (non-Javadoc)
   * 
   * @see com.mitix.len.ooad.simplefactory.Fruit#grow()
   */
  public void grow() {
    System.out.println("Grape is grow");

  }

  /*
   * (non-Javadoc)
   * 
   * @see com.mitix.len.ooad.simplefactory.Fruit#harvest()
   */
  public void harvest() {
    System.out.println("Grape is harvest");

  }

  /*
   * (non-Javadoc)
   * 
   * @see com.mitix.len.ooad.simplefactory.Fruit#plant()
   */
  public void plant() {
    System.out.println("Grape is plant");

  }

  public boolean isSeedless() {
    return seedless;
  }

  public void setSeedless(boolean seedless) {
    this.seedless = seedless;
  }

}

package com.mitix.len.ooad.factorymethd.exp2;

/**
 *创建于:2016年9月25日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * @author infoconsole
 * @version TODO
 */
public class AppleGardener implements FruitGardener {

  /* (non-Javadoc)
   * @see FruitGardener#create()
   */
  @Override
  public Fruit create() {
    return new Apple();
  }

}

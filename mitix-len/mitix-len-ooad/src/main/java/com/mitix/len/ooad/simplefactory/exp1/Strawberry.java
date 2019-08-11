package com.mitix.len.ooad.simplefactory.exp1;

/**
 *创建于:2016年9月25日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * @author infoconsole
 * @version TODO
 */
public class Strawberry implements Fruit {

  /* (non-Javadoc)
   * @see com.mitix.len.ooad.simplefactory.Fruit#grow()
   */
  @Override
  public void grow() {
    System.out.println("Strawberry is grow");

  }

  /* (non-Javadoc)
   * @see com.mitix.len.ooad.simplefactory.Fruit#harvest()
   */
  @Override
  public void harvest() {
    System.out.println("Strawberry is harvest");

  }

  /* (non-Javadoc)
   * @see com.mitix.len.ooad.simplefactory.Fruit#plant()
   */
  @Override
  public void plant() {
    System.out.println("Strawberry is plant");

  }

}

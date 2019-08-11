package com.mitix.len.ooad.abstractfactory;

/**
 * 创建于:2016年9月25日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version TODO
 */
public class UsaStrawberry implements Strawberry {

  /*
   * (non-Javadoc)
   * 
   * @see com.mitix.len.ooad.simplefactory.Fruit#grow()
   */
  public void grow() {
    System.out.println("UsaStrawberry is grow");

  }


  public void strawberryPlant() {
    System.out.println("UsaStrawberry is plant");

  }

}

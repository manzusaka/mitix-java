/**
 * 
 */
package com.mitix.len.ooad.simplefactory.exp1_1;

/**
 *创建于:2016年9月16日<br>
 *GPL 2016 a code farmer<br>
 * TODO
 * @author infoconsole
 * @version 1.0.0
 */
public class Test {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Car car= Car.getInstance();
    System.out.println(car.toString());
    car.run();
  }

}

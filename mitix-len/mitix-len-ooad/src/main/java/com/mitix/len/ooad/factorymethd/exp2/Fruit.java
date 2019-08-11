package com.mitix.len.ooad.factorymethd.exp2;

/**
 *创建于:2016年9月25日<br>
 * GPL 2016 a code farmer<br>
 * 定义水果的一些共同特性
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public interface Fruit {
  
  /**
   * 生长
   */
  public void grow();
  
  /**
   * 收获
   */
  public void harvest();
  
  /**
   * 种植
   */
  public void plant();
}

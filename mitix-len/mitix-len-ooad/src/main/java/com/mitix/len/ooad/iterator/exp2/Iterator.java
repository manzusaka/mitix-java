package com.mitix.len.ooad.iterator.exp2;

/**
 * 创建于:2016年10月16日<br>
 * GPL 2016 a code farmer<br>
 * 抽象迭代子角色类
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public interface Iterator {
  /**
   * 迭代方法：移动到第一个元素
   */
  public void first();

  /**
   * 迭代方法：移动到下一个元素
   */
  public void next();

  /**
   * 迭代方法：是否为最后一个元素
   */
  public boolean isDone();

  /**
   * 迭代方法：返还当前元素
   */
  public Object currentItem();
}

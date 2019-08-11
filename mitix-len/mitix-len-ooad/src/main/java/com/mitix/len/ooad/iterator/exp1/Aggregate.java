package com.mitix.len.ooad.iterator.exp1;


/**
 * 
 *创建于:2016年10月22日<br>
 * GPL 2016 a code farmer<br>
 * 抽象聚集角色
 * @author infoconsole
 * @version 1.0.0
 */
public abstract class Aggregate {
  /**
   * 工厂方法，创建相应迭代子对象的接口
   */
  public abstract Iterator createIterator();
}

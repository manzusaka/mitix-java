package com.mitix.len.ooad.observer.exp1;


/**
 * 
 * 创建于:2016年8月20日<br>
 * GPL 2016 a code farmer<br>
 * 观察者接口--定义一个更新的接口给那些在目标发生改变的时候需要被通知的对象
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public interface ObServer {
  /**
   * 传入对象 获取对应对象的信息
   * 
   * @param subject
   */
  public void update(Subject subject);
}

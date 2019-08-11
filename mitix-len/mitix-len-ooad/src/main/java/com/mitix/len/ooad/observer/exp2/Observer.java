package com.mitix.len.ooad.observer.exp2;

/**
 * 
 * 创建于:2016年9月5日<br>
 * GPL 2016 a code farmer<br>
 * 观察者接口--定义一个更新的接口给那些在目标发生改变的时候需要被通知的对象
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public interface Observer {
  /**
   * 传入对象 获取对应对象的信息
   * 
   * @param subject
   */
  public void update(@SuppressWarnings("rawtypes") Subject subject);

  /**
   * 这个是一个推模型
   * 
   * @param t
   */
  public <T> void update2(T t);
}

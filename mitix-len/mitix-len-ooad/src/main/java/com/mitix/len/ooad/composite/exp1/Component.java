package com.mitix.len.ooad.composite.exp1;
/**
 * 
 *创建于:2016年10月29日<br>
 * GPL 2016 a code farmer<br>
 * 抽象构件角色
 * @author infoconsole
 * @version 1.0.0
 */
public interface Component {
  /**
   * 返回本身实例
   * @return
   */
  public Composite getComposite();
  /**
   * 商业方法
   */
  public void eachChild();
}

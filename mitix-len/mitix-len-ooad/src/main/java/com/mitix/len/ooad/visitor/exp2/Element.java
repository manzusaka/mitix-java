package com.mitix.len.ooad.visitor.exp2;

/**
 *创建于:2016年10月29日<br>
 * GPL 2016 a code farmer<br>
 * 计算薪水的抽象接类
 * @author infoconsole
 * @version TODO
 */
public abstract class Element {
  public abstract void Accept(Visitor visitor);
}

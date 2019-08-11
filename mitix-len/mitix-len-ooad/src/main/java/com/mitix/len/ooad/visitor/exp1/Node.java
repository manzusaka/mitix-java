package com.mitix.len.ooad.visitor.exp1;

/**
 * 创建于:2016年10月29日<br>
 * GPL 2016 a code farmer<br>
 * 抽象的节点
 * 
 * @author infoconsole
 * @version TODO
 */
public abstract class Node {
  public abstract void accept(Visitor visitor);
}

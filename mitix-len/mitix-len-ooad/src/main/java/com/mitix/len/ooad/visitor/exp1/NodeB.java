package com.mitix.len.ooad.visitor.exp1;

/**
 * 创建于:2016年10月29日<br>
 * GPL 2016 a code farmer<br>
 * 具体节点角色
 * 
 * @author infoconsole
 * @version TODO
 */
public class NodeB extends Node {

  /*
   * (non-Javadoc)
   * 
   * @see Node#accept(Visitor)
   */
  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);

  }

  public String operationB() {
    return "this is nodeB";
  }
}

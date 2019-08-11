package com.mitix.len.ooad.visitor.exp1;

/**
 * 
 * 创建于:2016年10月29日<br>
 * GPL 2016 a code farmer<br>
 * 抽象访问者
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public interface Visitor {
  /**
   * 访问操作
   * 
   * @param nodeA
   */
  public void visit(NodeA nodeA);

  /**
   * 
   * @param nodeB
   */
  public void visit(NodeB nodeB);

}

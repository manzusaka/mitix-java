package com.mitix.len.ooad.visitor.exp1;

/**
 * 创建于:2016年10月29日<br>
 * GPL 2016 a code farmer<br>
 * 具体的访问者对象
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class VisitorA implements Visitor {


  public void visit(NodeA nodeA) {

    System.out.println(nodeA.operationA());

  }
  
  public void visit(NodeB nodeB) {

    System.out.println(nodeB.operationB());

  }


}

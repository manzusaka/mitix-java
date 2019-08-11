package com.mitix.len.ooad.visitor.exp1;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建于:2016年10月29日<br>
 * GPL 2016 a code farmer<br>
 * 结构对象
 * 
 * @author infoconsole
 * @version TODO
 */
public class ObjectStructure {
  private List<Node> nodes=new ArrayList<Node>();
  
  public void action(Visitor visitor) {
    for (Node node : nodes) {
      node.accept(visitor);
    }
  }

  public void add(Node node) {
    nodes.add(node);
  }
}

package com.mitix.len.ooad.visitor.exp1;


public class ObjectStructureTest {

  public static void main(String[] args) {
    
    ObjectStructure os = new ObjectStructure();
    os.add(new NodeA());
    os.add(new NodeB());
    Visitor visitor = new VisitorA();
    os.action(visitor);
  }


}

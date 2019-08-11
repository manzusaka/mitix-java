package com.mitix.len.ooad.composite.exp2;

public class ComponentTest {
  public static void main(String[] args) {
    {
      Composite root=new Composite("Element1");
      System.out.println(root);
      Composite element2=new Composite("Element2");
      Composite element3=new Composite("Element3");
      Leaf leaf1=new Leaf("Leaf1");
      Leaf leaf2=new Leaf("Leaf2");
      Leaf leaf3=new Leaf("Leaf3");
      root.add(element2);
      root.add(element3);
      element2.add(leaf1);
      element2.add(leaf2);
      element3.add(leaf3);
      Component componemt=(Component)root;
      System.out.println(componemt.getComposite());
      componemt.eachChild();
    }
  }
}

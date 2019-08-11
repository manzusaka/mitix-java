package com.mitix.len.ooad.composite.exp2;

import java.util.List;

/**
 *创建于:2016年10月29日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * @author infoconsole
 * @version TODO
 */
public class Leaf implements Component {
  private String name;
  
  public Leaf(String name){
    this.name=name;
  }
  /* (non-Javadoc)
   * @see Component#getComposite()
   */
  public Composite getComposite() {
    System.out.println("my name is "+name);
    return null;
  }

  /* (non-Javadoc)
   * @see Component#sampleOperation()
   */
  public void eachChild() {
    System.out.println(name+" say hello world");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  public void add(Component component) {
    
  }
  public void remove(Component component) {
    
  }
  public List<Component> components() {
    return null;
  }

}

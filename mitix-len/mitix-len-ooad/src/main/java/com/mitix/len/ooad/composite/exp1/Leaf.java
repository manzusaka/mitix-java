package com.mitix.len.ooad.composite.exp1;

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
  @Override
  public Composite getComposite() {
    System.out.println("my name is "+name);
    return null;
  }

  /* (non-Javadoc)
   * @see Component#sampleOperation()
   */
  @Override
  public void eachChild() {
    System.out.println(name+" say hello world");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}

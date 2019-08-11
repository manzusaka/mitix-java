package com.mitix.len.ooad.composite.exp2;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建于:2016年10月29日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version TODO
 */
public class Composite implements Component {
  private String name;
  private List<Component> componentList = new ArrayList<Component>();

  public Composite(String name) {
    this.name = name;
  }

  /*
   * (non-Javadoc)
   * 
   * @see Component#getComposite()
   */
  public Composite getComposite() {
    return this;
  }

  /*
   * (non-Javadoc)
   * 
   * @see Component#sampleOperation()
   */
  public void eachChild() {
    System.out.println(name+" say hello world");
    for(Component component:componentList){
      component.eachChild();
    }
  }

  public void add(Component component) {
    componentList.add(component);
  }

  public void remove(Component component) {
    componentList.remove(component);
  }

  public List<Component> components() {
    return componentList;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}

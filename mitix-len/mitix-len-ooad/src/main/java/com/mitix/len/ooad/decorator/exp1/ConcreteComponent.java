package com.mitix.len.ooad.decorator.exp1;

/**
 *创建于:2016年10月30日<br>
 * GPL 2016 a code farmer<br>
 * 具体构件
 * @author infoconsole
 * @version TODO
 */
public class ConcreteComponent implements Component {
  
  public ConcreteComponent(){
    
  }
  /* (non-Javadoc)
   * @see Component#sampleOperation()
   */
  @Override
  public void sampleOperation() {
   System.out.println("i an concretecomponent");

  }

}

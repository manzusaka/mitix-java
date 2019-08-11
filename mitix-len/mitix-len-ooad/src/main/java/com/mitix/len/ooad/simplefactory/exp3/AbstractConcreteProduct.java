package com.mitix.len.ooad.simplefactory.exp3;

/**
 *创建于:2016年9月25日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * @author infoconsole
 * @version TODO
 */
public abstract class AbstractConcreteProduct {
  public AbstractConcreteProduct(){
    
  }
  public static AbstractConcreteProduct create(){
    return new ConcreteProduct();
  }
}

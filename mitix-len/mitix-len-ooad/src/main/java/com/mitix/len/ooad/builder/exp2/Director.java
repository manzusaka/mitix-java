package com.mitix.len.ooad.builder.exp2;

/**
 *创建于:2016年10月4日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * @author infoconsole
 * @version TODO
 */
public class Director {
  private ConcreteBuilder builder=new ConcreteBuilder();
  
  public Product construct(){
    builder.buildPart1();
    builder.buildPart2();
    return builder.retrieveResult();
  }
  
}

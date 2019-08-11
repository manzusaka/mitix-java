package com.mitix.len.ooad.builder.exp3;

/**
 * 创建于:2016年10月4日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version TODO
 */
public class Builder {
  private Product product = new Product();

  public void buildPart1() {
    product.setName("oldflame");
    System.out.println("buildPart1");

  }

  public void buildPart2() {
    product.setTodo("test builder");
    System.out.println("buildPart2");

  }

  public Product retrieveResult() {
    return product;
  }
  
  public Product construct(){
    buildPart1();
    buildPart2();
    return retrieveResult();
  }

}

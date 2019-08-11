package com.mitix.len.ooad.builder.exp3;

public class BuilderTest {
  public static void main(String[] args) {
    Builder builder=new Builder();
    Product product=builder.construct();
    System.out.println(product.getName());
  }

}

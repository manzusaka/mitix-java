package com.mitix.len.ooad.builder.exp2;

public class DirectorTest {
  public static void main(String[] args) {
    Director director=new Director();
    Product product=director.construct();
    System.out.println(product.getName());
  }


}

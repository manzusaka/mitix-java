package com.mitix.len.ooad.factorymethd.exp2;

public class FruitGardenerTest {
  public static void main(String[] args) {
    FruitGardener gardener=new AppleGardener();
    System.out.println(gardener.create());
  }

  
}

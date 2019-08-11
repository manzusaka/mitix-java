package com.mitix.len.ooad.multiton.exp1;

public class DieTest {
  public static void main(String[] args) {
    Die die1=Die.getInstance(1);
    Die die2=Die.getInstance(2);
    System.out.println(die1.dice());
    System.out.println(die2.dice());
  }

}

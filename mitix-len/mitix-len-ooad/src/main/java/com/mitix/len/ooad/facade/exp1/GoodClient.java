package com.mitix.len.ooad.facade.exp1;

public class GoodClient {
  private static SecurityFacade sf = new SecurityFacade();

  public static void main(String[] args) {
    sf.activate();
  }
}

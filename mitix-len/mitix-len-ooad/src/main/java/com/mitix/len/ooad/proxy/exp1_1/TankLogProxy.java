package com.mitix.len.ooad.proxy.exp1_1;

public class TankLogProxy  implements Moveable {
  private Moveable t;

  public TankLogProxy(Moveable t) {
    super();
    this.t = t;
  }
  
  @Override
  public void move() {
    System.out.println("this is  a long start");
    t.move();
    System.out.println("this is  a long end");
  }

}

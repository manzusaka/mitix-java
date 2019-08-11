package com.mitix.len.ooad.proxy.exp1_1;

/**
 * 创建于:2016年6月5日<br>
 * 版权所有(C) 2016 one dream code farmer<br>
 * TODO
 * 
 * @author hlh19
 * @version TODO
 */
public class TankTimeProxy implements Moveable {
  private Moveable t;

  public TankTimeProxy(Moveable t) {
    super();
    this.t = t;
  }

  @Override
  public void move() {
    long start = System.currentTimeMillis();
    System.out.println("start time--"+start);
    t.move();
    long end = System.currentTimeMillis();
    System.out.println("end time--"+end);
  }

}

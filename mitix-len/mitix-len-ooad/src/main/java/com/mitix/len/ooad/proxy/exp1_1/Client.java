package com.mitix.len.ooad.proxy.exp1_1;

/**
 * 创建于:2016年6月5日<br>
 * 版权所有(C) 2016 one dream code farmer<br>
 * TODO
 * 
 * @author hlh19
 * @version TODO
 */
public class Client {
  public static void main(String[] args) {
    Moveable tproxy = new TankTimeProxy(new TankLogProxy(new Tank()));
    tproxy.move();
    
    Moveable lproxy=new TankLogProxy(new TankTimeProxy(new Tank()));
    lproxy.move();
  }
}

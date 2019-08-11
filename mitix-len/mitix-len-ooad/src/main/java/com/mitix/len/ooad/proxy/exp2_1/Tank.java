package com.mitix.len.ooad.proxy.exp2_1;

import java.util.Random;

/**
 * 创建于:2016年6月5日<br>
 * 版权所有(C) 2016 one dream code farmer<br>
 * TODO
 * 
 * @author hlh19
 * @version TODO
 */
public class Tank implements Moveable {

  @Override
  public void move() {
    
    System.out.println("Tank Moveing...");
    try {
      Thread.sleep(new Random().nextInt(10000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


  }

}

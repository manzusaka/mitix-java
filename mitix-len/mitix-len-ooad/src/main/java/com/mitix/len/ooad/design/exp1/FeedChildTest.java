package com.mitix.len.ooad.design.exp1;

/**
 * 
 *创建于:2016年9月5日<br>
 * GPL 2016 a code farmer<br>
 * bad  exp  test
 * @author infoconsole
 * @version 1.0.0
 */
public class FeedChildTest {
  
  public static void main(String[] args) {
    Child c=new Child();
    new Thread(c).start();
    new Thread(new Dad(c)).start();
  }

}

package com.mitix.len.ooad.filter.exp1;

/**
 *创建于:2016年10月22日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * @author infoconsole
 * @version TODO
 */
public class Client {
  private static Handler handler1;
  private static Handler handler2;
  /**
   * @param args
   */
  public static void main(String[] args) {
    handler1=new ConcreteHandler();
    handler2=new ConcreteHandler();
    handler1.setHandler(handler2);
    handler1.handleRequest();
  }

}

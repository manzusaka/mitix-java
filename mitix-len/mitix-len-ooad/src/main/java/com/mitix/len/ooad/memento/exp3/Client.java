package com.mitix.len.ooad.memento.exp3;

/**
 * 创建于:2016年10月5日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * 
 * @author infoconsole
 * @version TODO
 */
public class Client {
  private static Originator o = new Originator();
  private static Caretaker c = new Caretaker(o);
  
  public static void main(String[] args) {
    o.setState("On");
    c.createMemento();
    o.setState("Off");
    c.restoreMemento();
    System.out.println(o.getState());
  }
}

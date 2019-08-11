package com.mitix.len.ooad.observer.exp1;

/**
 *创建于:2016年10月11日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * @author infoconsole
 * @version TODO
 */
public class Test {

  /**
   * @param args
   */
  public static void main(String[] args) {
    ConcreteObServer observer=new ConcreteObServer();
    ConcreteSubject subject=new ConcreteSubject();
    
    subject.attach(observer);
    
    subject.setSubjectState("123456789");
    
    subject.notifyObServer();
  }

}

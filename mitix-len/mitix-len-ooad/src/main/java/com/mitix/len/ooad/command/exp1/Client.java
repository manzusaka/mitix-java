package com.mitix.len.ooad.command.exp1;

/**
 * 创建于:2016年10月22日<br>
 * GPL 2016 a code farmer<br>
 * 客户端
 * 
 * @author infoconsole
 * @version TODO
 */
public class Client {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Receiver receiver = new Receiver();
    
    Commond commond = new ConcreteCommond(receiver);
    
    Invoker invoker = new Invoker(commond);
    
    invoker.action();


  }

}

package com.mitix.len.ooad.command.exp1;
/**
 * 
 *创建于:2016年10月22日<br>
 * GPL 2016 a code farmer<br>
 * 具体的命令对象  持有执行者的引用
 * @author infoconsole
 * @version TODO
 */
public class ConcreteCommond implements Commond {
  private Receiver receiver;
  
  public ConcreteCommond(Receiver receiver) {
    this.receiver=receiver;
  }
  public void execute() {
    receiver.action();
  }

}

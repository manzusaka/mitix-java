package com.mitix.len.ooad.command.exp1;

/**
 * 创建于:2016年10月22日<br>
 * GPL 2016 a code farmer<br>
 * 命令的传递者  就是送信的
 * 
 * @author infoconsole
 * @version TODO
 */
public class Invoker {
  private Commond commond;

  public Invoker(Commond commond) {
    this.commond = commond;
  }

  public void action() {
    commond.execute();
  }
}

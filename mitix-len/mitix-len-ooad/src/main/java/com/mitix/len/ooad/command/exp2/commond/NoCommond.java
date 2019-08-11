package com.mitix.len.ooad.command.exp2.commond;

/**
 *创建于:2016年10月22日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * @author infoconsole
 * @version TODO
 */
public class NoCommond implements Commond {

  /* (non-Javadoc)
   * @see Commond#execute()
   */
  public void execute() {
    System.out.println("我是一个默认的按钮  什么都不实现");

  }

  /* (non-Javadoc)
   * @see Commond#undo()
   */
  public void undo() {
    
  }

}

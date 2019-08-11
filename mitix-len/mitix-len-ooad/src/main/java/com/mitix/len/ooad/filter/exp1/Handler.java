package com.mitix.len.ooad.filter.exp1;

/**
 *创建于:2016年10月22日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * @author infoconsole
 * @version TODO
 */
public abstract class Handler {

  private Handler handler;
  
  /*
   * 处理此方法，调用此方法的请求
   */
  public abstract void handleRequest();
  
  public Handler getHandler() {
    return handler;
  }
  
  /**
   * 设置下一个处理着
   * @param handler
   */
  public void setHandler(Handler handler) {
    this.handler = handler;
  }
  
  
  
}

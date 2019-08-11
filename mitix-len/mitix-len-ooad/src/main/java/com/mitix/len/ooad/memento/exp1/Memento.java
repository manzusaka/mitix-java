package com.mitix.len.ooad.memento.exp1;

/**
 * 创建于:2016年10月5日<br>
 * GPL 2016 a code farmer<br>
 * 备忘录角色
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class Memento {

  private String state;

  public Memento(String state) {
    this.state = state;
  }
  
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

}

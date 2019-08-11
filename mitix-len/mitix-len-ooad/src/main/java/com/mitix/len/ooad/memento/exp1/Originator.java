package com.mitix.len.ooad.memento.exp1;

/**
 * 创建于:2016年10月5日<br>
 * GPL 2016 a code farmer<br>
 * 发起人角色
 * 
 * @author infoconsole
 * @version 1.0.0
 */
public class Originator {
  private String state;

  public Memento createMemento() {
    return new Memento(state);
  }

  public void restoreMemento(Memento memento) {
    this.state = memento.getState();
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
    System.out.println("now  set current state=" + this.state);
  }



}

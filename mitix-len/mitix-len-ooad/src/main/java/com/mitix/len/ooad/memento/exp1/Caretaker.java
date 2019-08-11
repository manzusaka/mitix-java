package com.mitix.len.ooad.memento.exp1;

/**
 *创建于:2016年10月5日<br>
 * GPL 2016 a code farmer<br>
 * 责任人角色
 * @author infoconsole
 * @version 1.0.0
 */
public class Caretaker {
  private Memento memento;
  
  public Memento retrieveMemento(){
    return  this.memento;
  }
  
  public void saveMemento(Memento memento){
    this.memento=memento;
  }
}

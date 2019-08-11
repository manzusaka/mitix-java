package com.mitix.len.ooad.memento.exp3;

/**
 *创建于:2016年10月5日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * @author infoconsole
 * @version TODO
 */
public class Caretaker {
  private Originator.Memento memento;
  private Originator originator;
  
  public Caretaker(Originator o){
    this.originator=o;
  }
  
  public void createMemento() {
    this.memento=this.originator.createMemento();
  }

  public void restoreMemento() {
    this.originator.restoreMemento(this.memento);
  }

  public Originator getOriginator() {
    return originator;
  }

  public void setOriginator(Originator originator) {
    this.originator = originator;
  }
}

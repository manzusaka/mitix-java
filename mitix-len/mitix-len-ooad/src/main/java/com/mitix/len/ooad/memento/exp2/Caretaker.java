package com.mitix.len.ooad.memento.exp2;

/**
 *创建于:2016年10月5日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 * @author infoconsole
 * @version TODO
 */
public class Caretaker {
  private MementoInfo memento;
  
  public MementoInfo retrieveMemento(){
    return  this.memento;
  }
  
  public void saveMemento(MementoInfo memento){
    this.memento=memento;
  }

  public MementoInfo getMemento() {
    return memento;
  }

  public void setMemento(MementoInfo memento) {
    this.memento = memento;
  }
}
